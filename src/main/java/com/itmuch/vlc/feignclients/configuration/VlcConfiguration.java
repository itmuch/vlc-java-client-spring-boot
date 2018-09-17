package com.itmuch.vlc.feignclients.configuration;

import com.itmuch.vlc.configuration.VlcPasswordConfigurationProperties;
import com.itmuch.vlc.feignclients.configuration.converter.PlainTextMessageConverter;
import com.itmuch.vlc.feignclients.configuration.converter.UniversalReversedEnumConverter;
import feign.Contract;
import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.format.support.FormattingConversionService;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置类
 *
 * @author 周立
 */
public class VlcConfiguration {
    @Autowired
    private VlcPasswordConfigurationProperties vlcPasswordConfigurationProperties;
    @Autowired(required = false)
    private List<AnnotatedParameterProcessor> parameterProcessors = new ArrayList<>();

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("", this.vlcPasswordConfigurationProperties.getPassword());
    }

    /**
     * 初始化拦截器，发出text/plain格式的数据
     *
     * @return 拦截器
     */
    @Bean
    public RequestInterceptor headerRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("Content-Type", "text/plain");
    }

    /**
     * 初始化解码器，支持text/plain格式数据的解码
     *
     * @return 解码器
     */
    @Bean
    public Decoder feignDecoder() {
        PlainTextMessageConverter converter = new PlainTextMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(converter);
        return new SpringDecoder(objectFactory);
    }

    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.BASIC;
    }


    /**
     * 让Feign支持枚举
     * 参考：https://blog.csdn.net/u014527058/article/details/79396998
     *
     * @param feignConversionService service
     * @return contract
     */
    @Bean
    public Contract feignContract(FormattingConversionService feignConversionService) {
        // 在原配置类中是用ConversionService类型的参数，但ConversionService接口不支持addConverter操作，
        // 使用FormattingConversionService仍然可以实现feignContract配置。
        feignConversionService.addConverter(new UniversalReversedEnumConverter());
        return new SpringMvcContract(this.parameterProcessors, feignConversionService);
    }

}


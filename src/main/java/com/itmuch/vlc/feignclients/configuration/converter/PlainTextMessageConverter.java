package com.itmuch.vlc.feignclients.configuration.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * converter，允许接收text/plain格式的数据
 * 参考：https://blog.csdn.net/a610786189/article/details/80508353
 *
 * @author 周立
 */
public class PlainTextMessageConverter extends MappingJackson2HttpMessageConverter {
    public PlainTextMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }
}
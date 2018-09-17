package com.itmuch.vlc.feignclients.configuration.converter;

import com.itmuch.vlc.feignclients.configuration.enums.NamedEnum;
import org.springframework.core.convert.converter.Converter;

/**
 * 支持枚举的converter
 * 参考：https://blog.csdn.net/u014527058/article/details/79396998
 *
 * @author 周立
 */
public class UniversalReversedEnumConverter implements Converter<NamedEnum, String> {
    @Override
    public String convert(NamedEnum source) {
        return source.getName();
    }
}

package com.itmuch.vlc.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 周立
 */
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "vlc.http.password")
@Data
@Component
public class VlcPasswordConfigurationProperties {
    private String password;
}

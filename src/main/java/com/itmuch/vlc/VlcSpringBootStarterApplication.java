package com.itmuch.vlc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VlcSpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlcSpringBootStarterApplication.class, args);
    }
}

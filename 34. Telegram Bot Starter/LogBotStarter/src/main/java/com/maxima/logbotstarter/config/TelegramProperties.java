package com.maxima.logbotstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "log-bot")
public class TelegramProperties {

    private String name;
    private String token;
    private String projectName;
}

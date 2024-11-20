package com.maxima.logbotstarter.config;

import com.maxima.logbotstarter.service.MainService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TelegramProperties.class)
public class AutoConfigurationTelegramLogger {

    @Bean
    public MainService mainService(@Qualifier("log-bot-com.maxima.logbotstarter.config.TelegramProperties") TelegramProperties properties
    ) {
        return new MainService(properties);
    }
}

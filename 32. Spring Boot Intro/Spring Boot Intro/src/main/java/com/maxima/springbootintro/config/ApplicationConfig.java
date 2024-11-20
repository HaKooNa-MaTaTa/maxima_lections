package com.maxima.springbootintro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = "com.maxima.springbootintro")
@EnableWebMvc
public class ApplicationConfig {

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver fm = new FreeMarkerViewResolver();
        fm.setPrefix("");
        fm.setSuffix(".ftlh");
        fm.setContentType("text/html;charset=UTF-8");
        return fm;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/templates/");
        return freeMarkerConfigurer;
    }
}

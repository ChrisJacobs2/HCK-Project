package com.csc340sp23;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Anonymous
 * I found this code online. The purpose of this class is to configure the 
 * springboot server so that it serves content in src/main/resources/static
 * 
 * I am considering removing this class as I can just host the images online. -- Chris Jacobs
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600); // cache for one hour
    }
}

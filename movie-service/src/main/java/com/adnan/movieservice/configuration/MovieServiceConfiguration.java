package com.adnan.movieservice.configuration;

import com.adnan.movieservice.service.HomeService;
import com.adnan.movieservice.service.impl.HomeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieServiceConfiguration {
    @Bean
    public HomeService getHomeService(){
        return new HomeServiceImpl();
    }
}

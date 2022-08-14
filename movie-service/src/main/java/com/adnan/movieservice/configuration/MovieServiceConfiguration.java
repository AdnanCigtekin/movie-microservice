package com.adnan.movieservice.configuration;

import com.adnan.movieservice.service.CommonMovieService;
import com.adnan.movieservice.service.TypeCastService;
import com.adnan.movieservice.service.impl.CommonMovieServiceImpl;
import com.adnan.movieservice.service.impl.TypeCastServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieServiceConfiguration {
    @Bean
    public TypeCastService getHomeService(){
        return new TypeCastServiceImpl();
    }

    @Bean
    public CommonMovieService getCommonMovieService(){
        return new CommonMovieServiceImpl();
    }
}

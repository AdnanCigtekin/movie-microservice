package com.adnan.circuitbreaker.configuration;

import com.adnan.circuitbreaker.service.MovieService;
import com.adnan.circuitbreaker.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfiguration {
    @Bean
    @Qualifier("movieService")
    public MovieService getMovieService(){
        return new MovieServiceImpl();
    }
}

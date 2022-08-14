package com.adnan.circuitbreaker.controller;


import com.adnan.circuitbreaker.service.MovieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieServiceController {

    Logger logger = LoggerFactory.getLogger(MovieServiceController.class);
    @Autowired
    @Qualifier("movieService")
    private MovieService movieService;

    @GetMapping("type-casted")
    @CircuitBreaker(name="MovieServiceCircuitBreaker",fallbackMethod = "typecastFallback")
    public String getTypecasted(@RequestParam("name") String name){
        return movieService.getTypecasted(name);
    }

    public String typecastFallback(Exception e){
        logger.error("Movie microservice is unavailable: \n Cause : \n {}\n Stacktrace: \n {}",e.getCause(),e.getStackTrace());
        return "Service unavailable now. Try again later...";
    }
}

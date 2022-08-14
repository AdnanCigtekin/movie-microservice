package com.adnan.circuitbreaker.service.impl;

import com.adnan.circuitbreaker.service.MovieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Override

    public String getTypecasted(String name) {
        return new RestTemplate()
                    .getForObject("http://localhost:9090/type-casted?name={name}",
                            String.class, name);

    }

    @Override
    public List<String> getCommonMovies(String nameOne, String nameTwo) {
        return new RestTemplate()
                .getForObject("http://localhost:9090/common-movie?nameOne={nameOne}&nameTwo={nameTwo}",
                        ArrayList.class, nameOne,nameTwo);
    }


}

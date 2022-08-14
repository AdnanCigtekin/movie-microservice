package com.adnan.movieservice.service.impl;

import com.adnan.movieservice.repository.ActorRepository;
import com.adnan.movieservice.repository.MovieRepository;
import com.adnan.movieservice.service.CommonMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

public class CommonMovieServiceImpl implements CommonMovieService {


    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<String> getCommonMovies(String nameOne, String nameTwo) {
        List<String> res = movieRepository.getCommonMovies(nameOne,nameTwo);

        if (CollectionUtils.isEmpty(res)) {
            return new LinkedList<>();
        }

        return res;
    }

}

package com.adnan.movieservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommonMovieService {
    public List<String> getCommonMovies(String nameOne, String nameTwo);
}

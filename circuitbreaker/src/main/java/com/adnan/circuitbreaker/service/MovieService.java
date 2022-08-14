package com.adnan.circuitbreaker.service;

import java.util.List;

public interface MovieService {
    public String getTypecasted(String name);
    public List<String> getCommonMovies(String nameOne, String nameTwo);
}

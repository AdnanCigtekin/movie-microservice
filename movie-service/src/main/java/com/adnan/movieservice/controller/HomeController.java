package com.adnan.movieservice.controller;

import com.adnan.movieservice.service.CommonMovieService;
import com.adnan.movieservice.service.TypeCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private TypeCastService typeCastService;
    @Autowired
    private CommonMovieService commonMovieService;

    @GetMapping("type-casted")
    public String TypeCastingController(@RequestParam(value="name") String name){
        return typeCastService.isTypeCasted(name);
    }

    @GetMapping("common-movie")
    public List<String> CommonMovieController(@RequestParam(value="nameOne") String nameOne, @RequestParam(value="nameTwo") String nameTwo){
        return commonMovieService.getCommonMovies(nameOne,nameTwo);
    }

}

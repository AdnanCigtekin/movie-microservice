package com.adnan.movieservice.controller;

import com.adnan.movieservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;


    @GetMapping("type-casted")
    public String TypeCastingController(@RequestParam(value="name") String name){
        return homeService.isTypeCasted(name);
    }

}

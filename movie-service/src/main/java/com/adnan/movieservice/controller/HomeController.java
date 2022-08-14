package com.adnan.movieservice.controller;

import com.adnan.movieservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    // TODO: Implement correct algorithm here
    @GetMapping("type-casted")
    public String TypeCastingController(@RequestParam(value="name") String name){
        homeService.isTypeCasted(name);
        return name;
    }

}
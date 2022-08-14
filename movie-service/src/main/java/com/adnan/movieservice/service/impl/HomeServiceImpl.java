package com.adnan.movieservice.service.impl;

import com.adnan.movieservice.dto.ActorGenresDto;
import com.adnan.movieservice.repository.ActorRepository;
import com.adnan.movieservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public String isTypeCasted(String actorName) {
        List<ActorGenresDto> res = actorRepository.getActorGenres(actorName);

        if (CollectionUtils.isEmpty(res)) {
            return "No actor";
        }
        return detectTypecast(res);
    }

    protected String detectTypecast(List<ActorGenresDto> res){
        Integer maxGenreAmount = res.get(0).getGenreAmount();
        Integer totalMovies = maxGenreAmount;
        for(int i = 1; i < res.size(); i++ ){
            Integer currentGenreAmount = res.get(i).getGenreAmount();
            if(maxGenreAmount < currentGenreAmount){
                maxGenreAmount = currentGenreAmount;
            }
            totalMovies += currentGenreAmount;
        }

        if(maxGenreAmount >= totalMovies / 2f){
            return "typecasted";
        }

        return "not typecasted";
    }
}

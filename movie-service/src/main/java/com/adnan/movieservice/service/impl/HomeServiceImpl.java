package com.adnan.movieservice.service.impl;

import com.adnan.movieservice.dto.ActorGenresDto;
import com.adnan.movieservice.repository.ActorRepository;
import com.adnan.movieservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public String isTypeCasted(String actorName) {
        List<Tuple> res = actorRepository.getActorGenres(actorName);

        if (CollectionUtils.isEmpty(res)) {
            return "No actor";
        }

        List<ActorGenresDto> actorGenresDtos = res.stream()
                .map(e -> new ActorGenresDto(
                        e.get(0,String.class),
                        e.get(1, BigInteger.class).intValue()
                )).collect(Collectors.toList());

        return detectTypecast(actorGenresDtos);
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

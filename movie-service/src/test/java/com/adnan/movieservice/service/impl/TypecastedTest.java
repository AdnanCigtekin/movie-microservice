package com.adnan.movieservice.service.impl;

import com.adnan.movieservice.dto.ActorGenresDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TypecastedTest {


    @Test
    public void testTypecastedActor(){

        List<ActorGenresDto> actorGenresDtos = new LinkedList<>();
        actorGenresDtos.add(new ActorGenresDto("Documentary",2));
        actorGenresDtos.add(new ActorGenresDto("Horror",1));

        String result = new TypeCastServiceImpl(){
            public String callDetectTypecast(List<ActorGenresDto> actorGenres){
                return detectTypecast(actorGenres);
            }
        }.callDetectTypecast(actorGenresDtos);

        Assert.assertEquals("typecasted",result);
    }

    @Test
    public void testNotTypecastedActor(){

        List<ActorGenresDto> actorGenresDtos = new LinkedList<>();
        actorGenresDtos.add(new ActorGenresDto("Documentary",2));
        actorGenresDtos.add(new ActorGenresDto("Horror",3));
        actorGenresDtos.add(new ActorGenresDto("Action",2));
        String result = new TypeCastServiceImpl(){
            public String callDetectTypecast(List<ActorGenresDto> actorGenres){
                return detectTypecast(actorGenres);
            }
        }.callDetectTypecast(actorGenresDtos);

        Assert.assertEquals("not typecasted",result);
    }


}

package com.adnan.movieservice.repository;

import com.adnan.movieservice.model.ActorModel;
import com.adnan.movieservice.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieModel,String> {
    @Query(value = "CALL GET_COMMON_MOVIES(:ACTOR_NAME_ONE,:ACTOR_NAME_TWO);", nativeQuery = true)
    List<String> getCommonMovies(@Param("ACTOR_NAME_ONE")String nameOne, @Param("ACTOR_NAME_TWO")String nameTwo);
}

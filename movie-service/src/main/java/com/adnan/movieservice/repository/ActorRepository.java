package com.adnan.movieservice.repository;

import com.adnan.movieservice.dto.ActorGenresDto;
import com.adnan.movieservice.model.ActorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorModel,String> {

    @Query(value = "CALL GET_PLAYED_GENRES(:ACTOR_NAME);", nativeQuery = true)
    List<Tuple> getActorGenres(@Param("ACTOR_NAME")String name);
}

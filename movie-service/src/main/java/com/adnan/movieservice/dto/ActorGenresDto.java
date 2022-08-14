package com.adnan.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorGenresDto {
    private String genreName;
    private Integer genreAmount;
}

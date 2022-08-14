package com.adnan.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorGenresDto {
    private String genreName;
    private Integer genreAmount;
}

package com.example.growth.dto;

import com.example.growth.domain.PlantTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PlantDto {
    private String name;

    private String kind;

    //나이/단계/레벨
    private String grow;

    private PlantTypes card;

    private Integer waterDate;

    private LocalDateTime waterTime;

    private Boolean alarm;




}

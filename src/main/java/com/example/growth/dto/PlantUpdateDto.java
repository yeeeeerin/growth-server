package com.example.growth.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class PlantUpdateDto {
    private String name;
    private String grow;
    private Integer waterDate;
    private LocalDateTime waterTime;
    private Boolean alarm;
    private LocalDateTime raiseDate;
}

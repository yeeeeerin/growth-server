package com.example.growth.dto;

import com.example.growth.domain.PlantTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ApiModel
public class PlantDto {
    private String name;

    private String kind;

    //나이/단계/레벨
    private String grow;

    @ApiModelProperty(dataType = "string", allowableValues = "FLOWER, TREE, DRUPE, WILD_FLOWER, HERB")
    private PlantTypes card;

    private Integer waterDate;

    private LocalDateTime waterTime;

    private Boolean alarm;




}

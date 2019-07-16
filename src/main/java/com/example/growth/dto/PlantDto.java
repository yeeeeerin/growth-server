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
    @ApiModelProperty(notes="식물 이름")
    private String name;

    @ApiModelProperty(notes="식물 종류")
    private String kind;

    //나이/단계/레벨
    @ApiModelProperty(notes="나이/ 단계/ 레벨")
    private String grow;

    @ApiModelProperty(dataType = "string",notes = "일러스트 종류", allowableValues = "FLOWER, TREE, DRUPE, WILD_FLOWER, HERB")
    private PlantTypes card;

    @ApiModelProperty(notes="물 주는 주기")
    private Integer waterDate;

    @ApiModelProperty(notes="물 주는 시간")
    private LocalDateTime waterTime;

    @ApiModelProperty(notes="알람 여부")
    private Boolean alarm;




}

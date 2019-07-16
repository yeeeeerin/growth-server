package com.example.growth.dto;

import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
public class PlantCardDto {

    @ApiModelProperty(notes="식물 pk값")
    private Long id;
    @ApiModelProperty(notes="식물 이름")
    private String name;
    @ApiModelProperty(notes="식물 종류")
    private String kind;
    @ApiModelProperty(notes="식물 일러스트")
    private PlantTypes card;

    public static PlantCardDto from(Plant plant){
        return new PlantCardDto(plant.getId(),plant.getName(),plant.getKind(),plant.getCard());
    }
}

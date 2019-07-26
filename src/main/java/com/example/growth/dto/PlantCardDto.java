package com.example.growth.dto;

import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

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
    @ApiModelProperty(notes="애정지수")
    private Long love;
    @ApiModelProperty(notes="물 주기")
    private Integer waterCycle;
    @ApiModelProperty(notes="남은 물 날자")
    private Integer remainWaterDate;


    public static PlantCardDto from(Plant plant){
        Integer remainWaterDate= LocalDateTime.now().getDayOfYear() - plant.getWaterTime().getDayOfYear();
        remainWaterDate %= plant.getWaterDate();
        return new PlantCardDto(
                plant.getId(),
                plant.getName(),
                plant.getKind(),
                plant.getCard(),
                plant.getLove(),
                plant.getWaterDate(),
                remainWaterDate
        );
    }
}

package com.example.growth.dto;

import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import com.example.growth.dto.api.PlantInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class PlantDetailDto {

    private PlantInfo plantInfo;

    @ApiModelProperty(notes="식물 이름")
    private String name;

    @ApiModelProperty(notes="식물 종류")
    private String kind;

    @ApiModelProperty(notes="나이/ 단계/ 레벨")
    private String grow;

    @ApiModelProperty(dataType = "string",notes = "일러스트 종류", allowableValues = "FLOWER, TREE, DRUPE, WILD_FLOWER, HERB")
    private PlantTypes card;

    @ApiModelProperty(notes="남은 물주기 시간")
    private Integer waterDate;

    @ApiModelProperty(notes="애정")
    private Long love;

    @ApiModelProperty(notes="식물을 키우기 시작한 날")
    private LocalDateTime raiseDate;



    public static PlantDetailDto of(PlantInfo plantInfo, Plant plant){
        return new PlantDetailDto(plantInfo,
                plant.getName(),
                plant.getKind(),
                plant.getGrow(),
                plant.getCard(),
                (LocalDateTime.now().getDayOfYear() - plant.getRaiseDate().getDayOfYear())%plant.getWaterDate(),
                plant.getLove(),
                plant.getRaiseDate());
    }

}


package com.example.growth.dto;

import com.example.growth.domain.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlantCardDto {
    private Long id;
    private String name;
    private String kind;
    private String card;

    public static PlantCardDto from(Plant plant){
        return new PlantCardDto(plant.getId(),plant.getName(),plant.getKind(),plant.getCard());
    }
}

package com.example.growth;

import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import com.example.growth.domain.User;
import com.example.growth.dto.PlantDto;

import java.time.LocalDateTime;

public class Helper {

    public static User createUser(){
        return new User(1l,1l,"yerin","yerin","String",null);
    }

    public static Plant createPlant(User user){
        PlantDto plantDto = createPlantDto();
        return Plant.from(plantDto,user);
    }

    private static PlantDto createPlantDto(){
        return new PlantDto("다육이", "선인장","0",PlantTypes.DRUPE.name(),3, LocalDateTime.now(),true);
    }

}

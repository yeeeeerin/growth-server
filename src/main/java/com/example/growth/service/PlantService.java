package com.example.growth.service;


import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDetailDto;
import com.example.growth.dto.PlantDto;
import com.example.growth.dto.PlantUpdateDto;

import java.util.List;

public interface PlantService {
    void savePlant(PlantDto plantDto, Long userId);
    void updatePlant(PlantUpdateDto plantUpdateDto, Long userId, Long plantId);
    List<PlantCardDto> getPlants(int page, Long userId);
    void deletePlant(Long plantId, Long userId);

    PlantDetailDto getPlantDetail(Long id);

    Long updateLove(Long id);



    void dummy(Long userId);
}

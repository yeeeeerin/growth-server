package com.example.growth.service;


import com.example.growth.domain.Plant;
import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDto;

import java.util.List;

public interface PlantService {
    void savePlant(PlantDto plantDto, Long userId);
    List<PlantCardDto> getPlants(int page, Long userId);
    void deletePlant(Long plantId, Long userId);

    Plant getPlantDetail(Long id);

    Long updateLove(Long id);
}

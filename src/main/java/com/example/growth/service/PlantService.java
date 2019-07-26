package com.example.growth.service;


import com.example.growth.dto.*;

import java.util.List;

public interface PlantService {
    void savePlant(PlantDto plantDto, Long userId);
    void updatePlant(PlantUpdateDto plantUpdateDto, Long userId, Long plantId);
    List<PlantCardDto> getPlants(int page, Long userId);
    void deletePlant(Long plantId, Long userId);

    PlantDetailDto getPlantDetail(Long id);

    LoveDto updateLove(Long id);



    void dummy(Long userId);
}

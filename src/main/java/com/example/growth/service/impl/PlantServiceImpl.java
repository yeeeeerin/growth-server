package com.example.growth.service.impl;


import com.example.growth.domain.Plant;
import com.example.growth.dto.PlantDto;
import com.example.growth.repository.PlantRepository;
import com.example.growth.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public void savePlant(PlantDto plantDto){

        Plant plant = Plant.from(plantDto);
        plantRepository.save(plant);

    }

}

package com.example.growth.service.impl;


import com.example.growth.domain.Plant;
import com.example.growth.domain.User;
import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDto;
import com.example.growth.dto.api.PlantList;
import com.example.growth.exception.PlantNotFoundException;
import com.example.growth.exception.UserNotFoundException;
import com.example.growth.repository.PlantRepository;
import com.example.growth.repository.UserRepository;
import com.example.growth.service.PlantService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    @Override
    public void savePlant(PlantDto plantDto, Long userId){
        
        User user =  userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Plant plant = Plant.from(plantDto,user);
        plantRepository.save(plant);

    }

    @Override
    public List<PlantCardDto> getPlants(int page, Long userId){

        Pageable pageable = PageRequest.of(page, 10);
        return plantRepository.findAllByUserId(userId,pageable).stream()
                .map(PlantCardDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlant(Long plantId, Long userId){

        Plant plant = plantRepository.findByIdAndUserId(plantId,userId)
                .orElseThrow(PlantNotFoundException::new);
        plantRepository.delete(plant);
    }

    @Override
    public Plant getPlantDetail(Long id) {

        return plantRepository.findById(id).orElseThrow(PlantNotFoundException::new);
    }

}

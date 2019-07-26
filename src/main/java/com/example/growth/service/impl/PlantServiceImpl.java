package com.example.growth.service.impl;


import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import com.example.growth.domain.User;
import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDetailDto;
import com.example.growth.dto.PlantDto;
import com.example.growth.dto.PlantUpdateDto;
import com.example.growth.exception.PlantNotFoundException;
import com.example.growth.exception.UserNotFoundException;
import com.example.growth.repository.PlantRepository;
import com.example.growth.repository.UserRepository;
import com.example.growth.service.PlantInfoFetchService;
import com.example.growth.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;
    private final UserRepository userRepository;
    private final PlantInfoFetchService plantInfoFetchService;

    @Override
    public void savePlant(PlantDto plantDto, Long userId){

        plantDto.setWaterTime(plantDto.getWaterTime().minusNanos(plantDto.getWaterTime().getNano()));
        User user =  userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Plant plant = Plant.from(plantDto,user);
        plantRepository.save(plant);
    }

    @Override
    public void updatePlant(PlantUpdateDto plantUpdateDto, Long userId, Long plantId){

        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Plant plant = plantRepository.findById(plantId).orElseThrow(PlantNotFoundException::new);
        plant.setPlnat(plantUpdateDto);
        
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
    public PlantDetailDto getPlantDetail(Long id) {

        Plant plant = plantRepository.findById(id).orElseThrow(PlantNotFoundException::new);

        return PlantDetailDto.of(plantInfoFetchService.getPlantInfo(plant.getKind()),plant);
    }

    @Override
    public Long updateLove(Long id){
        Plant plant = plantRepository.findById(id)
                .orElseThrow(PlantNotFoundException::new);

        if(plant.getUpdateLove().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            plant.setLove();
        }

        return plant.getLove();
    }

    @Override
    public void dummy(Long userId){
        User user =  userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        for(int i=0;i<13;i++){

            PlantDto plantDto = new PlantDto("꿀꿀이"+i,
                    "가울테리아",
                    "낮음",
                    PlantTypes.FLOWER,
                    i,
                    LocalDateTime.now(),
                    true);
            Plant plant = Plant.from(plantDto,user);
            plantRepository.save(plant);

        }

    }

}

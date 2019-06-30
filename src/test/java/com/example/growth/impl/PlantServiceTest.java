package com.example.growth.impl;

import com.example.growth.domain.Plant;
import com.example.growth.dto.PlantDto;
import com.example.growth.repository.PlantRepository;
import com.example.growth.service.PlantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantServiceTest {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantService plantService;

    @Test
    public void 식물을_등록하면_plant테이블에_저장된다(){
        //given
        PlantDto plantDto = new PlantDto("꿀꿀이",
                        "장미",
                        "낮음",
                        "1",
                        "3",
                        true);

        //when
        plantService.savePlant(plantDto);

        //then
        Plant plant = plantRepository.findAll().get(0);

        assertThat(plantDto.getName()).isEqualTo(plant.getName());
        assertThat(plantDto.getKind()).isEqualTo(plant.getKind());
        assertThat(plantDto.getWater()).isEqualTo(plant.getWater());
    }

}
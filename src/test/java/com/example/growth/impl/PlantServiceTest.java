package com.example.growth.impl;

import com.example.growth.Helper;
import com.example.growth.domain.Plant;
import com.example.growth.domain.PlantTypes;
import com.example.growth.domain.User;
import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDto;
import com.example.growth.repository.PlantRepository;
import com.example.growth.repository.UserRepository;
import com.example.growth.service.PlantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PlantServiceTest {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantService plantService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void 식물을_등록하면_plant테이블에_저장된다(){

        //given
        User user = new User();
        userRepository.save(user);

        PlantDto plantDto = new PlantDto("꿀꿀이0",
                        "장미",
                        "낮음",
                PlantTypes.FLOWER,
                        3,
                        LocalDateTime.now(),
                        true);


        //when
        plantService.savePlant(plantDto,user.getId());


        //then
        Plant plant = plantRepository.findAll().get(0);

        assertThat(plantDto.getName()).isEqualTo(plant.getName());
        assertThat(plantDto.getKind()).isEqualTo(plant.getKind());
        assertThat(plantDto.getCard()).isEqualTo(plant.getCard());
    }

    @Test
    @Transactional
    public void 식물정보가_7개있는_테이블을_조회(){

        //given
        User user = new User();
        userRepository.save(user);

        System.out.println(userRepository.findAll().size());

        for(int i=0;i<7;i++){
            Plant plant = Helper.createPlant(user);
            plantRepository.save(plant);
        }

        System.out.println("plant!!"+plantRepository.findAll().size());

        //when
        //then
        List<PlantCardDto> plantList = plantService.getPlants(0,user.getId());

        assertThat(plantList.size()).isEqualTo(7);
    }

    @Test
    @Transactional
    public void 식물의_애정지수를_올립니다(){

        //given
        User user = Helper.createUser();
        userRepository.save(user);

        Plant plant = Helper.createPlant(user);
        plantRepository.save(plant);

        //when
        plantService.updateLove(plant.getId());

        //then
        Plant testPlant = plantRepository.findById(plant.getId()).get();
        assertThat(testPlant.getLove()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void 같은날에_식물의_애정지수를_두번올릴수없다(){
        //given
        User user = Helper.createUser();
        userRepository.save(user);

        Plant plant = Helper.createPlant(user);
        plantRepository.save(plant);

        //when
        plantService.updateLove(plant.getId());
        plantService.updateLove(plant.getId());


        //then
        Plant testPlant = plantRepository.findById(plant.getId()).get();
        assertThat(testPlant.getLove()).isEqualTo(1);

    }

}
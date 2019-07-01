package com.example.growth.controller;


import com.example.growth.dto.PlantCardDto;
import com.example.growth.dto.PlantDto;
import com.example.growth.dto.api.PlantInfo;
import com.example.growth.service.PlantInfoFetchService;
import com.example.growth.service.PlantService;
import com.example.growth.utils.auth.Auth;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlantController {

    private final PlantInfoFetchService plantInfoFetchService;
    private final PlantService plantService;

    @ApiOperation(value = "농사로 api로부터 식물 정보 가져오기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "식물이름", required = true, dataType = "string"),
    })
    @Auth
    @PostMapping("/getPlantInfo")
    public ResponseEntity<PlantInfo> getPlantInfo(@RequestParam String name){
        return new ResponseEntity<>(plantInfoFetchService.getPlantInfo(name), HttpStatus.OK);
    }

    @Auth
    @PostMapping("/savePlant")
    public ResponseEntity<String> savePlant(@RequestBody PlantDto plantDto, @RequestParam Long userId){
        plantService.savePlant(plantDto,userId);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

    @Auth
    @PostMapping("/plants")
    public ResponseEntity<List<PlantCardDto>> getPlants(@RequestParam int page, @RequestParam Long userId){
        List plants = plantService.getPlants(page, userId);
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

}

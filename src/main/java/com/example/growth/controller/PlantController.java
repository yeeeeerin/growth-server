package com.example.growth.controller;


import com.example.growth.dto.PlantDto;
import com.example.growth.dto.api.PlantInfo;
import com.example.growth.service.PlantInfoFetchService;
import com.example.growth.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlantController {

    private final PlantInfoFetchService plantInfoFetchService;
    private final PlantService plantService;

    @PostMapping("/getPlantInfo")
    public ResponseEntity<PlantInfo> getPlantInfo(@RequestParam String name){
        return new ResponseEntity<>(plantInfoFetchService.getPlantInfo(name), HttpStatus.OK);
    }

    @PostMapping("/savePlant")
    public ResponseEntity<String> savePlant(@RequestBody PlantDto plantDto){
        plantService.savePlant(plantDto);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }

}

package com.example.growth.controller;


import com.example.growth.dto.*;
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


    @ApiOperation(value = "키워드로 농사로 api로부터 식물 리스트 가져오기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word", value = "식물 키워드", required = true, dataType = "string"),
    })
    @Auth
    @PostMapping("/getPlantNames")
    public ResponseEntity<List<String>> getPlantNames(@RequestParam String word){
        return new ResponseEntity<>(plantInfoFetchService.getPlantNames(word), HttpStatus.OK);
    }


    @ApiOperation(value = "식물정보 저장하기")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "plantDto", value = "식물 정보", required = true, dataType = "PlantDto"),
    })
    @Auth
    @PostMapping("plants/save")
    public ResponseEntity<String> savePlant(@RequestBody PlantDto plantDto, @RequestParam Long userId){
        plantService.savePlant(plantDto,userId);
        return new ResponseEntity<>("success!",HttpStatus.OK);
    }


    @ApiOperation(value = "자신의 식물들 리스트를 가져옵니다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이징", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "유저 pk 값", required = true, dataType = "long"),
    })
    @Auth
    @PostMapping("/plants")
    public ResponseEntity<List<PlantCardDto>> getPlants(@RequestParam int page, @RequestParam Long userId){
        List<PlantCardDto> plants = plantService.getPlants(page, userId);

        return new ResponseEntity<>(plants, HttpStatus.OK);
    }


    @ApiOperation(value = "선택한 식물의 디테일 정보를 가져옵니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "식물 pk 값", required = true, dataType = "long"),
    })
    @Auth
    @PostMapping("/plants/{id}/detail")
    public ResponseEntity<PlantDetailDto> getPlantDetail(@PathVariable Long id){

        return new ResponseEntity<>(plantService.getPlantDetail(id), HttpStatus.OK);
    }

    @ApiOperation(value = "선택한 식물의 정보를 수정합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "식물 pk 값", required = true, dataType = "long"),
    })
    @Auth
    @PostMapping("/plants/{id}/update")
    public ResponseEntity<String> updatePlant(@PathVariable Long id,
                                                      @RequestParam Long userId,
                                                      @RequestBody PlantUpdateDto plantUpdateDto){
        plantService.updatePlant(plantUpdateDto,userId,id);
        return new ResponseEntity<>("success!!", HttpStatus.OK);
    }


    @ApiOperation(value = "선택한 식물을 삭제합니다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "plantId", value = "식물의 pk 값", required = true, dataType = "long"),
            @ApiImplicitParam(name = "userId", value = "유저 pk 값", required = true, dataType = "long"),
    })
    @Auth
    @PostMapping("plants/{plantId}/delete")
    public ResponseEntity<String> deletePlant(@PathVariable Long plantId,
                                              @RequestParam Long userId){
        plantService.deletePlant(plantId,userId);
        return new ResponseEntity<>("success!",HttpStatus.OK);
    }


    @ApiOperation(value = "식물의 애정지수를 올립니다.")
    @ApiImplicitParams({
            //@ApiImplicitParam(name = "plantId", value = "식물의 pk 값", required = true, dataType = "long"),
    })
    @Auth
    @PostMapping("plants/{plantId}/love")
    public ResponseEntity<LoveDto> updateLove(@PathVariable Long plantId){
        return new ResponseEntity<>(plantService.updateLove(plantId),HttpStatus.OK);
    }

    @GetMapping("dummy")
    public void dummy(@RequestParam Long userId){
        plantService.dummy(userId);
    }

}

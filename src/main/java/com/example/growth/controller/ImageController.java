package com.example.growth.controller;

import com.example.growth.domain.PlantImage;
import com.example.growth.dto.ImageDto;
import com.example.growth.service.ImageService;
import com.example.growth.utils.auth.Auth;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @ApiOperation(value = "해당 식물의 image 등록", notes = "  \"userId\": Long\n" +
            "  \"plantId\": Long\n" +
            "  \"image\": MultipartFile\n" +
            "  \"tag\": GERMINATE, LEAF, FLOWER, BUG, REPOTTING, FRUIT, NUTRITIONAL 상태를 나타내는 Enum타입\n" +
            "  \"date\": \"yyyy-MM-dd'T'HH:mm:ss\" 형식의 string\n")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "유저 pk값", required = true, dataType = "long", paramType = "formData"),
            @ApiImplicitParam(name = "plantId", value = "식물 pk값", required = true, dataType = "long", paramType = "formData"),
            @ApiImplicitParam(name = "image", value = "이미지", required = true, dataType = "MultipartFile", paramType = "formData"),
            @ApiImplicitParam(name = "tag", value = "태그", required = true, dataType = "TagTypes", paramType = "formData"),
            @ApiImplicitParam(name = "date", value = "날짜", required = true, dataType = "string", paramType = "formData"),
    })
    @Auth
    @PostMapping("/uploadImage")
    public ResponseEntity uploadImage(ImageDto imageDto, @RequestPart(value = "image", required = false) MultipartFile image) {
        if (image != null) imageDto.setImage(image);
        imageService.imageUpload(imageDto, image);
        return new ResponseEntity<>("success!", HttpStatus.OK);
    }


    @ApiOperation(value = "해당 식물의 image 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 pk값", required = true, dataType = "long"),
            @ApiImplicitParam(name = "plantId", value = "식물 pk값", required = true, dataType = "long")
    })
    @Auth
    @GetMapping("/getImage")
    public ResponseEntity<List<PlantImage>> getImage(@RequestParam Long userId, @RequestParam Long plantId) {
        return new ResponseEntity<>(imageService.getImage(userId, plantId), HttpStatus.OK);
    }


    @ApiOperation(value = "해당 식물 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imageId", value = "이미지 pk값", required = true, dataType = "long"),
    })
    @Auth
    @DeleteMapping("/deleteImage")
    public ResponseEntity deleteImage(@RequestParam Long imageId) {
        imageService.deleteImage(imageId);
        return new ResponseEntity<>("success!",HttpStatus.OK);
    }

}

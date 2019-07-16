package com.example.growth.controller;

import com.example.growth.domain.PlantImage;
import com.example.growth.dto.ImageDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.service.ImageService;
import com.example.growth.utils.auth.Auth;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    @ApiOperation(value = "해당 식물의 image 등록")
    @Auth
    @PostMapping("/uploadImage")
    public ResponseEntity<DefaultRes> uploadImage(ImageDto imageDto, @RequestPart(value = "image", required = false) final MultipartFile image) {
        if (image != null) imageDto.setImage(image);
        imageService.imageUpload(imageDto, image);
        return new ResponseEntity<>(DefaultRes.res("image upload success", imageDto), HttpStatus.OK);
    }


    @ApiOperation(value = "해당 식물의 image 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 pk값", required = true, dataType = "long"),
            @ApiImplicitParam(name = "plantId", value = "식물 pk값", required = true, dataType = "long")
    })
    @Auth
    @GetMapping("/getImage")
    public ResponseEntity<DefaultRes<List<PlantImage>>> getImage(@RequestParam Long userId, @RequestParam Long plantId) {
        return new ResponseEntity<>(DefaultRes.res("image get success", imageService.getImage(userId, plantId)), HttpStatus.OK);
    }


    @ApiOperation(value = "해당 식물 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imageId", value = "이미지 pk값", required = true, dataType = "long"),
    })
    @Auth
    @DeleteMapping("/deleteImage")
    public ResponseEntity<DefaultRes> deleteImage(@RequestParam Long imageId) {
        imageService.deleteImage(imageId);
        return new ResponseEntity<>(DefaultRes.res("image delete success"), HttpStatus.OK);
    }

}

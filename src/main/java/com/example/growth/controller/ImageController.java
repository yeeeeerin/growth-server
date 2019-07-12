package com.example.growth.controller;

import com.example.growth.domain.PlantImage;
import com.example.growth.dto.ImageDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/uploadImage")
    public ResponseEntity<DefaultRes> uploadImage(ImageDto imageDto, @RequestPart(value = "image", required = false) final MultipartFile image) {
        if (image != null) imageDto.setImage(image);
        imageService.imageUpload(imageDto, image);
        return new ResponseEntity<>(DefaultRes.res("image upload success", imageDto), HttpStatus.OK);
    }

    @GetMapping("/getImage")
    public ResponseEntity<DefaultRes<List<PlantImage>>> getImage(@RequestParam Long userId, @RequestParam Long plantId) {
        return new ResponseEntity<>(DefaultRes.res("image get success", imageService.getImage(userId, plantId)), HttpStatus.OK);
    }


    @DeleteMapping("/deleteImage")
    public ResponseEntity<DefaultRes> deleteImage(@RequestParam Long imageId) {
        imageService.deleteImage(imageId);
        return new ResponseEntity<>(DefaultRes.res("image delete success"), HttpStatus.OK);
    }

}

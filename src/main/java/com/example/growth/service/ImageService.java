package com.example.growth.service;

import com.example.growth.domain.PlantImage;
import com.example.growth.dto.ImageDto;
import com.example.growth.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final S3FileUploadService s3FileUploadService;
    private final ImageRepository imageRepository;
    private String image1;

    @Transactional
    public void imageUpload(ImageDto imageDto, MultipartFile image) {

        try {
            if (image != null)
                image1 = s3FileUploadService.upload(image);

            PlantImage plantImage = new PlantImage();
            plantImage.setUserId(imageDto.getUserId());
            plantImage.setPlantId(imageDto.getPlantId());
            plantImage.setImageUrl(image1);
            plantImage.setTag(imageDto.getTag());
            plantImage.setDate(imageDto.getDate());

            imageRepository.save(plantImage);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public List<PlantImage> getImage(Long userId, Long plantId) {
//        List<PlantImage> plantImages = imageRepository.findByUserIdAndPlantId(userId, plantId);
        List<PlantImage> plantImages = imageRepository.findAll();

        return plantImages;
    }

    public void deleteImage(Long imageId) {
        Optional<PlantImage> plantImage = imageRepository.findById(imageId);
//        imageRepository.delete(plantImage);
    }
}

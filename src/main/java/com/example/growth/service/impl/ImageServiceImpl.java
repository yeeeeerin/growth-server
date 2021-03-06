package com.example.growth.service.impl;

import com.example.growth.domain.PlantImage;
import com.example.growth.dto.ImageDto;
import com.example.growth.exception.ImageNotFoundException;
import com.example.growth.repository.ImageRepository;
import com.example.growth.service.ImageService;
import com.example.growth.service.S3FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ImageServiceImpl implements ImageService {

    private final S3FileUploadService s3FileUploadService;
    private final ImageRepository imageRepository;
    private String image1;

    @Override
    public void imageUpload(ImageDto imageDto, MultipartFile image) {

        try {
            if (image != null)
                image1 = s3FileUploadService.upload(image);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = simpleDateFormat.parse(imageDto.getDate());
            String stringDate = simpleDateFormat.format(date);

            PlantImage plantImage = new PlantImage();
            plantImage.setUserId(imageDto.getUserId());
            plantImage.setPlantId(imageDto.getPlantId());
            plantImage.setImageUrl(image1);
            plantImage.setTag(imageDto.getTag());
            plantImage.setDate(stringDate);

            imageRepository.save(plantImage);

        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (ParseException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public List<PlantImage> getImage(Long userId, Long plantId) {
        List<PlantImage> plantImages = imageRepository.findByUserIdAndPlantId(userId, plantId);
        return plantImages;
    }

    @Override
    public void deleteImage(Long imageId) {
        PlantImage plantImage = imageRepository.findById(imageId).orElseThrow(ImageNotFoundException::new);
        imageRepository.delete(plantImage);
    }

}

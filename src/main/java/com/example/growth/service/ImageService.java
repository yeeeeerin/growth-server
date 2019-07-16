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


public interface ImageService {
    void imageUpload(ImageDto imageDto, MultipartFile image);

    List<PlantImage> getImage(Long userId, Long plantId);

    void deleteImage(Long imageId);
}

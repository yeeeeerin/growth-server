package com.example.growth.repository;

import com.example.growth.domain.PlantImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<PlantImage, Long> {
    List<PlantImage> findByUserIdAndPlantId(Long userId, Long plantId);
}

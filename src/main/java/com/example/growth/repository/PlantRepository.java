package com.example.growth.repository;


import com.example.growth.domain.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant,Long> {

    Page<Plant> findAllByUserId(Long userId, Pageable pageable);
    Optional<Plant> findByIdAndUserId(Long id,Long userId);

}

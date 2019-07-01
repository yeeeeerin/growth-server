package com.example.growth.repository;


import com.example.growth.domain.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant,Long> {

    Page<Plant> findAllByUserId(Long userId, Pageable pageable);

}

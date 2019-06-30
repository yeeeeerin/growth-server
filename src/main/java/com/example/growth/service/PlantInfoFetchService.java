package com.example.growth.service;


import com.example.growth.dto.api.PlantInfo;

public interface PlantInfoFetchService {
    PlantInfo getPlantInfo(String searchName);
}

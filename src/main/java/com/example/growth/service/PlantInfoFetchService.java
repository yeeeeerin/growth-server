package com.example.growth.service;


import com.example.growth.dto.api.PlantInfo;

import java.util.List;

public interface PlantInfoFetchService {
    PlantInfo getPlantInfo(String searchName);
    List<String> getPlantNames(String searchName);
}

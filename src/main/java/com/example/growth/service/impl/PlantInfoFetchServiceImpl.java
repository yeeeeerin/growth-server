package com.example.growth.service.impl;

import com.example.growth.dto.api.PlantInfo;
import com.example.growth.dto.api.PlantInfoDto;
import com.example.growth.dto.api.PlantListDto;
import com.example.growth.service.PlantInfoFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlantInfoFetchServiceImpl implements PlantInfoFetchService {

    private static final String BASE_URL="http://api.nongsaro.go.kr/service/garden";
    private static final String KEY="20190607VMCE0Q8CS30FG6LDATHIFA";
    private final RestTemplate restTemplate;

    @Override
    public PlantInfo getPlantInfo(String searchName) {

        String code = getPlantCode(searchName);

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL+"/gardenDtl")
                .queryParam("apiKey", KEY)
                .queryParam("cntntsNo", code)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();


        PlantInfoDto dto = restTemplate.getForObject(uri, PlantInfoDto.class);
        return dto.getBody().getItem();
    }



    private String getPlantCode(String name){

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL+"/gardenList")
                .queryParam("apiKey", KEY)
                .queryParam("sType", "sCntntsSj")
                .queryParam("sText",name)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        PlantListDto response = restTemplate.getForObject(uri, PlantListDto.class);

        return String.valueOf(response.getBody().getItems().get(0))
                .split(",")[0]
                .split("=")[1];


    }
}

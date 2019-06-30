package com.example.growth.impl;


import com.example.growth.dto.api.PlantInfoDto;
import com.example.growth.dto.api.PlantListDto;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class PlantInfoFetchServiceTest {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL="http://api.nongsaro.go.kr/service/garden";
    private static final String KEY="20190607VMCE0Q8CS30FG6LDATHIFA";
    private static final String TEST_URL = "http://api.nongsaro.go.kr/service/garden/gardenList?apiKey=20190607VMCE0Q8CS30FG6LDATHIFA&sType=sCntntsSj&sText=%EA%B0%80";


    @Test
    public void 식물의_정보를_가져온다(){

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL+"/gardenDtl")
                .queryParam("apiKey", KEY)
                .queryParam("cntntsNo", "12994")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();


        PlantInfoDto dto = restTemplate.getForObject(uri, PlantInfoDto.class);
        String fncltyInfo = dto.getBody().getItem().getFncltyInfo();
        assertThat(fncltyInfo,is("Skill Level: Beginner"));
    }


    @Test
    public void 식물리스트의_첫번째_값을_가져온다(){

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL+"/gardenList")
                .queryParam("apiKey", KEY)
                .queryParam("sType", "sCntntsSj")
                .queryParam("sText","나")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        PlantListDto response = restTemplate.getForObject(uri, PlantListDto.class);

        String sb = String.valueOf(response.getBody().getItems().get(0))
                .split(",")[0]
                .split("=")[1];
        System.out.println(sb);
        assertThat(sb,is("12994"));
    }


    @Test
    public void 파라메터가_한글로주어진다면_주소가_인코딩을_성공한다() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL+"/gardenList")
                .queryParam("apiKey", KEY)
                .queryParam("sType", "sCntntsSj")
                .queryParam("sText","가")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();


        assertThat(uri.toString(),is(TEST_URL));
    }

}
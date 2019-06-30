package com.example.growth.service;



import com.example.growth.dto.TokenDto;
import com.example.growth.utils.KakaoProviders;
import com.example.growth.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoService {

    private static final String HEADER_PREFIX = "Bearer ";

    private final RestTemplate restTemplate = new RestTemplate();


    public UserVo getSocialUserInfo(TokenDto dto) {
        HttpEntity<String> entity = new HttpEntity<>("parameters", createHeader(dto.getToken()));
        return restTemplate.exchange(KakaoProviders.KAKAO.getUserinfoEndpoint(), HttpMethod.GET, entity, UserVo.class).getBody();
    }

    private HttpHeaders createHeader(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", createHeaderContent(token));
        return httpHeaders;

    }

    private String createHeaderContent(String token) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_PREFIX);
        stringBuilder.append(token);
        return stringBuilder.toString();
    }
}

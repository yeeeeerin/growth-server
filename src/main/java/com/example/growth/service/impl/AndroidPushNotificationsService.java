package com.example.growth.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AndroidPushNotificationsService {
    private static final String FIREBASE_SERVICE_KEY = "AAAAgKYeP3M:APA91bEM_OXETBezFZ4B4_gw71tJXnWB1BsVqcTDZDKWkDnKzbda0hw7zV8MY_inidGDoHmAQba0OxcU7np7wwj6AnQdWadeOb6GAdi2U1CNZ3bnyufgPemZZTzrFB0xtG1PiLrxmLg5";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
    private final RestTemplate restTemplate;

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity){
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization","key="+FIREBASE_SERVICE_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type","application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);

    }
}

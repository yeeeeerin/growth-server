package com.example.growth.service.impl;

import com.example.growth.domain.Plant;
import com.example.growth.domain.User;
import com.example.growth.repository.PlantRepository;
import com.example.growth.service.NotificationService;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final PlantRepository plantRepository;

    @Override
    public void send(){

        List<String> deviceTokens = getPlants()
                .stream()
                .map(Plant::getUser)
                .map(User::getDeviceToken)
                .collect(Collectors.toList());

        MulticastMessage message = MulticastMessage.builder()
                .putData("message", "water!!")
                .addAllTokens(deviceTokens)
                .build();
        try {
            BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }

    }

   private List<Plant> getPlants(){

        int day = LocalDateTime.now().getDayOfYear();
        return plantRepository.findByAlarm(Boolean.TRUE)
                .stream()
                .filter(plant -> plant.getCreateAt().getDayOfYear() - day == 0 )
                .collect(Collectors.toList());

    }
}

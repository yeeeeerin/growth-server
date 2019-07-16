package com.example.growth.scheduler;

import com.example.growth.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class WaterScheduler {

    private final NotificationService notificationService;


    //매 분 실행
    @Scheduled(cron = "0 * * * * ?")
    public void send() {

        //notificationService.send();

    }

}

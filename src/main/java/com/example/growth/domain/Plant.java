package com.example.growth.domain;

import com.example.growth.dto.PlantDto;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Plant {

    @GeneratedValue
    @Id
    private Long id;

    //닉네임
    private String name;

    //나이/단계/레벨
    private String grow;

    //식물 종류
    private String kind;

    //일러스트
    private String card;

    //물주기 설정
    private Integer waterDate;

    //물 알람 시간
    private LocalDateTime waterTime;

    private Long love;

    //물주기 알람 설정
    private Boolean alarm;

    //애정지수 업데이트
    private LocalDateTime updateLove;

    @CreatedDate
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    protected Plant(){

    }

    private Plant(String name, String grow, String kind, String card, Integer water,LocalDateTime waterTime, Boolean alarm,User user){
        this.name = name;
        this.grow = grow;
        this.kind = kind;
        this.card = card;
        waterDate = water;
        this.waterTime = waterTime;
        love = 0l;
        this.alarm = alarm;
        this.user = user;
        updateLove = LocalDateTime.MIN;
    }

    public static Plant from(PlantDto plantDto, User user){
        return new Plant(plantDto.getName(),
                plantDto.getGrow(),
                plantDto.getKind(),
                plantDto.getCard(),
                plantDto.getWaterDate(),
                plantDto.getWaterTime(),
                plantDto.getAlarm(),
                user);
    }

    public void setLove(){
        updateLove = LocalDateTime.now();
        love++;
    }

    
}

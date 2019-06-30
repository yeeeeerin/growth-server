package com.example.growth.domain;

import com.example.growth.dto.PlantDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String water;

    private Long love;

    //물주기 알람 설정
    private Boolean alarm;


    protected Plant(){

    }

    private Plant(String name, String grow, String kind, String card, String water, Boolean alarm){
        this.name = name;
        this.grow = grow;
        this.kind = kind;
        this.card = card;
        this.water = water;
        love = 0l;
        this.alarm = alarm;
    }

    public static Plant from(PlantDto plantDto){
        return new Plant(plantDto.getName(),
                plantDto.getGrow(),
                plantDto.getKind(),
                plantDto.getCard(),
                plantDto.getWater(),
                plantDto.getAlarm());
    }
    
}

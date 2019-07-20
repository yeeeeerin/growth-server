package com.example.growth.domain;

import com.example.growth.dto.PlantDto;
import com.example.growth.dto.PlantUpdateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ApiModel
public class Plant {

    @GeneratedValue
    @Id
    @ApiModelProperty(notes="pk값")
    private Long id;

    //닉네임
    @ApiModelProperty(notes="닉네임")
    private String name;

    //나이/단계/레벨
    @ApiModelProperty(notes="나이/단계/레벨")
    private String grow;

    //식물 종류
    @ApiModelProperty(notes="식물 종류")
    private String kind;

    //일러스트
    @ApiModelProperty(notes="일러스트")
    @Enumerated(value = EnumType.STRING)
    private PlantTypes card;

    //물주기 설정
    @ApiModelProperty(notes="물주기 설정")
    private Integer waterDate;

    //물 알람 시간
    @ApiModelProperty(notes="물 알람 시간")
    private LocalDateTime waterTime;

    @ApiModelProperty(notes="애정지수")
    private Long love;

    //물주기 알람 설정
    @ApiModelProperty(notes="물주기 알람 설정")
    private Boolean alarm;

    //애정지수 업데이트
    @ApiModelProperty(notes="애정지수 업데이트 시간")
    private LocalDateTime updateLove;

    @ApiModelProperty(notes="식물을 키우기 시작한 날")
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    protected Plant(){

    }

    private Plant(String name, String grow, String kind, PlantTypes card, Integer water,LocalDateTime waterTime, Boolean alarm,User user,LocalDateTime createAt){
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
        this.createAt = createAt;
    }

    public static Plant from(PlantDto plantDto, User user){
        return new Plant(plantDto.getName(),
                plantDto.getGrow(),
                plantDto.getKind(),
                plantDto.getCard(),
                plantDto.getWaterDate(),
                plantDto.getWaterTime(),
                plantDto.getAlarm(),
                user,
                plantDto.getCreateAt());
    }

    public void setLove(){
        updateLove = LocalDateTime.now();
        love++;
    }

    public void setPlnat(PlantUpdateDto plant){
        name = plant.getName();
        grow = plant.getGrow();
        waterDate = plant.getWaterDate();
        waterTime = plant.getWaterTime();
        alarm = plant.getAlarm();
        createAt = plant.getCreateAt();
    }

    
}

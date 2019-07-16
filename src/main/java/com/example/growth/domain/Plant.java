package com.example.growth.domain;

import com.example.growth.dto.PlantDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

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
    @Enumerated(EnumType.STRING)
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

    @CreatedDate
    @ApiModelProperty(notes="식물 등록 시간")
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    protected Plant(){

    }

    private Plant(String name, String grow, String kind, PlantTypes card, Integer water,LocalDateTime waterTime, Boolean alarm,User user){
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

package com.example.growth.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PlantImage {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes="pk값")
    private Long id;

    @ApiModelProperty(notes="유저 pk값")
    private Long userId;

    @ApiModelProperty(notes="식물 pk값")
    private Long plantId;

    @ApiModelProperty(notes="이미지")
    private String imageUrl;

    @ApiModelProperty(notes="태그")
    @Enumerated(EnumType.STRING)
    private TagTypes tag;

    @ApiModelProperty(notes="날짜")
    private String date;

}

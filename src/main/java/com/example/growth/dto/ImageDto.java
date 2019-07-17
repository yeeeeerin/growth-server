package com.example.growth.dto;

import com.example.growth.domain.TagTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ImageDto {
    @ApiModelProperty(notes="유저 pk값")
    private Long userId;

    @ApiModelProperty(notes="식물 pk값")
    private Long plantId;

    @ApiModelProperty(notes="이미지")
    private MultipartFile image;

    @ApiModelProperty(dataType = "string",notes = "태그", allowableValues = "GERMINATE, LEAF, FLOWER, BUG, REPOTTING, FRUIT, NUTRITIONAL")
    private TagTypes tag;

    @ApiModelProperty(notes="날짜")
    private String date;
}

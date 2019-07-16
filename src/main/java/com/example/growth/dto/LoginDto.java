package com.example.growth.dto;


import com.example.growth.service.JwtService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class LoginDto {

    @ApiModelProperty(notes="token 값")
    private String token;

    @ApiModelProperty(notes="user의 id값")
    private Long userId;

}
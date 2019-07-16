package com.example.growth.service;


import com.example.growth.dto.LoginDto;
import com.example.growth.dto.TokenDto;
import com.example.growth.model.DefaultRes;

public interface AuthService {

    LoginDto login(TokenDto tokenDto);

    void setDeviceToken(Long id, String deviceToken);
}

package com.example.growth.service.impl;

import com.example.growth.domain.User;
import com.example.growth.dto.LoginDto;
import com.example.growth.dto.TokenDto;
import com.example.growth.exception.UserNotFoundException;
import com.example.growth.model.DefaultRes;
import com.example.growth.repository.UserRepository;
import com.example.growth.service.AuthService;
import com.example.growth.service.JwtService;
import com.example.growth.service.KakaoService;
import com.example.growth.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final KakaoService kakaoService;

    @Override
    @Transactional
    public LoginDto login(TokenDto tokenDto) {

        UserVo userVo = kakaoService.getSocialUserInfo(tokenDto);

        User user = userRepository.findBySocialId(userVo.getUserId());

        LoginDto loginDto = new LoginDto();

        if (user == null) {
            User newUser = new User();

            newUser.setSocialId(userVo.getUserId());
            newUser.setName(userVo.getUserName());
            newUser.setProfileHref(userVo.getProfileHref());

            userRepository.save(newUser);

            JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(newUser.getId()));
            loginDto.setToken(token.getToken());

            User user1 = userRepository.findBySocialId(userVo.getUserId());
            loginDto.setUserId(user1.getId());

            return loginDto;

        }

        JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(user.getId()));
        loginDto.setToken(token.getToken());
        loginDto.setUserId(user.getId());

        return loginDto;
    }

    @Transactional
    public void setDeviceToken(Long id, String deviceToken){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        user.setDeviceToken(deviceToken);
    }
}


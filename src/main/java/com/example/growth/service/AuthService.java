package com.example.growth.service;


import com.example.growth.domain.User;
import com.example.growth.dto.LoginDto;
import com.example.growth.dto.TokenDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.repository.UserRepository;
import com.example.growth.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final KakaoService kakaoService;

    @Transactional
    public DefaultRes<LoginDto> login(TokenDto tokenDto) {

        UserVo userVo = kakaoService.getSocialUserInfo(tokenDto);

        User user = userRepository.findBySocialId(userVo.getUserId());

        LoginDto loginDto = new LoginDto();

        if (user == null) {
            User newUser = new User();

            newUser.setSocialId(userVo.getUserId());
            newUser.setName(userVo.getUserName());
            newUser.setProfileHref(userVo.getProfileHref());

            userRepository.save(newUser);

            final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(newUser.getId()));
            loginDto.setToken(token.getToken());

            final User user1 = userRepository.findBySocialId(userVo.getUserId());
            loginDto.setUserId(user1.getId());

            return DefaultRes.res("로그인 성공", loginDto);

        }

        final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(user.getId()));
        loginDto.setToken(token.getToken());
        loginDto.setUserId(user.getId());

        return DefaultRes.res("로그인 성공", loginDto);
    }
}

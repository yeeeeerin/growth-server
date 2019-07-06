package com.example.growth.service;


import com.example.growth.domain.User;
import com.example.growth.dto.TokenDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.repository.UserRepository;
import com.example.growth.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final KakaoService kakaoService;

    @Transactional
    public DefaultRes<JwtService.TokenRes> login(TokenDto tokenDto) {

        UserVo userVo = kakaoService.getSocialUserInfo(tokenDto);

        User user = userRepository.findBySocialId(userVo.getUserId());

        if (user == null) {
            User newUser = new User();

            newUser.setSocialId(userVo.getUserId());
            newUser.setName(userVo.getUserName());
            newUser.setProfileHref(userVo.getProfileHref());

            userRepository.save(newUser);

            final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(newUser.getId()));
            return DefaultRes.res("로그인 성공", token);

        }

        final JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(user.getId()));
        return DefaultRes.res("로그인 성공", token);
    }
}

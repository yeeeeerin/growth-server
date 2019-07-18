package com.example.growth.controller;

import com.example.growth.dto.LoginDto;
import com.example.growth.dto.TokenDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.service.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;


    @ApiOperation(value = "카카오 소셜 로그인을 합니다.")
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody TokenDto tokenDto) {
        return new ResponseEntity<>(authService.login(tokenDto), HttpStatus.OK);
    }


    @ApiOperation(value = "알람을 위한 device 토큰 등록")
    @GetMapping("/user/{id}/resisterToken")
    public ResponseEntity<DefaultRes> resisterDeviceToken(@PathVariable Long id,
                                                          @RequestParam String deviceToken){
        authService.setDeviceToken(id,deviceToken);

        return new ResponseEntity<>(DefaultRes.res("success!"), HttpStatus.OK);

    }

}

package com.example.growth.controller;

import com.example.growth.dto.TokenDto;
import com.example.growth.model.DefaultRes;
import com.example.growth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class LoginController {

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes("서버 내부 에러");

    private final AuthService authService;
    
//dd
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody TokenDto tokenDto) {
        return new ResponseEntity<>(authService.login(tokenDto), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity noLoginException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

package com.example.growth.controller;


import com.example.growth.exception.PlantNotFoundException;
import com.example.growth.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleUserNotFoundException(){
        return new ResponseEntity<>("유저를 찾을 수 없습니다.",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handlePlantNotFoundException(){
        return new ResponseEntity<>("식물을 찾을 수 없습니다.",HttpStatus.NOT_FOUND);
    }
}

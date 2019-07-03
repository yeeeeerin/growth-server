package com.example.growth.exception;

public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(){
        super("식물을 찾을 수 없습니다.");
    }
}

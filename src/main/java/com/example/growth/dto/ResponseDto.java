package com.example.growth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String message;

    public static ResponseDto res(final String message) {
        return new ResponseDto(message);
    }
}

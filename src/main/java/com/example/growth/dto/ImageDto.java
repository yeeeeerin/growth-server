package com.example.growth.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private Long userId;

    private Long plantId;

    private MultipartFile image;

    private String tag;

    private String date;
}

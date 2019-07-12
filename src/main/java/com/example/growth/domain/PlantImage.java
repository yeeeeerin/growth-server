package com.example.growth.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantImage {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long plantId;

    private String imageUrl;

    private String tag;

    private String date;

}

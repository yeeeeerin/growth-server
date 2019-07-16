package com.example.growth.domain;

public enum PlantTypes {
    FLOWER("꽃형"),
    TREE("나무형"),
    DRUPE("다육형"),
    GRASS("풀형"),
    LEAF("잎형");

    private final String name;

    PlantTypes(String name) {
        this.name = name;
    }
}

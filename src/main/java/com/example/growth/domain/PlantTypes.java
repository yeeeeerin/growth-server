package com.example.growth.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public static PlantTypes getName(String name) {
        return Arrays.stream(PlantTypes.values())
                .filter(r -> r.isCorrectName(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("권한이 없습니다"));
    }

    public boolean isCorrectName(String name) {
        return name.equalsIgnoreCase(this.name);
    }
}

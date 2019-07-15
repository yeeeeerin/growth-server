package com.example.growth.domain;

public enum PlantTypes {
    FLOWER("꽃"),
    TREE("나무"),
    DRUPE("다육이"),
    WILD_FLOWER("야생화"),
    HERB("허브");

    private final String name;

    PlantTypes(String name) {
        this.name = name;
    }
}

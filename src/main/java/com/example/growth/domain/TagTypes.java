package com.example.growth.domain;

public enum TagTypes {
    GERMINATE("발아"),
    LEAF("잎이남"),
    FLOWER("꽃이핌"),
    BUG("벌레생김"),
    REPOTTING("분갈이"),
    FRUIT("열매열림"),
    NUTRITIONAL("영양제/약");

    private final String tag;

    TagTypes(String name) {
        this.tag = name;
    }
}

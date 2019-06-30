package com.example.growth.dto.api;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlantInfo{

    @XmlElement(name = "managelevelCodeNm")
    private String manageLevel;

    @XmlElement(name = "grwhTpCodeNm")
    private String growTemperature;

    @XmlElement(name = "speclmanageInfo")
    private String manageInfo;

    @XmlElement(name = "fncltyInfo")
    private String fncltyInfo;

}


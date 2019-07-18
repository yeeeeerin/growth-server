package com.example.growth.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class PlantInfo{

    @ApiModelProperty(notes="관리 수준")
    @XmlElement(name = "managelevelCodeNm")
    private String manageLevel;

    @ApiModelProperty(notes="식물 온도")
    @XmlElement(name = "grwhTpCodeNm")
    private String growTemperature;

    @ApiModelProperty(notes="관리 정보")
    @XmlElement(name = "speclmanageInfo")
    private String manageInfo;

    @ApiModelProperty(notes="기능성 정보")
    @XmlElement(name = "fncltyInfo")
    private String fncltyInfo;

}


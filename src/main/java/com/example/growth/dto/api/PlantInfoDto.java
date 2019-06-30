package com.example.growth.dto.api;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "response")
public class PlantInfoDto {

    @XmlElement(name = "body")
    private PlantInfoItemsDto body;


    @Data
    @XmlRootElement(name="body")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class PlantInfoItemsDto{

        @XmlElement(name = "item")
        private PlantInfo item;

    }


}

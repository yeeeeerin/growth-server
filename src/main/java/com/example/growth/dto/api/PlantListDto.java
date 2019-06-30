package com.example.growth.dto.api;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "response")
public class PlantListDto {

    @XmlElement(name="body")
    private PlantListItemsDto body;


    @Data
    @XmlRootElement(name="body")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class PlantListItemsDto{

        private List<Object> items;

    }



}

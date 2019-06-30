package com.example.growth.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class UserVo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("properties")
    private Map<String, String> properties;


    public Long getUserId() {
        return this.id;
    }

    public String getUserName() {
        return this.properties.get("nickname");
    }

    public String getProfileHref() {
        return this.properties.get("profile_image");
    }

}

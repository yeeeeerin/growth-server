package com.example.growth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usertbl")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private Long socialId;

    private String name;

    private String profileHref;

    //push알람을 위한 android device id
    private String deviceToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Plant> plants;

}

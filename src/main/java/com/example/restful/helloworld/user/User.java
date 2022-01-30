package com.example.restful.helloworld.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}

package com.example.restful.helloworld.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password","ssn"})
@JsonFilter("userInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    private Integer id;
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private String name;
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요")
    private Date joinDate;
    //@JsonIgnore
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요")
    private String ssn;
}

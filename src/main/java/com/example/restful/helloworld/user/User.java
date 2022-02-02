package com.example.restful.helloworld.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password","ssn"})
//@JsonFilter("userInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private String name;
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요")
    private Date joinDate;
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, Date date, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = date;
        this.password = password;
        this.ssn = ssn;
    }
}

package com.example.restful.helloworld.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin") //prefix
public class AdminUserController {

    private final UserDAOService service;

//    @GetMapping("/users")  //admin/users 가 됨
//    public MappingJacksonValue retrieveAllUsers() {
//
//        List<User> allUsers = service.findAll();
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("userInfo", filter);
//        MappingJacksonValue mapping = new MappingJacksonValue(allUsers);
//        mapping.setFilters(filters);
//
//        return mapping;
//    }
//
//    //@GetMapping("/v1/users/{id}") // /admin/v1/user/{id}
//    //@GetMapping(value = "/users/{id}", params="version=1")
//    //@GetMapping(value = "users/{id}", headers = "X-API-VERSION=1")
//    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")
//    public MappingJacksonValue retrieveUserv1 (@PathVariable int id) {
//        User user = service.findOne(id);
//
//        if (user == null) {
//            throw new UserNotFountException(String.format("ID ('%s) not fount", id));
//        }
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("userInfo", filter);
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filters);
//        return mapping;
//    }
//
//    //@GetMapping("/v2/users/{id}") // /admin/v2/user/{id}
//    //@GetMapping(value ="/users/{id}", params = "version=2")
//    //@GetMapping(value = "users/{id}", headers = "X-API-VERSION=2")
//    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json")
//    public MappingJacksonValue retrieveUserv2 (@PathVariable int id) {
//        User user = service.findOne(id);
//
//        if (user == null) {
//            throw new UserNotFountException(String.format("ID ('%s) not fount", id));
//        }
//
//        // user -> userv2
//        UserV2 userv2 = new UserV2();
//        BeanUtils.copyProperties(user, userv2);
//        userv2.setGrade("VIP");
//
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("userInfoV2", filter);
//        MappingJacksonValue mapping = new MappingJacksonValue(userv2);
//        mapping.setFilters(filters);
//        return mapping;
//    }

}

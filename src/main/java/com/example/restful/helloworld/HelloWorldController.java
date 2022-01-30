package com.example.restful.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //hello-world (endpoint)
    //@RequestMapping(method = RequestMethod.GET, path = "hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
}

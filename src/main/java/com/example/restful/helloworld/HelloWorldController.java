package com.example.restful.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {


    private final MessageSource  messagesource;

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

    @GetMapping("/Hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messagesource.getMessage("greeting.message", null, locale);
    }
}

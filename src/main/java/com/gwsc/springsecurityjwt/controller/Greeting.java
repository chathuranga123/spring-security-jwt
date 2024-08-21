package com.gwsc.springsecurityjwt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/greeting")
public class Greeting {

    @GetMapping
    public String getLeftMenu() {
        return "Hello World";

    }
}

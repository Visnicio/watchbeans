package com.watchbeans.watchbeans.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/")
    public String helloWorld(){
        return "Ola mundo";
    }
}

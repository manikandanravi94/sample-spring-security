package com.mani.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public String getUser() {
        return "successfully shown user resource";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "successfully shown admin resource";
    }

    @GetMapping("/")
    public String getHome() {
        return "Welcome to home page";
    }
}

package com.mani.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public String getUser(){
        return "successfully shown user resource";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "successfully shown admin resource";
    }
}

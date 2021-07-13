package com.prueba.wposs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AppController {

    @GetMapping({"/","/login"})
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String hello() {
        return "menu";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

}

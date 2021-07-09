package com.prueba.wposs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AppLogin {

    @GetMapping({"/","/login"})
    public  String index() {
        return "index";
    }
    @GetMapping({"/menu"})
    String menu() {
        return "menu";
    }
    @GetMapping({"/user"})
    String user() {
        return "user";
    }
}

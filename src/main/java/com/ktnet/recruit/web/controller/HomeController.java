package com.ktnet.recruit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){ return "home"; }

    @GetMapping("/policy")
    public String dispPolicy(){
        return "policy";
    }

    @GetMapping("/wrt01")
    public String dispWrt01(){
        return "wrt_01_";
    }

    @GetMapping("/wrt02")
    public String dispWrt02(){
        return "wrt_02_";
    }
}

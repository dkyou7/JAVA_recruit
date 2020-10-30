package com.ktnet.recruit.web.controller;

import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(@RequestParam String password, @RequestParam String regular_emp_num){
        User savedUser = userService.save(password, regular_emp_num);

        return "policy";
    }
}

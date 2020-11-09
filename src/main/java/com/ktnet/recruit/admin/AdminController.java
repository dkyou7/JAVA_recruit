package com.ktnet.recruit.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/index")
    public String adminIndex(){
        return "admin/index";
    }

    @GetMapping("/home")
    public String adminHome(){
        return "admin/adminHome";
    }

    @GetMapping("/profile")
    public String adminProfile(){
        return "admin/profile";
    }

    @GetMapping("/basicTable")
    public String adminBasicTable(){
        return "admin/basic-table";
    }

    @GetMapping("/fontAwesome")
    public String adminFontAwesome(){
        return "admin/fontawesome";
    }

    @GetMapping("/googleMap")
    public String adminGoogleMap(){
        return "admin/map-google";
    }

    @GetMapping("/blank")
    public String adminBlank(){
        return "admin/blank";
    }

    @GetMapping("/notFound")
    public String adminNotFound(){
        return "admin/404";
    }

    @GetMapping("/applyUser")
    public String adminApplyUser(){
        return "admin/applyUser";
    }
}

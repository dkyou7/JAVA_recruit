package com.ktnet.recruit.admin;

import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserDto;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

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
    public String adminApplyUser(Model model){
        List<User> findUsers = userService.findAll();
        List<UserDto> findUsersDto = new ArrayList<>();
        for (User user : findUsers){
            findUsersDto.add(UserDto.toApplyUserDto(user));
        }
        model.addAttribute("dto",findUsersDto);
        return "admin/applyUser";
    }
}

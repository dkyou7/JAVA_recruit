package com.ktnet.recruit.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/tmpSave")
    public String save(UserDto userDto){
        User tmpUser = User.toEntity(userDto);
        userService.save(tmpUser);
        return "redirect:/wrt01";
    }
}

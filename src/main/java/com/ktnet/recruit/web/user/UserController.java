package com.ktnet.recruit.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/saveImage")
    public String saveImage(@RequestParam("filename") MultipartFile multipartFile){
        System.out.println("multipartFile.getOriginalFilename() = " + multipartFile.getOriginalFilename());
        return "name";
    }

    @PostMapping("/tmpSave")
    public String tmpSave(UserDto userDto){
        System.out.println("applyNumber = " + userDto.getApplyNumber());
        User findUser = userService.findByApplyNumber(userDto.getApplyNumber());
        if(findUser.getId()==null){
            userService.save(User.toEntity(userDto));
        }else{
            userService.update(findUser.getId(),User.toEntity(userDto));
        }
        return "redirect:/wrt01";
    }
    @PostMapping("/save")
    public String save(UserDto userDto){
        System.out.println("applyNumber = " + userDto.getApplyNumber());
        User findUser = userService.findByApplyNumber(userDto.getApplyNumber());
        if(findUser.getId()==null){
            userService.save(User.toEntity(userDto));
        }else{
            userService.update(findUser.getId(),User.toEntity(userDto));
        }
        return "redirect:/wrt02";
    }
}

package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.thymeleaf.util.StringUtils;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final FileService fileService;
    private final String  initPath = "/static/images/profile.png";

    @PostMapping("/tmpSave")
    public String tmpSave(UserDto userDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        MultipartFile pictureFile = multipartHttpServletRequest.getFile("pictureFile");
        User byApplyNumber = userService.findByApplyNumber(userDto.getApplyNumber(),initPath);

        if(pictureFile.getOriginalFilename().equals("")){    // 사진 없이 넘어가는 경우의 수, 이미 저장되어있던 로직을 계속 실현하고자 하는 경우.
            if(StringUtils.isEmpty(byApplyNumber.getFile().getOriginalFileName())){  // 기본 이미지를 띄우고 싶을 때
                File file = new File(initPath);
                userDto.setFile(file);
            }else{
                userDto.setFile(byApplyNumber.getFile());
            }
        }else{
            // 업데이트 하기 위해, 파일이 있다면, 지워주는 로직.
            if(!ObjectUtils.isEmpty(byApplyNumber.getFile())){
//            if(byApplyNumber.getFile().getFileSize() != null){
                fileService.deleteProfileImageById(byApplyNumber.getId(),byApplyNumber.getFile().getId());
            }
            // 저장 로직.
            File savedProfile = fileService.savePictureInfo(userDto, multipartHttpServletRequest);
            if(savedProfile!=null){
                userDto.setFile(savedProfile);
            }
        }

        User findUser = userService.findByApplyNumber(userDto.getApplyNumber(),initPath);
        if(findUser.getId()==null){
            userService.save(User.toEntity(userDto));
        }else{
            userService.update(findUser.getId(),User.toEntity(userDto));
        }
        return "redirect:/wrt01";
    }

    @PostMapping("/save")
    public String save(UserDto userDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
//        MultipartFile pictureFile = multipartHttpServletRequest.getFile("pictureFile");
//        if(pictureFile == null){    // 사진 없이 넘어가는 경우의 수, 이미 저장되어있던 로직을 계속 실현하고자 하는 경우.
//            if(userDto.getFile() == null){
//                File tmpFile = new File("/static/images/profile.png");
//                userDto.setFile(tmpFile);
//            }
//        }else{
//            // 업데이트 하기 위해, 파일이 있다면, 지워주는 로직.
//            if(userDto.getFile() != null){
//                Long id = userDto.getFile().getId();
//                fileService.deleteProfileImageById(userDto.getFile().getId());
//                userDto.setFile(null);
//            }
//            // 저장 로직.
//            File savedProfile = fileService.savePictureInfo(userDto, multipartHttpServletRequest);
//            if(savedProfile!=null){
//                userDto.setFile(savedProfile);
//            }
//        }
//
//        User findUser = userService.findByApplyNumber(userDto.getApplyNumber(),initPath);
//        if(findUser.getId()==null){
//            userService.save(User.toEntity(userDto));
//        }else{
//            userService.update(findUser.getId(),User.toEntity(userDto));
//        }
        return "redirect:/wrt02";
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(1024*1024*10);
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }
}

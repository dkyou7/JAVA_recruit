package com.ktnet.recruit.web.certificate;


import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.file.FileService;
import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserDto;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.thymeleaf.util.StringUtils;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cert")
public class CertificateController {
    private final UserService userService;
    private final FileService fileService;
    private final FirstPageService firstPageService;

}

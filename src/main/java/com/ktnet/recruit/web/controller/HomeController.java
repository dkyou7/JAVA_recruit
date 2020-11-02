package com.ktnet.recruit.web.controller;

import com.ktnet.recruit.web.first_page.FirstPage;
import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.jobInfo.JobInfo;
import com.ktnet.recruit.web.jobInfo.JobInfoService;
import com.ktnet.recruit.web.policy.Policy;
import com.ktnet.recruit.web.policy.PolicyDto;
import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserDto;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Logger loggger = LoggerFactory.getLogger(this.getClass());
    private final JobInfoService jobInfoService;
    private final FirstPageService firstPageService;
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model){
        loggger.info("=== [start] home(Model model) ===");

        model.addAttribute("dto",new FirstPageDto());
        loggger.info("=== [jobInfoService.findAll()] ===");
        List<JobInfo> list = jobInfoService.findAll();
        model.addAttribute("gubun",list);

        loggger.info("=== [  end] home(Model model) ===");
        return "first_page";
    }

    @GetMapping("/policy")
    public String dispPolicy(Model model){
        loggger.info("=== [start] dispPolicy(Model model) ===");

        model.addAttribute("dto",new PolicyDto(false,false,false));

        loggger.info("=== [  end] dispPolicy(Model model) ===");
        return "policy";
    }

    @GetMapping("/process")
    public String dispProcess(){
        return "process";
    }

    @GetMapping("/wrt01")
    public String dispWrt01(HttpServletRequest request, Model model) throws IOException {
        loggger.info("=== [start] dispWrt01(HttpServletRequest request, Model model) ===");
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userSession");
        if(userId==null){
            return "redirect:/";
        }
        FirstPage firstPage = firstPageService.findById(userId);
        FirstPageDto dto = FirstPageDto.toDto(firstPage);
        model.addAttribute("dto",dto);

        // 유저 정보 내려주기
        User findUser = userService.findByApplyNumber(dto.getApplyNumber());
        UserDto userDto = UserDto.toDto(findUser);  // user to userdto
        model.addAttribute("user",userDto);
        loggger.info("=== [  end] dispWrt01(HttpServletRequest request, Model model) ===");
        return "wrt_01_";
    }

    @GetMapping("/wrt02")
    public String dispWrt02(){
        return "wrt_02_";
    }

    @GetMapping("/wrt03")
    public String dispWrt03(){
        return "wrt_03_";
    }


}

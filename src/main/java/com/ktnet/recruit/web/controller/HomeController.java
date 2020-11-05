package com.ktnet.recruit.web.controller;

import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.first_page.FirstPage;
import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.jobInfo.JobInfo;
import com.ktnet.recruit.web.jobInfo.JobInfoService;
import com.ktnet.recruit.web.policy.PolicyDto;
import com.ktnet.recruit.web.question.Question;
import com.ktnet.recruit.web.question.QuestionDto;
import com.ktnet.recruit.web.question.QuestionService;
import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserDto;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Logger loggger = LoggerFactory.getLogger(this.getClass());
    private final JobInfoService jobInfoService;
    private final FirstPageService firstPageService;
    private final UserService userService;
    private final QuestionService questionService;

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
    public String dispPolicy(HttpServletRequest request, Model model){
        loggger.info("=== [start] dispPolicy(Model model) ===");
        HttpSession session = request.getSession();
        String applyNumber = (String) session.getAttribute("userSession");
        if(applyNumber==null){
            return "redirect:/";
        }
        model.addAttribute("userId",applyNumber);
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
        String applyNumber = (String) session.getAttribute("userSession");
        if(applyNumber==null){
            return "redirect:/";
        }
        FirstPage firstPage = firstPageService.findByApplyNumber(applyNumber);
        FirstPageDto dto = FirstPageDto.toDto(firstPage);
        model.addAttribute("dto",dto);

        // 유저 정보 내려주기
        String path = "/static/images/profile.png";
        User findUser = userService.findByApplyNumber(dto.getApplyNumber(),path);

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
    public String dispWrt03(HttpServletRequest request, Model model) throws IOException {
        loggger.info("=== [start] dispWrt03(HttpServletRequest request, Model model) ===");
        HttpSession session = request.getSession();
        String applyNumber = (String) session.getAttribute("userSession");
        if(applyNumber==null){
            return "redirect:/";
        }
        // 유저 정보 내려주기
        model.addAttribute("userId",applyNumber);

        // 자소서 정보 내려주기
        User findUser = userService.findByApplyNumber(applyNumber);

        // 없으면, 초기화시켜주는 로직 추가
        if(ObjectUtils.isEmpty(findUser.getQuestion())){
            Question question = Question.initQuestion();
            findUser.initQuestion(question);
        }
        QuestionDto questionDto = QuestionDto.toDto(findUser.getQuestion());
        model.addAttribute("dto",questionDto);


        loggger.info("=== [  end] dispWrt03(HttpServletRequest request, Model model) ===");
        return "wrt_03_";
    }


}

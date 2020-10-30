package com.ktnet.recruit.web.controller;

import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.jobInfo.JobInfo;
import com.ktnet.recruit.web.jobInfo.JobInfoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Logger loggger = LoggerFactory.getLogger(this.getClass());
    private final JobInfoService jobInfoService;

    @GetMapping("/")
    public String home(Model model){
        loggger.info("=== [start] home(Model model) ===");
        model.addAttribute("dto",new FirstPageDto());
        loggger.info("=== [jobInfoService.findAll()] ===");
        List<JobInfo> list = jobInfoService.findAll();
        model.addAttribute("gubun",list);
        return "first_page";
    }

    @GetMapping("/policy")
    public String dispPolicy(){
        return "policy";
    }

    @GetMapping("/process")
    public String dispProcess(){
        return "process";
    }

    @GetMapping("/wrt01")
    public String dispWrt01(){
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

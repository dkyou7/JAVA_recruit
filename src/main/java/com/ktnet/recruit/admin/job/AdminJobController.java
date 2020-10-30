package com.ktnet.recruit.admin.job;

import com.ktnet.recruit.web.jobInfo.JobInfoDto;
import com.ktnet.recruit.web.jobInfo.JobInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/job")
public class AdminJobController {

    private final JobInfoService jobInfoService;

    @GetMapping("/save")
    public String dispSave(Model model){
        model.addAttribute("dto",new JobInfoDto());
        return "";
    }

    @PostMapping("/save")
    public void save(JobInfoDto jobInfoDto){
        jobInfoService.save(jobInfoDto);
    }

    @GetMapping("/saveDummy")
    public String saveDummy(){
        JobInfoDto jobInfoDto = new JobInfoDto();

        jobInfoDto.setRecruitName("정기채용");
        jobInfoService.save(jobInfoDto);

        jobInfoDto.setRecruitName("수시채용");
        jobInfoService.save(jobInfoDto);

        jobInfoDto.setRecruitName("커스텀 특별 채용");
        jobInfoService.save(jobInfoDto);

        return "redirect:/";
    }
}

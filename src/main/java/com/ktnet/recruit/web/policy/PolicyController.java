package com.ktnet.recruit.web.policy;

import com.ktnet.recruit.web.first_page.FirstPage;
import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.first_page.FirstPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/policy")
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping("/permit")
    public String permit_policy_page(PolicyDto dto){
        if(dto.isAgree()){
            Policy policy = Policy.toEntity(dto);
            policyService.save(policy);
            return "redirect:/wrt01";
        }
        return "redirect:/policy";
    }

}

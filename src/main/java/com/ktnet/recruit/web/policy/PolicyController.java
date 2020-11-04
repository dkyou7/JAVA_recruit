package com.ktnet.recruit.web.policy;

import com.ktnet.recruit.web.first_page.FirstPage;
import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/policy")
public class PolicyController {

    private final PolicyService policyService;
    private final FirstPageService firstPageService;

    @PostMapping("/permit")
    public String permit_policy_page(PolicyDto dto,String userId){    // userId => firstPageId
        Long firstPageId = Long.parseLong(userId);
        if(dto.isAgree()){
            FirstPage findFirstPage = firstPageService.findById(firstPageId);
            dto.setFirstPage(findFirstPage);
            Policy policy = Policy.toEntity(dto);
            policyService.save(policy);
            firstPageService.setPolicy(firstPageId,policy);
            return "redirect:/wrt01";
        }
        return "redirect:/policy";
    }

}

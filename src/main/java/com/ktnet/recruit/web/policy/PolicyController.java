package com.ktnet.recruit.web.policy;

import com.ktnet.recruit.web.first_page.FirstPage;
import com.ktnet.recruit.web.first_page.FirstPageDto;
import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/policy")
public class PolicyController {

    private final FirstPageService firstPageService;

    @PostMapping("/permit")
    public String permit_policy_page(PolicyDto dto,@RequestParam("applyNumber") String applyNumbeer){    // userId => firstPageId
        if(dto.isAgree()){
            firstPageService.updatePolicy(applyNumbeer,dto);
            return "redirect:/wrt01";
        }
        return "redirect:/policy";
    }

}

package com.ktnet.recruit.web.question;

import com.ktnet.recruit.web.first_page.FirstPageService;
import com.ktnet.recruit.web.policy.PolicyDto;
import com.ktnet.recruit.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @PostMapping("/tmpSave")
    public String tmpSave(@RequestParam("applyNumber") String applyNumber,QuestionDto dto){    // userId => firstPageId
        Long savedId = questionService.save(dto);
        userService.updateQuestion(applyNumber,savedId);
        return "redirect:/wrt03";
    }

    @PostMapping("/save")
    public String save(@RequestParam("applyNumber") String applyNumber,QuestionDto dto){    // userId => firstPageId
        Long savedId = questionService.save(dto);
        userService.updateQuestion(applyNumber,savedId);
        return "redirect:/";
    }

}

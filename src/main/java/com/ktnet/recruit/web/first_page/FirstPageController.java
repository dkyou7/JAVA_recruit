package com.ktnet.recruit.web.first_page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/first_page")
public class FirstPageController {

    private final FirstPageService firstPageService;

    @PostMapping("/permit")
    public String permit_first_page(FirstPageDto firstPageDto){

        if(firstPageService.permit(firstPageDto)){
            FirstPage firstPage = FirstPage.toEntity(firstPageDto);
            // todo: 추후 user table과 one to one 으로 엮여야 하지 않을까?
            firstPageService.save(firstPage);
            return "redirect:/policy";
        }
        return "redirect:/";
    }

}

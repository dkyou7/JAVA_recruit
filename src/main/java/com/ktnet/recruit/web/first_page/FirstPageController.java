package com.ktnet.recruit.web.first_page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/first_page")
public class FirstPageController {

    @PostMapping("/permit")
    public String permit_first_page(FirstPageDto firstPageDto){
        return "";
    }

}

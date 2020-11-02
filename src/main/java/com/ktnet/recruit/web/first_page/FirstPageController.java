package com.ktnet.recruit.web.first_page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/first_page")
public class FirstPageController {

    private final FirstPageService firstPageService;

    @PostMapping("/permit")
    public String permit_first_page(HttpServletRequest request, FirstPageDto firstPageDto,@RequestParam String test){
        if(firstPageService.isExist(firstPageDto)){  // 지원정보가 존재한다면
            FirstPage findUser = firstPageService.findByApplyNumber(firstPageDto.getApplyNumber());
            // 세션 만들어주자.
            HttpSession session = request.getSession();
            if(session.getAttribute("userSession") == null){
                session.setAttribute("userSession", findUser.getId());
            }
            return "redirect:/wrt01";
        }else{  // 존재하지 않는다.
            // 일단 새로운 회원정보를 만들어주자.
            firstPageDto.setApplyInfoGubun(test);
            FirstPage firstPage = FirstPage.toEntity(firstPageDto);
            // todo: 추후 user table과 one to one 으로 엮여야 하지 않을까?
            firstPageService.save(firstPage);
            // 세션 만들어주자.
            HttpSession session = request.getSession();
            session.setAttribute("userSession", firstPage.getId());
            return "redirect:/policy";
        }
    }

}

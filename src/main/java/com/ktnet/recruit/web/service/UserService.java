package com.ktnet.recruit.web.service;

import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(String password, String reg_emp_num){
        if(isUser(reg_emp_num)){
            System.out.println("=====기존 가입한 회원입니다.=====");
            return userRepository.findByRegEmpNum(reg_emp_num);
        }else{
            System.out.println("=====처음 가입한 회원입니다.=====");
            User user = User.builder().password(password).reg_emp_num(reg_emp_num).build();
            userRepository.save(user);
            return user;
        }
    }

    @Transactional
    public boolean isUser(String regular_emp_num) {
        User findUser = userRepository.findByRegEmpNum(regular_emp_num);
        if(findUser==null){
            return false;
        }
        return true;
    }
}

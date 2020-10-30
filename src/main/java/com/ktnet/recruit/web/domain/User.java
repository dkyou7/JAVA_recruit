package com.ktnet.recruit.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String regEmpNum;

    @Builder
    public User(String password, String reg_emp_num) {
        this.password = password;
        this.regEmpNum = reg_emp_num;
    }
}

package com.ktnet.recruit.web.policy;

import com.ktnet.recruit.web.first_page.FirstPage;
import lombok.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class Policy {
    private Boolean agreeChk1;
    private Boolean agreeChk2;
    private Boolean agreeChk3;
}

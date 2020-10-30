package com.ktnet.recruit.web.first_page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirstPage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;    // 비밀번호
    private String applyInfoGubun;    // 지원 정보 구분
    private String applyNumber;      // 지원 번호

    public static FirstPage toEntity(FirstPageDto dto) {
        return FirstPage.builder()
                .password(dto.getPassword())
                .applyInfoGubun(dto.getApplyInfoGubun())
                .applyNumber(dto.getApplyNumber())
                .build();
    }
}

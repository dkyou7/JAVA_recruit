package com.ktnet.recruit.web.first_page;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirstPageDto {

    private String password;    // 비밀번호
    private String applyInfoGubun;    // 지원 정보 구분
    private String applyNumber;      // 지원 번호

    public static FirstPageDto toDto(FirstPage findUser) {
        return FirstPageDto.builder()
                .applyInfoGubun(findUser.getApplyInfoGubun())
                .applyNumber(findUser.getApplyNumber())
                .build();
    }
}

package com.ktnet.recruit.web.policy;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyDto {
    private Boolean agreeChk1;
    private Boolean agreeChk2;
    private Boolean agreeChk3;

    public PolicyDto(boolean b, boolean b1, boolean b2) {
        this.agreeChk1 = b;
        this.agreeChk2 = b1;
        this.agreeChk3 =b2;
    }

    public static Policy toEntity(PolicyDto dto) {
        return Policy.builder()
                .agreeChk1(dto.getAgreeChk1())
                .agreeChk2(dto.getAgreeChk2())
                .agreeChk3(dto.getAgreeChk3())
                .build();
    }

    public boolean isAgree() {
        if(this.agreeChk1 && this.agreeChk2 && this.agreeChk3){
            return true;
        }else{
            return false;
        }
    }
}

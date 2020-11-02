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

    public boolean isAgree() {
        if(this.agreeChk1 && this.agreeChk2 && this.agreeChk3){
            return true;
        }else{
            return false;
        }
    }
}

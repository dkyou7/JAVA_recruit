package com.ktnet.recruit.web.policy;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Policy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long id;

    private Boolean agreeChk1;
    private Boolean agreeChk2;
    private Boolean agreeChk3;

    public Policy(boolean b, boolean b1, boolean b2) {
        this.agreeChk1 = b;
        this.agreeChk2 = b1;
        this.agreeChk3 = b2;
    }

    public static Policy toEntity(PolicyDto dto) {
        return Policy.builder()
                .agreeChk1(dto.getAgreeChk1())
                .agreeChk2(dto.getAgreeChk2())
                .agreeChk3(dto.getAgreeChk3())
                .build();
    }
}

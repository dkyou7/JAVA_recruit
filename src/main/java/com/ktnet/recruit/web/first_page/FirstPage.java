package com.ktnet.recruit.web.first_page;

import com.ktnet.recruit.web.policy.Policy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // 1:1 단방향
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private Policy policy;

    public static FirstPage toEntity(FirstPageDto dto) {
        return FirstPage.builder()
                .password(dto.getPassword())
                .applyInfoGubun(dto.getApplyInfoGubun())
                .applyNumber(dto.getApplyNumber())
                .build();
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}

package com.ktnet.recruit.web.jobInfo;

import lombok.*;

import javax.persistence.Entity;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobInfoDto {
    private String recruitName; // 신입, 경력, 수시채용, 등 관리자페이지에서 커스터마이징 가능하도록 구현
}

package com.ktnet.recruit.web.jobInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_info_id")
    private Long id;

    private String recruitName; // 신입, 경력, 수시채용, 등 관리자페이지에서 커스터마이징 가능하도록 구현

    public static JobInfo toEntity(JobInfoDto dto) {
        JobInfo jobInfo = new JobInfo();
        jobInfo.recruitName = dto.getRecruitName();
        return jobInfo;
    }
}

package com.ktnet.recruit.web.jobInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobInfoService {
    private final JobInfoRepository jobInfoRepository;

    @Transactional
    public void save(JobInfoDto dto){
        JobInfo jobInfo = JobInfo.toEntity(dto);
        jobInfoRepository.save(jobInfo);
    }

    public List<JobInfo> findAll() {
        return jobInfoRepository.findAll();
    }
}

package com.ktnet.recruit.web.policy;

import com.ktnet.recruit.web.first_page.FirstPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PolicyService {
    private final PolicyRepository policyRepository;

    @Transactional
    public void save(Policy policy) {
        policyRepository.save(policy);
    }
}

package com.ktnet.recruit.web.first_page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class FirstPageService {

    private final FirstPageRepository firstPageRepository;

    @Transactional
    public boolean isExist(FirstPageDto dto){
        FirstPage findInfo = firstPageRepository.findByApplyNumber(dto.getApplyNumber());
        // todo: 지원 정보를 가지고 처리하는 로직이 필요하다.
        if(findInfo==null){
            return false;
        }
        return true;
    }

    @Transactional
    public void save(FirstPage firstPage) {
        firstPageRepository.save(firstPage);
    }

    @Transactional
    public FirstPage findById(Long userId) {
        return firstPageRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public FirstPage findByApplyNumber(String applyNumber) {
        return firstPageRepository.findByApplyNumber(applyNumber);
    }
}

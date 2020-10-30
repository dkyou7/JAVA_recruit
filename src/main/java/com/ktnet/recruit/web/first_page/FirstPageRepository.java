package com.ktnet.recruit.web.first_page;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstPageRepository extends JpaRepository<FirstPage,Long> {
    FirstPage findByApplyNumber(String applyNumber);
}

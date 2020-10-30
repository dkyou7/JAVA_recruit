package com.ktnet.recruit.web.repository;

import com.ktnet.recruit.web.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByRegEmpNum(String regular_emp_num);
}

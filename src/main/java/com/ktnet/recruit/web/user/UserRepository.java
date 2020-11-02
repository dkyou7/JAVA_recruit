package com.ktnet.recruit.web.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByApplyNumber(String applyNumber);
}

package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByApplyNumber(String applyNumber);

    User findByFile(File byId);
}

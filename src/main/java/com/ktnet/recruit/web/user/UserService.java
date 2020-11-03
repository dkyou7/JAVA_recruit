package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.file.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User findByApplyNumber(String applyNumber,String filePath) {
        // 유저 정보가 없으면, 접수 번호를 기본생성자로 지정하여 만들어준다.
        return userRepository.findByApplyNumber(applyNumber).orElse(new User(applyNumber,filePath));
    }

    @Transactional
    public User update(Long userId, User tmpUser) {
        User new_user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        new_user.update(tmpUser);
        return new_user;
    }
}

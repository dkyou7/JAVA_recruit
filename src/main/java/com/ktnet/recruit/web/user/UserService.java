package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.file.FileRepository;
import com.ktnet.recruit.web.question.Question;
import com.ktnet.recruit.web.question.QuestionDto;
import com.ktnet.recruit.web.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public User save(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Transactional
    public User findByApplyNumber(String applyNumber,String filePath) {
        // 유저 정보가 없으면, 접수 번호를 기본생성자로 지정하여 만들어준다.
        return userRepository.findByApplyNumber(applyNumber).orElse(new User(applyNumber,filePath));
    }

    @Transactional
    public User findByApplyNumber(String applyNumber) {// 유저 정보가 없으면, 접수 번호를 기본생성자로 지정하여 만들어준다.
        return userRepository.findByApplyNumber(applyNumber).orElse(new User(applyNumber,"/static/images/profile.png"));
    }

    @Transactional
    public User updateUserInfo(Long userId, User tmpUser) {
        User new_user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        new_user.updateUserInfo(tmpUser);
        return new_user;
    }

    @Transactional
    public void updateQuestion(Long userId, Long questionId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Question question = questionRepository.findById(questionId).orElseThrow(EntityNotFoundException::new);
        user.updateQuestion(question);
    }

    @Transactional
    public User findById(Long userId) {
        return  userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }


}

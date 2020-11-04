package com.ktnet.recruit.web.question;

import com.ktnet.recruit.web.file.FileRepository;
import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public Long save(QuestionDto dto) {
        Question question = QuestionDto.toEntity(dto);
        Question answer = questionRepository.save(question);
        return answer.getId();
    }

}

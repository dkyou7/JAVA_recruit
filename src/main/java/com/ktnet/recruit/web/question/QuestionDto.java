package com.ktnet.recruit.web.question;

import com.ktnet.recruit.web.user.User;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;

    public static Question toEntity(QuestionDto dto) {
        return Question.builder()
                .question1(dto.getQuestion1())
                .question2(dto.getQuestion2())
                .question3(dto.getQuestion3())
                .question4(dto.getQuestion4())
                .question5(dto.getQuestion5())
                .build();
    }

    public static QuestionDto toDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion1(question.getQuestion1());
        questionDto.setQuestion2(question.getQuestion2());
        questionDto.setQuestion3(question.getQuestion3());
        questionDto.setQuestion4(question.getQuestion4());
        questionDto.setQuestion5(question.getQuestion5());
        return questionDto;
    }
}

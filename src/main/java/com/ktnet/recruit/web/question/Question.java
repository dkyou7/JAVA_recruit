package com.ktnet.recruit.web.question;

import com.ktnet.recruit.web.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(length = 1000)
    private String question1;

    @Column(length = 1800)
    private String question2;

    @Column(length = 1400)
    private String question3;

    @Column(length = 1000)
    private String question4;

    @Column(length = 500)
    private String question5;

    public static Question initQuestion() {
        return new Question();
    }
}

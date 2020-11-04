package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import com.ktnet.recruit.web.question.Question;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String e_name;
    private String email;
    private String phoneNumber;
    private String homeNumber;
    private Boolean isMarried;
    private String speciality;
    private String hobby;
    private String religion;
    private String applyNumber;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;


    // 1:1 단방향
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File file;

    public User(String applyNumber,String filePath) {
        this.applyNumber = applyNumber;
        File file = new File(filePath);
        this.file = file;
    }

    public static User toEntity(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .e_name(dto.getEName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .homeNumber(dto.getHomeNumber())
                .isMarried(dto.getIsMarried())
                .speciality(dto.getSpeciality())
                .hobby(dto.getHobby())
                .religion(dto.getReligion())
                .applyNumber(dto.getApplyNumber())
                .file(dto.getFile())
                .build();
    }

    public void updateUserInfo(User tmpUser) {
         this.name = tmpUser.getName();
         this.e_name = tmpUser.getE_name();
         this.email = tmpUser.getEmail();
         this.phoneNumber = tmpUser.getPhoneNumber();
         this.homeNumber = tmpUser.getHomeNumber();
         this.isMarried = tmpUser.getIsMarried();
         this.speciality = tmpUser.getSpeciality();
         this.hobby = tmpUser.getHobby();
         this.religion = tmpUser.getReligion();
         this.applyNumber = tmpUser.getApplyNumber();
         this.file = tmpUser.getFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void updateQuestion(Question question) {
        this.question = question;
    }

    public void initQuestion(Question question) {
        this.question = question;
    }
}

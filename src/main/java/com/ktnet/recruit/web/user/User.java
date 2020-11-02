package com.ktnet.recruit.web.user;

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
    private String c_name;
    private String email;
    private String phoneNumber;
    private String homeNumber;
    private Boolean isMarried;
    private String speciality;
    private String hobby;
    private String religion;
    private String applyNumber;

    public User(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public static User toEntity(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .c_name(dto.getCName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .homeNumber(dto.getHomeNumber())
                .isMarried(dto.getIsMarried())
                .speciality(dto.getSpeciality())
                .hobby(dto.getHobby())
                .religion(dto.getReligion())
                .applyNumber(dto.getApplyNumber())
                .build();
    }

    public void update(User tmpUser) {
         this.name = tmpUser.getName();
         this.c_name = tmpUser.getC_name();
         this.email = tmpUser.getEmail();
         this.phoneNumber = tmpUser.getPhoneNumber();
         this.homeNumber = tmpUser.getHomeNumber();
         this.isMarried = tmpUser.getIsMarried();
         this.speciality = tmpUser.getSpeciality();
         this.hobby = tmpUser.getHobby();
         this.religion = tmpUser.getReligion();
         this.applyNumber = tmpUser.getApplyNumber();
    }
}

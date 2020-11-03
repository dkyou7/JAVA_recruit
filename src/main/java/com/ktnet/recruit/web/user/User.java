package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
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

    // 1:1 단방향
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fileId")
    private File file;

    public User(String applyNumber,String filePath) {
        this.applyNumber = applyNumber;
        File file = new File(filePath);
        this.file = file;
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
                .file(dto.getFile())
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
         this.file = tmpUser.getFile();
    }

    public void setFile(File tmpFile) {
        this.file = tmpFile;
    }
}

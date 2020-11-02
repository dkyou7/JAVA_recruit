package com.ktnet.recruit.web.user;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String cName;
    private String email;
    private String phoneNumber;
    private String homeNumber;
    private Boolean isMarried;
    private String speciality;
    private String hobby;
    private String religion;
    private String applyNumber;

    // 지원정보를 dto 로 내려주고 나중에 이걸로 연결시키자.
    public UserDto(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public static UserDto toDto(User entity) {
        UserDto answer = UserDto.builder()
                .name(entity.getName())
                .cName(entity.getC_name())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .homeNumber(entity.getHomeNumber())
                .isMarried(entity.getIsMarried())
                .speciality(entity.getSpeciality())
                .hobby(entity.getHobby())
                .religion(entity.getReligion())
                .applyNumber(entity.getApplyNumber())
                .build();
        return answer;
    }
}

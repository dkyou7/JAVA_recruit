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

}

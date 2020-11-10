package com.ktnet.recruit.web.user;

import com.ktnet.recruit.web.file.File;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String eName;
    private String email;
    private String phoneNumber;
    private String postcode;    // 우편번호
    private String extraAddress;    // 부가정보 저장
    private String address;     // 주소
    private String detailAddress;   // 상세주소

    private String isMarried;
    private String speciality;
    private String hobby;
    private String religion;
    private String applyNumber;
    private File file;

    // 지원정보를 dto 로 내려주고 나중에 이걸로 연결시키자.
    public UserDto(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public static UserDto toDto(User entity) {
        UserDto answer = UserDto.builder()
                .name(entity.getName())
                .eName(entity.getE_name())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .isMarried(entity.getIsMarried())
                .postcode(entity.getPostcode())
                .extraAddress(entity.getExtraAddress())
                .address(entity.getAddress())
                .detailAddress(entity.getDetailAddress())
                .speciality(entity.getSpeciality())
                .hobby(entity.getHobby())
                .religion(entity.getReligion())
                .applyNumber(entity.getApplyNumber())
                .file(entity.getFile())
                .build();
        return answer;
    }
    public static UserDto toApplyUserDto(User entity){
        return UserDto.builder()
                .name(entity.getName())
                .eName(entity.getE_name())
                .phoneNumber(entity.getPhoneNumber())
                .id(entity.getId()).build();
    }
}

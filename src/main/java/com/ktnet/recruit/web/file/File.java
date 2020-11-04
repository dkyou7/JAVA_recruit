package com.ktnet.recruit.web.file;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;
    private String originalFileName;    // 본래 유저가 저장한 이름
    private String storedFilePath;  // 변환되어 저장될 이미지 이름
    private Boolean deletedYN;      // 유저가 삭제처리 하였는지
    private Long fileSize;

    // todo: 파일 타입 : 자격증, 프로필이미지 만들기

    public File(String path) {
        this.storedFilePath = path;
    }
}

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
    @Column(name = "fileId")
    private Long id;
    private String originalFileName;    // 본래 유저가 저장한 이름
    private String storedFilePath;  // 변환되어 저장될 이미지 이름
    private Boolean deletedYN;      // 유저가 삭제처리 하였는지
    private Long fileSize;

    public File(String path) {
        this.storedFilePath = path;
    }
}

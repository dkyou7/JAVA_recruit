package com.ktnet.recruit.web.file;

import lombok.Data;

@Data
public class ImageFileDto {

    private String originalFileName;    // 본래 유저가 저장한 이름
    private String storedFilePath;  // 변환되어 저장될 이미지 이름
    private Boolean deletedYN;      // 유저가 삭제처리 하였는지
    private Long fileSize;

    public static File toEntity(ImageFileDto dto) {
        return File.builder().originalFileName(dto.getOriginalFileName())
                .storedFilePath(dto.getStoredFilePath())
                .deletedYN(false)
                .fileSize(dto.getFileSize())
                .build();
    }
}

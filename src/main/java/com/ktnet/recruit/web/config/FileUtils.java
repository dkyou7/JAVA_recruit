package com.ktnet.recruit.web.config;

import com.ktnet.recruit.web.file.ImageFileDto;
import com.ktnet.recruit.web.user.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

    public ImageFileDto parseFileInfo(UserDto user, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;
        }
        ImageFileDto result = new ImageFileDto();   // 결과값 초기화

        // 파일 경로 생성 로직
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "src/main/webapp/static/images/" + current.format(format);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        // iterator 돌면서 파일 생성
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName, originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                if (!multipartFile.isEmpty()) {
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }
                    // 변환 후, 결과값 세팅

                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    result.setFileSize(multipartFile.getSize());
                    result.setOriginalFileName(multipartFile.getOriginalFilename());
                    String storedPath = path.split("webapp")[1];
                    result.setStoredFilePath(storedPath+"/"+newFileName);

                    file = new File(path + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return result;
    }
}
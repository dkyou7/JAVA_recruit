package com.ktnet.recruit.web.file;

import com.ktnet.recruit.web.config.FileUtils;
import com.ktnet.recruit.web.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final FileUtils fileUtils;


    @Transactional
    public File savePictureInfo(UserDto findUser, MultipartHttpServletRequest request) throws Exception {
        ImageFileDto imageFileDto = fileUtils.parseFileInfo(findUser, request);

        if(imageFileDto != null){
            File save = fileRepository.save(ImageFileDto.toEntity(imageFileDto));
            return save;
        }else
            return null;
    }

    @Transactional
    public void deleteProfileImageById(Long fileId) {
        fileRepository.deleteById(fileId);
    }
}

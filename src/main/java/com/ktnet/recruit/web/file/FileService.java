package com.ktnet.recruit.web.file;

import com.ktnet.recruit.web.config.FileUtils;
import com.ktnet.recruit.web.user.User;
import com.ktnet.recruit.web.user.UserDto;
import com.ktnet.recruit.web.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final FileUtils fileUtils;
    private final UserRepository userRepository;


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
    public void deleteProfileImageById(Long userId, Long fileId) {
        File findFile = fileRepository.findById(fileId).orElseThrow(EntityNotFoundException::new);
        User findUser = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        findUser.setFile(null);
        fileRepository.delete(findFile);
    }
}

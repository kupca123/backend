package com.agentesit.academy.backend.service;

import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    /**
     * Save (INSERT) new image to database.
     * @param image Image to save.
     * @return Return the image that was saved.
     */
    public ImageEntity saveImage(ImageEntity image){
        return imageRepository.save(image);

    }
}

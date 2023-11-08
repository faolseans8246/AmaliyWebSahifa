package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateImageFiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements ImageRootService {


    @Autowired
    private final ImageRepository imageRepository;

    public ImageService (ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public TableImage saveImageFiles(TableImage tableImage) {
        return imageRepository.save(tableImage);
    }

    @Override
    public TableImage getImage(long ids) {
        return imageRepository.findById(ids).orElse(null);
    }

}

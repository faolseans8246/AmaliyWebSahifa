package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateImageFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/imagePart")
public class ImageController {

    @Autowired
    private final ImageRootService imageRootService;

    public ImageController (ImageRootService imageRootService) {
        this.imageRootService = imageRootService;
    }


    @GetMapping("/goShowImage")
    public String goShowImagePage() {
        return "/dashboard/mainMenuBar/mediaFiles/imageFiles/showImageFiles";
    }

    @GetMapping("/goToDownPage")
    public String goImageDown() {
        return "/dashboard/mainMenuBar/mediaFiles/imageFiles/imagePages";
    }



}

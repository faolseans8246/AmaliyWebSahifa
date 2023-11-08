package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateImageFiles;

import jakarta.persistence.Table;

import java.util.List;

public interface ImageRootService {


    public TableImage saveImageFiles(TableImage tableImage);

    public TableImage getImage(long ids);
}

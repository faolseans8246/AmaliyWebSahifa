package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RootDocUpdateService {

    public void storeDocFiles(MultipartFile multipartFile);

}

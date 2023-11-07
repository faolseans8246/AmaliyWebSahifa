package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DocUpdateService implements RootDocUpdateService{

    @Autowired
    private final UpdateDocRepository updateDocRepository;

    public DocUpdateService (UpdateDocRepository updateDocRepository) {
        this.updateDocRepository = updateDocRepository;
    }

    @Override
    public void storeDocFiles(MultipartFile multipartFile) {

        TableUpdateDocFiles tableUpdateDocFiles = new TableUpdateDocFiles();

        tableUpdateDocFiles.setDoc_file_name(multipartFile.getOriginalFilename());

        try {
            tableUpdateDocFiles.setDoc_file_data(multipartFile.getBytes());
        } catch (Exception x) {
            x.printStackTrace();
        }

        updateDocRepository.save(tableUpdateDocFiles);
    }

}

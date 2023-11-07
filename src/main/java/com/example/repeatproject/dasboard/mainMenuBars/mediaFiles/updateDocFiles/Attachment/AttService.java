package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles.Attachment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttService implements RootAttachmentService {


    @Autowired
    private final AttachmantsRepository attachmantsRepository;

    public AttService (AttachmantsRepository attachmantsRepository) {
        this.attachmantsRepository = attachmantsRepository;
    }

    @Override
    public TableAttachment saveNotes(TableAttachment tableAttachment) {
        return attachmantsRepository.save(tableAttachment);
    }

    @Override
    public TableAttachment getNotes(long ids) {
        return attachmantsRepository.findById(ids).orElse(null);
    }

    @Override
    public List<TableAttachment> getAllNotes() {
        return attachmantsRepository.findAll();
    }

    @Override
    public void deleteAttach(long ids) {
        attachmantsRepository.deleteById(ids);
    }

    @Override
    public void deleteAll() {
        attachmantsRepository.deleteAll();
    }
}

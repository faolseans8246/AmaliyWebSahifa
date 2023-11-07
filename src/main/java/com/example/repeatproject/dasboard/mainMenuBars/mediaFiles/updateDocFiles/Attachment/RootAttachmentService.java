package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles.Attachment;

import java.util.List;

public interface RootAttachmentService {

    public TableAttachment saveNotes(TableAttachment tableAttachment);

    public TableAttachment getNotes(long ids);

    public List<TableAttachment> getAllNotes();

    public void deleteAttach(long ids);

    public void deleteAll();
}

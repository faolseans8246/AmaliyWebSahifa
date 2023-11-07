package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles.Attachment;


import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/attBase")
public class AttController {

    @Autowired
    private final RootAttachmentService rootAttachmentService;

    public AttController (RootAttachmentService rootAttachmentService) {
        this.rootAttachmentService = rootAttachmentService;
    }

    @GetMapping("/showSite")
    public String showSiteOn() {
        return "/dashboard/mainMenuBar/mediaFiles/documentFiles/AttFiles";
    }

    @PostMapping("/saveNoteAtt")
    public ResponseEntity <TableAttachment> saveNotesToBase(@RequestParam ("fileNote") MultipartFile fileNote) {

        try {

            TableAttachment tableAttachment = new TableAttachment();
            tableAttachment.setFilename(fileNote.getOriginalFilename());
            tableAttachment.setContent_type(fileNote.getContentType());
            tableAttachment.setData(fileNote.getBytes());

            tableAttachment = rootAttachmentService.saveNotes(tableAttachment);
            return ResponseEntity.ok(tableAttachment);

        } catch (Exception x) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }


    @GetMapping("/attTableNote/{ids}")
    public ResponseEntity<byte[]> getNOtes(@PathVariable long ids) {

        TableAttachment tableAttachment = rootAttachmentService.getNotes(ids);

        if (tableAttachment != null) {
            HttpHeaders headers = new HttpHeaders();

            headers.add("Content-Disposition", "inline; filename=" + tableAttachment.getFilename());
            return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType(tableAttachment.getContent_type())).body(tableAttachment.getData());


        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/listNotes")
    public ResponseEntity<List<TableAttachment>> getAllNotesFromAtt() {

        List<TableAttachment> tableAttachmentsAll = rootAttachmentService.getAllNotes();
        return ResponseEntity.ok(tableAttachmentsAll);

    }


    @DeleteMapping("/delAttNotes/{ids}")
    public ResponseEntity <?> deleteAttachNotes (@PathVariable long ids) {

        TableAttachment tableAttachment = rootAttachmentService.getNotes(ids);

        if (tableAttachment != null) {

            rootAttachmentService.deleteAttach(ids);
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }





}

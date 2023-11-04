package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/update_items")
public class DocUpdateController {

    @Autowired
    private final RootDocUpdateService rootDocUpdateService;

    public DocUpdateController (RootDocUpdateService rootDocUpdateService) {
        this.rootDocUpdateService = rootDocUpdateService;
    }


//    Save update file to base
    @PostMapping("/save_uploaded_doc")
    public String saveUpdateDocFiles(@RequestParam("fileUp") MultipartFile doc_file) {

        if (doc_file != null) {
            rootDocUpdateService.storeDocFiles(doc_file);
            return "/dashboard/mainMenuBar/mediaFiles/documentFiles/documentsPage";
        } else {
            return "/dashboard/mainMenuBar/mediaFiles/documentFiles/downloadDocument";
        }
    }

//    go to back from that page

    @GetMapping("/go_back_page")
    public String goBack() {
        return "/dashboard/mainMenuBar/mediaFiles/mediaPage";
    }

}

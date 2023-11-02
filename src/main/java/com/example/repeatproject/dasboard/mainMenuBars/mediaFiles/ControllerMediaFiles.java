package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mediafilespage")
public class ControllerMediaFiles {



//    go to media files from dashbord

    @GetMapping("/go_to_media_files_from_dashboard")
    public String goTpMediaFilesFromDashboard() {
        return "/dashboard/mainMenuBar/mediaFiles/mediaPage";
    }


//    go to dashboard from media file

    @GetMapping("/go_to_dashboard_from_media_files")
    public String goToDashboardFromMediaFiles() {
        return "/dashboard/mainPage";
    }

//    go to documentation page from media files

    @GetMapping("/go_to_documentation_page_from_media_files")
    public String goToDocumentationPageFromMediaFiles() {
        return "/dashboard/mainMenuBar/mediaFiles/documentFiles/documentsPage";
    }


}

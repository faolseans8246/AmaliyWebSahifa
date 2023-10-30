package com.example.repeatproject.dasboard;


import com.example.repeatproject.registration.RepositorySignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class ControllerDashboard {

    @Autowired
    private final RepositorySignIn repositorySignIn;

    public ControllerDashboard (RepositorySignIn repositorySignIn) {
        this.repositorySignIn = repositorySignIn;
    }


//    Go to list Of Users page from Dashboard page
    @GetMapping("/goToListOfUsers")
    public String goToCustomer() {
        return "/dashboard/mainMenuBar/listOfUsers";
    }

//    go to Dashboard page from list of user
    @GetMapping("/goToDashboardPage")
    public String goToHomePage() {
        return "/dashboard/mainPage";
    }


//    go to add user page from lost of user page
    @GetMapping("/goToAddUsers")
    public String goToAddUserPage() {
        return "/dashboard/mainMenuBar/addUserTo";
    }


}

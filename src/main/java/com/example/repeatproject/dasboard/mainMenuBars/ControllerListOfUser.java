package com.example.repeatproject.dasboard.mainMenuBars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mainMenu")
public class ControllerListOfUser {

    @Autowired
    private final RootServiceListOfUser rootServiceListOfUser;


    public ControllerListOfUser (RootServiceListOfUser rootServiceListOfUser) {
        this.rootServiceListOfUser = rootServiceListOfUser;
    }


//    go to user of list page from add user page
    @GetMapping("/goToUsersPage")
    public String goToListOfPage() {
        return "/dashboard/mainMenuBar/listOfUsers";
    }


//    go to add user page from list of user page
    @GetMapping("/goToAddPage")
    public String goToAddUser() {
        return "/dashboard/mainMenuBar/addUserTo";
    }


//    save users to base from add users page
    @PostMapping("/saveToBaseFromListOfUser")
    public String saveListOfUsersToBase(
            @RequestParam (value = "add_firstname") String firstname,
            @RequestParam (value = "add_lastname") String lastname,
            @RequestParam (value = "add_data") String data,
            @RequestParam (value = "add_address") String address,
            @RequestParam (value = "add_phone") String phone

    ) {
        rootServiceListOfUser.saveListOfUsersToBase(firstname, lastname, data, address, phone);

        return "/dashboard/mainMenuBar/listOfUsers";
    }

}

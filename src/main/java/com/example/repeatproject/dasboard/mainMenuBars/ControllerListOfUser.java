package com.example.repeatproject.dasboard.mainMenuBars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//            @RequestParam (value = "add_id", required = false) String ids,
            @RequestParam (value = "add_firstname") String firstname,
            @RequestParam (value = "add_lastname") String lastname,
            @RequestParam (value = "add_data") String data,
            @RequestParam (value = "add_address") String address,
            @RequestParam (value = "add_phone") String phone

    ) {

        if (firstname.isEmpty() || lastname.isEmpty() || data.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            return "/dashboard/mainMenuBar/addUserTo";
        } else {
            rootServiceListOfUser.saveListOfUsersToBase(firstname, lastname, data, address, phone);

            return "/dashboard/mainMenuBar/listOfUsers";
        }
    }


//    get nites from base and set list of user page
    @GetMapping("/getNotesFromBase")
    public String getNotesFromBase(Model model) {
        List<TableListOfUsers> tableListOfUsers = rootServiceListOfUser.getAllUsers();
        model.addAttribute("listofusers", tableListOfUsers);

        return "/dashboard/mainMenuBar/listOfUsers";
    }

//    delete item in list of users by id
    @GetMapping("/deleteIteInListOfUser/{id}")
    public String deleteItemInUsersList(@PathVariable long id) {
        rootServiceListOfUser.deleteItemListOfUser(id);

        return "/dashboard/mainMenuBar/listOfUsers";
    }


//    delete all items in list of users

    @GetMapping("/deleteAllItems")
     public String deleteAllItemsInList() {
        rootServiceListOfUser.deleteAllUsers();

        return "/dashboard/mainMenuBar/listOfUsers";
     }


//     Update items in List of Tables
    @GetMapping("/updateUserNotes/{ids}")
     public String updateIdItems(@PathVariable (value = "ids") long ids, Model model) {
        TableListOfUsers tableListOfUsersIds = rootServiceListOfUser.updateRows(ids);

        model.addAttribute("updateItems", tableListOfUsersIds);
        return "/dashboard/mainMenuBar/updateUserInList";
     }


//     resave users to base from list of user
    @PostMapping("/resaveToBaseUsers")
     public String reSaveToBaseUsers(@ModelAttribute ("updateItems") TableListOfUsers tableListOfUsers) {
        rootServiceListOfUser.reSaveUsers(tableListOfUsers);

        return "/dashboard/mainMenuBar/listOfUsers";
     }


//     Go to list of user page

    @GetMapping("/goToListOfUserPage")
    public String goToListOfUsers() {
        return "/dashboard/mainMenuBar/listOfUsers";
    }

}

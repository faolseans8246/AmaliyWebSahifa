package com.example.repeatproject.dasboard.mainMenuBars;

import org.springframework.ui.Model;

import java.util.List;

public interface RootServiceListOfUser {

//    save users to database from add user page
    public void saveListOfUsersToBase(String firstname, String lastname, String data, String address, String phone);

//    get user from database to list of table
    public List<TableListOfUsers> getAllUsers();

// delete items in list of users by its id with
    public void deleteItemListOfUser(long id);

//    delete all items in list of user
    public void deleteAllUsers();

//    update notes in table
    public TableListOfUsers updateRows(long ids);

//    resave notes to base
    public void reSaveUsers(TableListOfUsers tableListOfUsers);

}

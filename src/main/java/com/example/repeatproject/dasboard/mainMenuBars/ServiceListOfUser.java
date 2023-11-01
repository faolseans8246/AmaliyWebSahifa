package com.example.repeatproject.dasboard.mainMenuBars;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceListOfUser implements RootServiceListOfUser {

    @Autowired
    private final RepositoryListOfUser repositoryListOfUser;

    public ServiceListOfUser (RepositoryListOfUser repositoryListOfUser) {
        this.repositoryListOfUser = repositoryListOfUser;
    }


//    get notes from add user page and it goes to controller class
    @Override
    public void saveListOfUsersToBase(String firstname, String lastname, String data, String address, String phone) {
        TableListOfUsers tableListOfUsers = new TableListOfUsers();
        tableListOfUsers.setFirstname_list(firstname);
        tableListOfUsers.setLastname_list(lastname);
        tableListOfUsers.setData_list(data);
        tableListOfUsers.setAddress_list(address);
        tableListOfUsers.setPhone_list(phone);

        this.repositoryListOfUser.save(tableListOfUsers);
    }

    @Override
    public List<TableListOfUsers> getAllUsers() {
        return repositoryListOfUser.findAll();
    }


    // delete items in list of users by its id with
    @Override
    public void deleteItemListOfUser(long id) {
        this.repositoryListOfUser.deleteById(id);
    }


    //    delete all items in list of user
    @Override
    public void deleteAllUsers() {
        this.repositoryListOfUser.deleteAll();
    }

    //    update notes in table

    @Override
    public TableListOfUsers updateRows(long ids) {
        Optional <TableListOfUsers> tableListOfUsersId = repositoryListOfUser.findById(ids);
        TableListOfUsers tableListOfUsers = null;

        if (tableListOfUsersId.isPresent()) {
            tableListOfUsers = tableListOfUsersId.get();
        } else {
            throw new RuntimeException("User ID bilan muammo mavjud! -> " + tableListOfUsersId);
        }

        return tableListOfUsers;
    }

    //    resave notes to base
    @Override
    public void reSaveUsers(TableListOfUsers tableListOfUsers) {
        repositoryListOfUser.save(tableListOfUsers);
    }

}

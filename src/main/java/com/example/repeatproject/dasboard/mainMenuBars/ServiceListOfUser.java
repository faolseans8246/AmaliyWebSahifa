package com.example.repeatproject.dasboard.mainMenuBars;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceListOfUser implements RootServiceListOfUser {

    @Autowired
    private final RepositoryListOfUser repositoryListOfUser;

    public ServiceListOfUser (RepositoryListOfUser repositoryListOfUser) {
        this.repositoryListOfUser = repositoryListOfUser;
    }

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

}

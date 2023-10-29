package com.example.repeatproject.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceSignIn implements RootServiceSignIn{

    @Autowired
    private final RepositorySignIn repositorySignIn;

    @Autowired
    private final RepositorySignUp repositorySignUp;

    public ServiceSignIn (RepositorySignIn repositorySignIn, RepositorySignUp repositorySignUp) {
        this.repositorySignIn = repositorySignIn;
        this.repositorySignUp = repositorySignUp;
    }


    @Override
    public void saveLoginAndParol(String username, String password) {
        TableSignIn tableSignIn = new TableSignIn();
        tableSignIn.setUsername_id(username);
        tableSignIn.setPassword_id(password);

        this.repositorySignIn.save(tableSignIn);
    }

    @Override
    public void saveSignUpUsersToBase(String username, String email, String password, String confirm_password) {
        TableSignUp tableSignUp = new TableSignUp();
        tableSignUp.setUsername_up(username);
        tableSignUp.setEmail_up(email);
        tableSignUp.setPassword_up(password);
        tableSignUp.setConfirm_password_up(confirm_password);

        this.repositorySignUp.save(tableSignUp);
    }
}

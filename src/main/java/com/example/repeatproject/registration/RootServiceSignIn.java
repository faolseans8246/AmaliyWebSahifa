package com.example.repeatproject.registration;

import org.springframework.ui.Model;

public interface RootServiceSignIn {

    public void saveLoginAndParol(String username, String password);

    public void saveSignUpUsersToBase(String username, String email, String password, String confirm_password);

}

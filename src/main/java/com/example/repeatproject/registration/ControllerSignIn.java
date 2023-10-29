package com.example.repeatproject.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ControllerSignIn {

    @Autowired
    private final RootServiceSignIn rootServiceSignIn;

    public ControllerSignIn (RootServiceSignIn rootServiceSignIn) {
        this.rootServiceSignIn = rootServiceSignIn;
    }


    @GetMapping("/")
    public String onHome(Model model) {
        model.addAttribute("logins", new TableSignIn());
        return "/sign_in/signInPage";
    }

//    Save notes to database from Sign in page
    @PostMapping("/saveSignInToBase")
    public String saveToBazaSignIn(@RequestParam (value = "login_in") String username_in, @RequestParam (value = "parol_in") String password_in) {
        rootServiceSignIn.saveLoginAndParol(username_in, password_in);

        return "/dashboard/mainPage";
    }

//        go to Sign in page from sign up page

    /**
    @GetMapping("/goToSignInFromSignUp")
    public String goToSignInFromSignUp() {
        return "/sign_in/signInPage";
    }
    */


//    go to sign up page from sign in page
    @GetMapping("/geToSignUpPage")
    public String goToSignUpFromSignIn() {
        return "/sign_up/signUpPage";
    }


//    save notes to base database from sign up
    @PostMapping("/saveSignUpToBase")
    public String saveToBaseSignUp(
            @RequestParam (value = "username_up") String username_up,
            @RequestParam (value = "email_up") String email_up,
            @RequestParam (value = "password_up") String password_up,
            @RequestParam (value = "confirm_password_up") String confirm_password_up
    ) {
        rootServiceSignIn.saveSignUpUsersToBase(username_up, email_up, password_up, confirm_password_up);

        return "/sign_in/signInPage";
    }


//    go to Dashboard page from Sign in page

//    @GetMapping("/goToDashboardPage")
//    public String goToDash() {
//        return "mainPage";
//    }


}

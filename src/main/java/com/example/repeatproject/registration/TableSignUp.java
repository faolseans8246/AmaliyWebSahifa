package com.example.repeatproject.registration;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "sign_up")
public class TableSignUp implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_up;

    @Column
    private String username_up;

    @Column
    private String email_up;

    @Column
    private String password_up;

    @Column
    private String confirm_password_up;


    public TableSignUp() {
    }

    public TableSignUp(long id_up, String username_up, String email_up, String password_up, String confirm_password_up) {
        this.id_up = id_up;
        this.username_up = username_up;
        this.email_up = email_up;
        this.password_up = password_up;
        this.confirm_password_up = confirm_password_up;
    }

    public long getId_up() {
        return id_up;
    }

    public void setId_up(long id_up) {
        this.id_up = id_up;
    }

    public String getUsername_up() {
        return username_up;
    }

    public void setUsername_up(String username_up) {
        this.username_up = username_up;
    }

    public String getEmail_up() {
        return email_up;
    }

    public void setEmail_up(String email_up) {
        this.email_up = email_up;
    }

    public String getPassword_up() {
        return password_up;
    }

    public void setPassword_up(String password_up) {
        this.password_up = password_up;
    }

    public String getConfirm_password_up() {
        return confirm_password_up;
    }

    public void setConfirm_password_up(String confirm_password_up) {
        this.confirm_password_up = confirm_password_up;
    }
}

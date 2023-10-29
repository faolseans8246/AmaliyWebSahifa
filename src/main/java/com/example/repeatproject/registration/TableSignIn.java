package com.example.repeatproject.registration;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "user_sign_in")
public class TableSignIn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_in;

    @Column
    private String username_id;

    @Column
    private String password_id;


    public TableSignIn() {
    }

    public TableSignIn(long id_in, String username_id, String password_id) {
        this.id_in = id_in;
        this.username_id = username_id;
        this.password_id = password_id;
    }

    public long getId_in() {
        return id_in;
    }

    public void setId_in(long id_in) {
        this.id_in = id_in;
    }

    public String getUsername_id() {
        return username_id;
    }

    public void setUsername_id(String username_id) {
        this.username_id = username_id;
    }

    public String getPassword_id() {
        return password_id;
    }

    public void setPassword_id(String password_id) {
        this.password_id = password_id;
    }
}
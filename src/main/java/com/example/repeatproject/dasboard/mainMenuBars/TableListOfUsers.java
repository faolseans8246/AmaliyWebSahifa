package com.example.repeatproject.dasboard.mainMenuBars;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "list_of_users")
public class TableListOfUsers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_list;

    @Column
    private String firstname_list;

    @Column
    private String lastname_list;

    @Column
    private String data_list;

    @Column
    private String address_list;

    @Column
    private String phone_list;


    public TableListOfUsers() {
    }

    public TableListOfUsers(long id_list, String firstname_list, String lastname_list, String data_list, String address_list, String phone_list) {
        this.id_list = id_list;
        this.firstname_list = firstname_list;
        this.lastname_list = lastname_list;
        this.data_list = data_list;
        this.address_list = address_list;
        this.phone_list = phone_list;
    }

    public long getId_list() {
        return id_list;
    }

    public void setId_list(long id_list) {
        this.id_list = id_list;
    }

    public String getFirstname_list() {
        return firstname_list;
    }

    public void setFirstname_list(String firstname_list) {
        this.firstname_list = firstname_list;
    }

    public String getLastname_list() {
        return lastname_list;
    }

    public void setLastname_list(String lastname_list) {
        this.lastname_list = lastname_list;
    }

    public String getData_list() {
        return data_list;
    }

    public void setData_list(String data_list) {
        this.data_list = data_list;
    }

    public String getAddress_list() {
        return address_list;
    }

    public void setAddress_list(String address_list) {
        this.address_list = address_list;
    }

    public String getPhone_list() {
        return phone_list;
    }

    public void setPhone_list(String phone_list) {
        this.phone_list = phone_list;
    }
}

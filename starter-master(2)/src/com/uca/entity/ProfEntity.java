package com.uca.entity;

import java.sql.Timestamp;

public class ProfEntity {
    private String firstName;
    private String lastName;
    private String password;
    private int id;

    public ProfEntity() {
        //Ignored !
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(String pass) {
        this.password=pass;
    }
    public String getPassword() {
        return password;
    }
}

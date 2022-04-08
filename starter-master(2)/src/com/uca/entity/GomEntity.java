package com.uca.entity;

import java.sql.Timestamp;

public class GomEntity {
    private String name;
    private String description;
    private String color;
    private int id;

    public GomEntity() {
        //Ignored !
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

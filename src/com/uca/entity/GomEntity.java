package com.uca.entity;


import java.sql.Timestamp;

public class GomEntity {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        this.description = des;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

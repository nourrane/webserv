package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.entity.UserEntity;

import static spark.Spark.*;

public class StartServer {

   
    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);


        _Initializer.Init();

        //Defining our routes
        get("/users", (req, res) -> {
            return UserGUI.getAllUsers();
        });

        post("/users", (req, res) -> {
            UserEntity user= new UserEntity();

            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            String id = req.queryParams("id");

            user.setId(Integer.parseInt(id));
            user.setFirstName(firstname);
            user.setLastName(lastname);
            UserGUI.addUsers(user);
            return "Eleve "+user.getId()+" enregistée";
        });

        get("/test", (req, res) -> {

            String test = req.queryParams("a");
            return test;
        });
        
       
    }
}
package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.entity.UserEntity;
import com.uca.entity.EleveEntity;
import com.uca.entity.ProfEntity;
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
        
        get("/eleves", (req, res) -> {
            return EleveGUI.getAllEleves();
        });

        get("/professeurs", (req, res) -> {
            return ProfGUI.getAllProfs();
        });

        post("/users", (req, res) -> {
            UserEntity user= new UserEntity();

            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            //String id = req.queryParams("id");

            //user.setId(Integer.parseInt(id));
            user.setFirstName(firstname);
            user.setLastName(lastname);
            UserGUI.addUsers(user);
            return "User "+user.getFirstName()+" enregisté";
        });

        post("/eleves", (req, res) -> {
            EleveEntity user= new EleveEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
           // String id = req.queryParams("id");

            //user.setId(Integer.parseInt(id));
            user.setFirstName(firstname);
            user.setLastName(lastname);
            EleveGUI.addEleves(user);
            return "Eleve "+user.getFirstName()+" enregisté";
        });

        post("/professeurs", (req, res) -> {
            ProfEntity user= new ProfEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
           // String id = req.queryParams("id");

            //user.setId(Integer.parseInt(id));
            user.setFirstName(firstname);
            user.setLastName(lastname);
            ProfGUI.addProf(user);
            return "Professeur "+user.getFirstName()+" enregisté";
        });
        
        delete("/users", (req, res) -> {
            UserEntity user= new UserEntity();
            String id = req.queryParams("id");
            user.setId(Integer.parseInt(id));
            UserGUI.deleteUsers(user);
            return "Le user"+id+" a été supprimé";
        });

        delete("/professeurs", (req, res) -> {
            ProfEntity user= new ProfEntity();
            String id = req.queryParams("id");
            user.setId(Integer.parseInt(id));
            ProfGUI.deleteProfs(user);
            return "Professeur "+id+" a été supprimé";
        });

        delete("/eleves", (req, res) -> {
            EleveEntity user= new EleveEntity();
            String id = req.queryParams("id");
            user.setId(Integer.parseInt(id));
            EleveGUI.deleteEleves(user);
            return "Eleve "+id+" a été supprimé";
        });


        /*
        get("/test", (req, res) -> {

            String test = req.queryParams("a");
            return test;
        });
        */
       
    }
}
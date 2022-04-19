package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.core.LoginCore;
import com.uca.core.ProfCore;
import com.uca.entity.EleveGomEntity;
import com.uca.entity.EleveEntity;
import com.uca.entity.ProfEntity;
import com.uca.entity.GomEntity;


import spark.*;
import static spark.Spark.*;



/**
 * GET "http://localhost:8081/professeurs" #liste des profs
 * GET "http://localhost:8081/professeurs/?id=1" # affiche nom prenom prof id=1
 * POST "http://localhost:8081/professeurs?firstname=Annie&lastname=Versaire" # ajoute un prof annie versaire 
 * DELETE "http://localhost:8081/professeurs?id=2" # supprime le prof d'id=2
 * 
 * GET "http://localhost:8081/login" #Affiche le prof connecté
 * POST "http://localhost:8081/login?id=2" # Le prof possedant l'id 2 se connecte
 * 
 * GET "http://localhost:8081/eleves" #liste des élèves
 * POST "http://localhost:8081/eleves?firstname=annie&lastame=versaire" #ajoute un eleve annie
 * DELETE "http://localhost:8081/eleves?id=2" #supprime eleve dont id=2
 * 
 * GET "http://localhost:8081/gommettes" #liste des gommettes
 * POST "http://localhost:8081/gommettes?name=gom&description=comportement_mauvais&color=vert" #Poster une nouvelle gommette
 * DELETE "http://localhost:8081/professeurs/?id=1" # delete la gommette d'id=1
 */

public class StartServer {

   
    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes

        /* index */

        get("/index", (req, res) -> { 
            return ProfGUI.getIndex();
        });

        get("/removeCookies", (req, res) -> {
            if (req.cookie("CurrentUser")!=null){
                res.removeCookie("CurrentUser");   
                res.redirect("/removeCookies");        
            }
            else{res.redirect("/index");}
            res.redirect("/index");
            return " ";
        });
        /*  eleve   */
        get("/eleves", (req, res) -> {
            return EleveGUI.getAllEleves();
        });
        
        get("/eleves/:id", (req, res) -> {
            String id = req.params(":id");
            return EleveGUI.getOneEleve(id).getFirstName()+" "+EleveGUI.getOneEleve(id).getLastName();
        });

        post("/eleves", (req, res) -> {

            EleveEntity user= new EleveEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            user.setFirstName(firstname);
            user.setLastName(lastname);
            EleveGUI.addEleves(user);
            return "Eleve "+user.getFirstName()+" enregisté";
        });

        get("/eleves/:id/delete", (req, res) -> {
            EleveEntity user= new EleveEntity();
            String id = req.params("id");
            user.setId(Integer.parseInt(id));
            EleveGUI.deleteEleves(user);
            return "Eleve "+id+" a été supprimé";
        });


        /*  professeurs   */
        get("/professeurs", (req, res) -> {
            return ProfGUI.getAllProfs();
        });
        get("/professeurs/:id", (req, res) -> {
            String id = req.params(":id");
            return ProfGUI.getOneProf(id).getFirstName()+" "+ProfGUI.getOneProf(id).getLastName();
        });

        post("/professeurs", (req, res) -> {
            ProfEntity user= new ProfEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            String password = req.queryParams("password");
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setPassword(password);
            ProfGUI.addProf(user);
            res.redirect("/login");
            return null;
        });

        get("/professeurs/:id/delete", (req, res) -> {
            ProfEntity user= new ProfEntity();
            String id = req.params("id");
            user.setId(Integer.parseInt(id));
            ProfGUI.deleteProfs(user);
            return "Professeur "+id+" a été supprimé";
        });


        /*  gommettes   */

        get("/gommettes", (req, res) -> {
            return GomGUI.getAllGoms(req);
        });

        post("/gommettes", (req, res) -> {
            GomEntity user= new GomEntity();
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            String color = req.queryParams("color");
            user.setName(name);
            user.setDescription(description);
            user.setColor(color);
            GomGUI.addGoms(user);
            res.redirect("/gommettes");
            return null;
            
        });


        get("/gommettes/:id/delete", (req, res) -> {
            GomEntity user= new GomEntity();
            String id = req.params("id");
            user.setId(Integer.parseInt(id));
            GomGUI.deleteGoms(user);
            return "La gommette "+id+" a été supprimée";
        });
        /* attribution gommettes->eleve */
        get("/elevesGom", (req, res) -> {
            return EleveGomGUI.getAllElevesGom();
        }); 
        post("/elevesGom", (req, res) -> {
            EleveGomEntity e= new EleveGomEntity();
            e.setIdEleve(Integer.parseInt(req.queryParams("idEleve")));
            e.setIdGommette(Integer.parseInt(req.queryParams("idGom")));
            EleveGomGUI.addEleveGom(e);
            return "Event créé";
        });

        get("/elevesGom", (req, res) -> {
            EleveGomEntity user= new EleveGomEntity();
            String id = req.params("id");
            user.setId(Integer.parseInt(id));
            EleveGomGUI.deleteEleveGom(user);
            return "L'event "+id+" a été supprimée";
        });

        /* se connecter */
        get("/login", (req, res) -> {
            
            
            return LoginGUI.getLogin(req);
        });

        post("/login", (req, res) -> {
            String id = req.queryParams("id");
            String password = req.queryParams("password");

            if (LoginCore.authentification(id,password)){
                String name = "CurrentUser";
                String value = id;
                res.cookie(name, value);             // set cookie w

                Session session=req.session(true);
                req.session().attribute("id", id);
                res.redirect("/index");

                
                
            }
            else res.redirect("/login");
            return null;
        });

        /*
        get("/test", (req, res) -> {

            String test = req.queryParams("a");
            return test;
        });
        */
       
    }
}
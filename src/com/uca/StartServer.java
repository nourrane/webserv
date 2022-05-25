package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.core.*;
import com.uca.entity.*;


import spark.*;
import static spark.Spark.*;

/** Liste des URI
 * /index : page principale de l'application
 * removeCookies : supprime l'intégralité des cookies
 * /eleves : espace élève
 * /eleves/modify : permet de modier un élève
 * /eleves/create : permet de créer un élève
 * /eleves/delete: permet de supprimer un élève
 * /professeurs: espace professeurs
 * /login: se connecter
 * /gommettes: espace gommettes
 * /gommettes/delete supprimer une gommette
 * /gommettes/create Créer une gommette
 * /gommettes/modify permet de modifier une gommette
 * /elevesGom Espace attribution d'une gommette à élève par un professeur
 * /elevesGom/create: un professeur connecté peut assigner une gommette à un élève
 * /elevesGom/delete : supprimer une attribution
 * /elevesGom/recherche : afficher toutes les gommettes possédées par un élève a partir de son id

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
                req.session().removeAttribute("id");
                res.redirect("/removeCookies");        
            }
            if (req.cookie("incorrect")!=null){
                res.removeCookie("incorrect");           
            }
            res.redirect("/login");
            return " ";
        });



        /*  eleve   */

        get("/eleves", (req, res) -> {
            return EleveGUI.getAllEleves(req);
        });

        get("/eleves/modify", (req, res) -> {
            return EleveGUI.modifyEleveGUI(req);
        });

        get("/eleves/delete", (req, res) -> {
            return EleveGUI.deleteEleveGUI(req);
        });

        get("/eleves/create", (req, res) -> {
            return EleveGUI.createEleveGUI(req);
        }); 

        post("/eleves/create", (req, res) -> {

            EleveEntity user= new EleveEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            user.setFirstName(firstname);
            user.setLastName(lastname);
            EleveCore.addEleve(user);
            res.redirect("/eleves");
            return null;
        });

        post("/eleves/modify", (req, res) -> {

            String id = req.queryParams("id");
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");

            EleveCore.modifyEleve(id, firstname, lastname);
            res.redirect("/eleves");
            return null;
        });

        post("/eleves/delete", (req, res) -> {

            EleveEntity user= new EleveEntity();
            String id = req.queryParams("id");
            EleveGomGUI.DeleteEleveGomWithIdEleveGUI(id);
            user.setId(Integer.parseInt(id));
            EleveCore.deleteEleve(user);
            res.redirect("/eleves");
            return null;
        });



        /*  professeurs   */

        get("/professeurs", (req, res) -> {
            return ProfGUI.getAllProfs();
        });
        
        /* se connecter */

        get("/login", (req, res) -> {
            return LoginGUI.getLogin(req,res);
        });

        post("/login", (req, res) -> {
            String id = req.queryParams("id");
            String password = req.queryParams("password");
            if (LoginCore.authentification(id, password)){
                String name = "CurrentUser";
                String value = id;
                res.cookie(name, value);  
                res.redirect("/professeurs");    
            }
            else {
                res.cookie("incorrect", "0");
                res.redirect("/login");
            }
            return null;
        });



        /*  gommettes   */

        get("/gommettes", (req, res) -> {
            return GomGUI.getAllGoms(req);
        });

        get("/gommettes/delete", (req, res) -> {
            return GomGUI.deleteGomGUI(req);
        });

        get("/gommettes/modify", (req, res) -> {
            return GomGUI.modifyGomGUI(req);
        });

        get("/gommettes/create", (req, res) -> {
            return GomGUI.createGomGUI(req);
        });

        post("/gommettes/create", (req, res) -> {
            GomEntity user= new GomEntity();
            String description = req.queryParams("description");
            String color = req.queryParams("color");
            user.setDescription(description);
            user.setColor(color);
            GomCore.addGom(user);
            res.redirect("/gommettes");
            return null;  
        });

        post("/gommettes/modify", (req, res) -> {

            String id = req.queryParams("id");
            String description = req.queryParams("description");
            String color = req.queryParams("color");
            GomCore.modifyGom(id, description, color);
            res.redirect("/gommettes");
            return null;
        });

        post("/gommettes/delete", (req, res) -> {

            GomEntity user= new GomEntity();
            String id = req.queryParams("id");
            EleveGomGUI.DeleteEleveGomWithIdGomGUI(id);
            user.setId(Integer.parseInt(id));
            GomCore.deleteGom(user);
            res.redirect("/gommettes");
            return null;
        });



        /* attribution gommettes->eleve */

        get("/elevesGom", (req, res) -> {
            return EleveGomGUI.getAllElevesGom(req);
        });

        get("/elevesGom/create", (req, res) -> {
            String idEleve=req.session().attribute("idEleve");
            String idGom=req.session().attribute("idGom");
            return EleveGomGUI.createEleveGomGUI(req, idEleve, idGom);
        }); 

        get("/elevesGom/delete", (req, res) -> {
            return EleveGomGUI.deleteEleveGomGUI();
        }); 

        get("/elevesGom/recherche", (req, res) -> {
            String idEleve=req.session().attribute("idEleve");
            return EleveGomGUI.getAllEleveGomWithIdEleveGUI(idEleve);
        }); 

        post("/elevesGom/create", (req, res) -> {
            EleveGomEntity e= new EleveGomEntity();
            e.setIdEleve(Integer.parseInt(req.queryParams("idEleve")));
            e.setIdGommette(Integer.parseInt(req.queryParams("idGom")));
            e.setIdProf(Integer.parseInt(req.cookie("CurrentUser")));
            e.setDate(req.queryParams("date"));      
            e.setMotif(req.queryParams("motif"));  
            EleveGomCore.addEleveGom(e);
            res.redirect("/elevesGom");
            return null;
        });

        post("/elevesGom/delete", (req, res) -> {
            String id = req.queryParams("id");
            EleveGomEntity user= EleveGomCore.getOneEleveGom(id);
            EleveGomCore.deleteEleveGom(user);
            res.redirect("/elevesGom");
            return null;
        });
        
        post("/elevesGom/recherche", (req, res) -> {
            String idEleve = req.queryParams("idEleve");
            Session session=req.session(true);
            req.session().attribute("idEleve", idEleve);
            res.redirect("/elevesGom/recherche");
            return null;
        });

    }
}
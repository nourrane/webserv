package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.core.*;
import com.uca.entity.*;


import spark.*;
import static spark.Spark.*;



/**
 * GET "http://localhost:8081/professeurs" #liste des profs
 * GET "http://localhost:8081/professeurs/?id=1" # affiche nom prenom prof id=1
 * POST "http://localhost:8081/professeurs?firstname=Annie&lastname=Versaire" # ajoute un prof annie versaire 
 * DELETE "http://localhost:8081/professeurs?id=2" # supprime le prof d'id=2
 * 
 * GET "http://localhost:8package com.uca;

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
            return EleveGUI.getAllElevesModify(req);
        });
        get("/eleves/delete", (req, res) -> {
            return EleveGUI.getAllElevesDelete(req);
        });
        get("/eleves/create", (req, res) -> {
            return EleveGUI.getAllElevesCreate(req);
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
            EleveGomGUI.DeleteAllEleveGomWithIdEleveGUI(id);
            user.setId(Integer.parseInt(id));
            EleveCore.deleteEleve(user);
            res.redirect("/eleves");
            return null;
        });

        /*  professeurs   */
        get("/professeurs", (req, res) -> {
            return ProfGUI.getAllProfs();
        });

        /*inscription*/

        post("/professeurs/create", (req, res) -> {
            ProfEntity user= new ProfEntity();
            String firstname = req.queryParams("firstname");
            String lastname = req.queryParams("lastname");
            String password = req.queryParams("password");
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setPassword(password);
            ProfCore.addProf(user);
            res.redirect("/professeurs/create");
            return null;
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
                Session session=req.session(true);
                req.session().attribute("id", id);
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
            return GomGUI.getAllGomDelete(req);
        });
        get("/gommettes/modify", (req, res) -> {
            return GomGUI.getAllGomModify(req);
        });
        get("/gommettes/create", (req, res) -> {
            return GomGUI.getAllGomCreate(req);
        });
        post("/gommettes/create", (req, res) -> {
            GomEntity user= new GomEntity();
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            String color = req.queryParams("color");
            user.setName(name);
            user.setDescription(description);
            user.setColor(color);
            GomCore.addGom(user);
            res.redirect("/gommettes");
            return null;
            
        });
        post("/gommettes/modify", (req, res) -> {

            String id = req.queryParams("id");
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            String color = req.queryParams("color");
            GomCore.modifyGom(id, name, description, color);
            res.redirect("/gommettes");
            return null;
        });

        post("/gommettes/delete", (req, res) -> {

            GomEntity user= new GomEntity();
            String id = req.queryParams("id");
            EleveGomGUI.DeleteAllEleveGomWithIdGomGUI(id);
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
            return EleveGomGUI.getAllElevesGomCreate(req, idEleve, idGom);
        }); 
        get("/elevesGom/delete", (req, res) -> {
            return EleveGomGUI.getOneElevesGomDelete();
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
          
        get("/elevesGom/recherche", (req, res) -> {
            String idEleve=req.session().attribute("idEleve");
            return EleveGomGUI.getAllEleveGomWithIdEleveGUI(idEleve);
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
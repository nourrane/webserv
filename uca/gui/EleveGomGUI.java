package com.uca.gui;

import com.uca.core.*;
import com.uca.entity.*;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import spark.*;

public class EleveGomGUI {
    public static String getAllElevesGom(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        } 

        input.put("eleveGom", EleveGomCore.getAllElevesGom());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("elevesGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    public static String getAllEleveGomWithIdEleveGUI(String idEleve) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input = new HashMap<>();

        input.put("eleves", EleveCore.getAllEleves());
        
        if (idEleve!=null){
            input.put("eleveChoisi", EleveCore.getOneEleve(idEleve));
            input.put("eleveGomSpe", EleveGomCore.getAllElevesGomWithIdEleve(idEleve));
        }

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("chercherEleveGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static void DeleteAllEleveGomWithIdEleveGUI(String idEleve) throws IOException, TemplateException {
        ArrayList<EleveGomEntity> input = EleveGomCore.getAllElevesGomWithIdEleve(idEleve);
        for (EleveGomEntity e : input){
            EleveGomCore.deleteEleveGom(e);
        }
    }

    public static void DeleteAllEleveGomWithIdGomGUI(String idGom) throws IOException, TemplateException {
        ArrayList<EleveGomEntity> input = EleveGomCore.getAllElevesGomWithIdGom(idGom);
        for (EleveGomEntity e : input){
            EleveGomCore.deleteEleveGom(e);
        }
    }


    public static String getAllElevesGomCreate(Request req, String idEleve, String idGom) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("eleveGom", EleveGomCore.getAllElevesGom());
        input.put("eleves", EleveCore.getAllEleves());
        input.put("goms", GomCore.getAllGoms());
        
        if (idEleve!=null && idGom!=null){
            input.put("eleveChoisi", EleveCore.getOneEleve(idEleve));
            input.put("gomChoisi", GomCore.getOneGom(idGom));
            input.put("eleveGomSpe", EleveGomCore.getAllElevesGomWithIdEleve(idEleve));
        }

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("createElevesGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static String getOneElevesGomDelete() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleveGom", EleveGomCore.getAllElevesGom());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("deleteElevesGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}


package com.uca.gui;

import com.uca.core.EleveCore;
import com.uca.entity.EleveEntity;


import com.uca.core.EleveGomCore;
import com.uca.entity.EleveGomEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("45"+idEleve);

        input.put("eleves", EleveCore.getAllEleves());
        
        if (idEleve!=null){
            System.out.println("GUI49bis");
            input.put("eleveChoisi", EleveCore.getOneEleve(idEleve));
            input.put("eleveGomSpe", EleveGomCore.getAllElevesGomWithIdEleve(idEleve));
        }

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("ChercherEleveGom.ftl");
        template.setOutputEncoding("UTF-8");
        System.out.println("GUI52");
        template.process(input, output);
        System.out.println("GUI53");
        return output.toString();
    }


    public static String getAllElevesGomCreate(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("eleveGom", EleveGomCore.getAllElevesGom());

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

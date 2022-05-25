package com.uca.gui;

import com.uca.core.EleveGomCore;
import com.uca.core.GomCore;
import com.uca.entity.GomEntity;
import com.uca.entity.EleveGomEntity;

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


public class GomGUI {

    public static String getAllGoms(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("goms", GomCore.getAllGoms());

        Writer output = new StringWriter();
        
        Template template = configuration.getTemplate("gomettes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    public static String modifyGomGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("gommettes", GomCore.getAllGoms());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("modifyGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    public static String deleteGomGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("gommettes", GomCore.getAllGoms());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("deleteGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static void DeleteEleveGomWithIdGomGUI(String idGom) throws IOException, TemplateException {
        ArrayList<EleveGomEntity> input = EleveGomCore.getAllElevesGomWithIdGom(idGom);
        for (EleveGomEntity e : input){
            EleveGomCore.deleteEleveGom(e);
        }
    }


    public static String createGomGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("gomettes", GomCore.getAllGoms());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("createGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}

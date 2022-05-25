package com.uca.gui;

import com.uca.core.EleveCore;
import com.uca.entity.EleveEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.*;

public class EleveGUI {
    
    public static String getAllEleves(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("eleves", EleveCore.getAllEleves());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    public static String modifyEleveGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("eleves", EleveCore.getAllEleves());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("modifyEleve.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static String deleteEleveGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            String idEleve=req.cookie("CurrentUser");
            input.put("id",idEleve );
        }  

        input.put("eleves", EleveCore.getAllEleves());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("deleteEleve.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String createEleveGUI(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        }  

        input.put("eleves", EleveCore.getAllEleves());

        Writer output = new StringWriter();

        Template template = configuration.getTemplate("createEleve.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
}

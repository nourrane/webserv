package com.uca.gui;


import com.uca.core.GomCore;
import com.uca.entity.GomEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

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
    
    public static String getAllGomModify(Request req) throws IOException, TemplateException {
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
    public static String getAllGomDelete(Request req) throws IOException, TemplateException {
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
    public static String getAllGomCreate(Request req) throws IOException, TemplateException {
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

package com.uca.gui;


import com.uca.core.ProfCore;
import com.uca.entity.ProfEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.*;

public class ProfGUI {
    
    public static String getAllProfs() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        /*
        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
        } 
        */

        input.put("professeurs", ProfCore.getAllProfs());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    
    
     public static String getIndex()  throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("index.ftl");
        template.setOutputEncoding("UTF-8");
        //template.process(output);
        return template.toString();
    }
    
}

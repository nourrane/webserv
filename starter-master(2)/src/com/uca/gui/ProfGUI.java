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

public class ProfGUI {
    
    public static String getAllProfs() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("professeurs", ProfCore.getAllProfs());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static ProfEntity addProf(ProfEntity obj) throws IOException, TemplateException {
        
        return ProfCore.addProf(obj);
    }
    public static void deleteProfs(ProfEntity obj) throws IOException, TemplateException {
        
        ProfCore.deleteProfs(obj);
     }
     public static ProfEntity getOneProf(String id) throws IOException, TemplateException {
        
        return ProfCore.GetOneProf(id);
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

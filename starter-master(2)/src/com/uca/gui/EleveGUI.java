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

public class EleveGUI {
    
    public static String getAllEleves() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleves", EleveCore.getAllEleves());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static EleveEntity addEleves(EleveEntity obj) throws IOException, TemplateException {
        
        return EleveCore.addEleve(obj);
    }
    public static void deleteEleves(EleveEntity obj) throws IOException, TemplateException {
        
        EleveCore.deleteEleve(obj);
     }
    
}

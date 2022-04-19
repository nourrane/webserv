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

public class EleveGomGUI {
    
    public static String getAllElevesGom() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleveGom", EleveGomCore.getAllElevesGom());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("elevesGom.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static EleveGomEntity addEleveGom(EleveGomEntity obj) throws IOException, TemplateException {
        
        return EleveGomCore.addEleveGom(obj);
    }
    public static void deleteEleveGom(EleveGomEntity obj) throws IOException, TemplateException {
        
        EleveGomCore.deleteEleveGom(obj);
     }
    
}

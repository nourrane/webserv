package com.uca.gui;

import com.uca.core.LoginCore;
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

public class LoginGUI {

    public static String getLogin(Request req, Response res)  throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("login.ftl");
        template.setOutputEncoding("UTF-8");

        Map<String, Object> input = new HashMap<>();
        if(req.cookie("CurrentUser")!=null){
            input.put("id", req.cookie("CurrentUser"));
            String s=req.cookie("CurrentUser");
            ProfEntity p = new ProfCore().getOneProf(s);
            input.put("professeurs",p);
        }     
        else if (req.cookies()!=null){
            input.put("incorrect", req.cookie("incorrect"));
        }     
        template.process(input,output);
        return output.toString();
    }

}

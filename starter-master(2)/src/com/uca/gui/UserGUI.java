package com.uca.gui;

import com.uca.core.UserCore;
import com.uca.entity.UserEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class UserGUI {

    public static String getAllUsers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("users", UserCore.getAllUsers());

        Writer output = new StringWriter();
       Template template = configuration.getTemplate("users/users.ftl");
       //Template template = configuration.getTemplate("goms/goms.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
    public static UserEntity addUsers(UserEntity obj) throws IOException, TemplateException {
        
        return UserCore.addUsers(obj);
    }
    public static void deleteUsers(UserEntity obj) throws IOException, TemplateException {
        
       UserCore.deleteUsers(obj);
    }
    
}

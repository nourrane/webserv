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

public class LoginGUI {
    
    public static String getConnectedProf()  throws IOException, TemplateException {
        LoginCore l=new LoginCore();
        ProfEntity p=l.getConnectedProf();
        return p.getId()+ " "+p.getFirstName()+ " "+ p.getLastName();

    }
    public static void setConnectedProf(String id)  throws IOException, TemplateException {
        LoginCore.setConnectedProf(id);
    }
    
}

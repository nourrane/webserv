package com.uca.core;
import com.uca.core.ProfCore;

import com.uca.dao.LoginDAO;
import com.uca.dao.ProfDAO;
import com.uca.entity.ProfEntity;

import java.util.ArrayList;

public class LoginCore {

    public static boolean authentification(String id, String password) {
        if (new ProfDAO().IsInTable(id)){
            ProfEntity p=new ProfCore().getOneProf(id);
            if (p!=null){
                if (p.getPassword().equals(password)){
                    return true;
                }
            }
        }  
        return false;
    }

    public static ProfEntity getConnectedProf() {
        return new LoginDAO().getConnectedProf();
    }

    public static void setConnectedProf(String id) {
        new LoginDAO().setConnectedProf(id);
    }

}


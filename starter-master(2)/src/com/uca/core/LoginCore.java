package com.uca.core;

import com.uca.dao.LoginDAO;
import com.uca.dao.ProfDAO;
import com.uca.entity.ProfEntity;

import java.util.ArrayList;

public class LoginCore {

    public static ProfEntity getConnectedProf() {
        return new LoginDAO().getConnectedProf();
    }

    public static void setConnectedProf(String id) {
        new LoginDAO().setConnectedProf(id);
    }

}

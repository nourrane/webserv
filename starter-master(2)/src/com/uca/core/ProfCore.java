package com.uca.core;

import com.uca.dao.ProfDAO;
import com.uca.entity.ProfEntity;

import java.util.ArrayList;

public class ProfCore {

    public static ArrayList<ProfEntity> getAllProfs() {
        return new ProfDAO().getAllProfs();
    }

    public static ProfEntity addProf(ProfEntity obj) {
        ProfDAO u=new ProfDAO();
        ProfEntity e=u.create(obj);
        return e ;
    }
    public static void deleteProfs(ProfEntity obj) {
        ProfDAO u=new ProfDAO();
        u.delete(obj);
    }
    public static ProfEntity GetOneProf(String id) {
        ProfDAO u=new ProfDAO();
        return u.getOneProf(id);
    }

}

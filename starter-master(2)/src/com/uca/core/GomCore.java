package com.uca.core;

import com.uca.dao.GomDAO;
import com.uca.entity.GomEntity;

import java.util.ArrayList;

public class GomCore {

    public static ArrayList<GomEntity> getAllGoms() {
        //System.out.println(new GomDAO().getAllGoms().get(0).getColor());
        return new GomDAO().getAllGoms();
    }

    public static GomEntity addGom(GomEntity obj) {
        GomDAO u=new GomDAO();
        GomEntity e=u.create(obj);
        return e ;
    }
    public static void deleteGom(GomEntity obj) {
        GomDAO u=new GomDAO();
        u.delete(obj);
    }

}

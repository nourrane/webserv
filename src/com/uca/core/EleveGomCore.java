package com.uca.core;


import com.uca.dao.EleveGomDAO;
import com.uca.entity.EleveGomEntity;

import java.util.ArrayList;

public class EleveGomCore {

    public static ArrayList<EleveGomEntity> getAllElevesGom() {
        return new EleveGomDAO().getAllElevesGom();
    }
    
    public static EleveGomEntity addEleveGom(EleveGomEntity obj) {
        EleveGomDAO u=new EleveGomDAO();
        EleveGomEntity e=u.create(obj);
        return e ;
    }
    
    public static void deleteEleveGom(EleveGomEntity obj) {
        EleveGomDAO u=new EleveGomDAO();
        u.delete(obj);
    }

     public static EleveGomEntity getOneEleveGom(String id) {
        EleveGomDAO u=new EleveGomDAO();
        return u.getOneEleveGom(id);
    }
    
    public static ArrayList<EleveGomEntity> getAllElevesGomWithIdEleve(String idEleve) {
        return new EleveGomDAO().getAllEleveGomWithIdEleve(idEleve);
    }

    public static ArrayList<EleveGomEntity> getAllElevesGomWithIdGom(String idGom) {
        return new EleveGomDAO().getAllEleveGomWithIdGom(idGom);
    }
}

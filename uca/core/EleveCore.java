
package com.uca.core;

import com.uca.dao.EleveDAO;
import com.uca.entity.EleveEntity;

import java.util.ArrayList;

public class EleveCore {

    public static ArrayList<EleveEntity> getAllEleves() {
        return new EleveDAO().getAllEleves();
    }

    public static EleveEntity addEleve(EleveEntity obj) {
        EleveDAO u=new EleveDAO();
        EleveEntity e=u.create(obj);
        return e ;
    }
    public static void deleteEleve(EleveEntity obj) {
        EleveDAO u=new EleveDAO();
        u.delete(obj);
    }
    public static EleveEntity modifyEleve(String id, String f, String l) {
        EleveDAO u=new EleveDAO();
        return u.modify(id, f, l);
    }

    public static EleveEntity getOneEleve(String id) {
        EleveDAO u=new EleveDAO();
        return u.getOneEleve(id);
    }

}

package com.uca.entity;
import com.uca.core.EleveCore;
import com.uca.entity.EleveEntity;
import com.uca.core.GomCore;
import java.sql.Timestamp;

import com.uca.core.EleveCore;

public class EleveGomEntity {
    private int id;
    private int idEleve;
    private int idGom;
    private EleveEntity Eleve;
    private String eleveFirstName;
    private GomEntity Gommette;

    public EleveGomEntity() {
        //Ignored !
    }

    public int getId() {
        return id;
    }

    public String getEleveFirstName() {
        return eleveFirstName;
    }
    public void setId(int id) {
        this.id = id;
        
    }

    public EleveEntity getEleve() {
        return Eleve;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.Eleve=new EleveCore().GetOneEleve(""+idEleve);
        System.out.println(this.Eleve.getFirstName());
        this.eleveFirstName=this.Eleve.getFirstName();
        this.idEleve=idEleve;
    }

    public GomEntity getGommette() {
        return Gommette;
    }
    public int getIdGom() {
        return idGom;
    }
    public String getGomName() {
        return this.Gommette.getName();
    }

    public String getGomDescription() {
        return this.Gommette.getDescription();
    }
    public String getGomColor() {
        return this.Gommette.getColor();
    }

    public void setIdGommette(int idg) {
        this.Gommette=new GomCore().GetOneGom(""+idg);
        this.idGom=idg;
    }
}

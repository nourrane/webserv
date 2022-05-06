
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
    private String date;
    private String motif;
    private EleveEntity Eleve;
    private GomEntity Gommette;
    

    public EleveGomEntity() {
        //Ignored !
    }

    public int getId() {
        return id;
    }
    public String getColor(){
        return Gommette.getColor();
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
    public String getFirstNameEleve(){
        return Eleve.getFirstName();
    }

    public String getLastNameEleve(){
        return Eleve.getLastName();
    }

    public void setIdEleve(int idEleve) {
        this.Eleve=new EleveCore().getOneEleve(""+idEleve);
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
        this.Gommette=new GomCore().getOneGom(""+idg);
        this.idGom=idg;
    }

    public void setDate(String d) {
        this.date = d;
        
    }

    public String getDate() {
        return this.date;
    }

    public void setMotif(String m) {
        this.motif = m;
        
    }

    public String getMotif() {
        return this.motif;
    }
}

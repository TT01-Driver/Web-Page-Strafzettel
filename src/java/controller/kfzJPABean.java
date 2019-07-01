/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Kfz;
import utilities.Data;

/**
 *
 * @author lb38
 */
@Named(value = "kfzJPABean")
@RequestScoped
public class kfzJPABean {
    private List<Kfz> kfzListe;
    private List<Kfz> fahrzeugListe;
    
    @Inject
    private Data dbBean;

    public kfzJPABean() {
        this.kfzListe = new ArrayList<>();
        this.fahrzeugListe = new ArrayList<>();
    }
    
    @PostConstruct
    private void init(){
        this.kfzListe = dbBean.dbGetKfzList();
        this.fahrzeugListe = dbBean.dbGetFahrzeugList();
    }

    public List<Kfz> getFahrzeugListe() {
        return fahrzeugListe;
    }

    public void setFahrzeugListe(List<Kfz> fahrzeugListe) {
        this.fahrzeugListe = fahrzeugListe;
    }

    
    
    public List<Kfz> getKfzListe() {
        return kfzListe;
    }

    public void setKfzListe(List<Kfz> kfzListe) {
        this.kfzListe = kfzListe;
    }
    
    
    
}

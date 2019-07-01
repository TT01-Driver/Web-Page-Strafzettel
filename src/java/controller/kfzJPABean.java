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
import model.Strafzettel;
import utilities.Data;

/**
 *
 * @author lb38
 */
@Named(value = "kfzJPABean")
@RequestScoped
public class kfzJPABean {
    private List<Kfz> kfzListe;
    private List<Strafzettel> strafzettelListe;
    private List<Strafverfolgung> strafverfolgungsListe;
    
    @Inject
    private Data dbBean;

    public kfzJPABean() {
        this.kfzListe = new ArrayList<>();
        this.strafzettelListe = new ArrayList<>();
        this.strafverfolgungsListe = new ArrayList<>();
    }
    
    @PostConstruct
    private void init(){
        this.kfzListe = dbBean.dbGetKfzList();
        this.strafzettelListe = dbBean.dbGetStrafzettelList();
    }

    public List<Strafverfolgung> getStrafverfolgungsListe() {
        return strafverfolgungsListe;
    }
    public void setStrafverfolgungsListe(List<Strafverfolgung> strafverfolgungsListe) {
        this.strafverfolgungsListe = strafverfolgungsListe;
    }

    public List<Strafzettel> getStrafzettelListe() {
        return strafzettelListe;
    }
    public void setStrafzettelListe(List<Kfz> fahrzeugListe) {
        this.strafzettelListe = strafzettelListe;
    }
    
    public List<Kfz> getKfzListe() {
        return kfzListe;
    }
    public void setKfzListe(List<Kfz> kfzListe) {
        this.kfzListe = kfzListe;
    }
    
    
    
}

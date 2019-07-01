/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Anschrift;
import model.Fahrzeughalter;
import model.Kfz;
import model.Strafzettel;
import utilities.Data;

/**
 *
 * @author lb38
 */

@Named(value = "strafverfolgung")
@RequestScoped
public class Strafverfolgung {
    // Fahrzeughalter
    private Integer fahrzeughalterFID;
    private String fahrzeughalterVorname;
    private String fahrzeughalterNachname;
    private Date fahrzeughalterGeburtsdatum;
    // Kfz
    private Integer kfzKID;
    private Fahrzeughalter kfzFK_FID;
    private String kfzFarbe;
    private String kfzKennzeichen;
    private String kfzMarke;
    // Strafzettel
    private Integer strafzettelSID;
    private Anschrift strafzettelFK_AID;
    private Date strafzettelDatum;
    private Date strafzettelUhrzeit;
    private String strafzettelKennzeichen;
    private String strafzettelMarke;
    private String strafzettelFarbe;
    
    private List<Kfz> kfzListe;
    private List<Strafzettel> strafzettelListe;
    private List<Fahrzeughalter> fahrzeughalterListe;
    private List<Strafverfolgung> strafverfolgungsListe;
    
    @Inject
    private Data dbBean;

    public Strafverfolgung() {
    }
    public Strafverfolgung(Integer fahrzeughalterFID, String fahrzeughalterVorname, String fahrzeughalterNachname, Date fahrzeughalterGeburtsdatum, Integer kfzKID, Fahrzeughalter kfzFK_FID, String KfzFarbe, String kfzKennzeichen, String kfzMarke, Integer strafzettelSID, Anschrift strafzettelFK_AID, Date strafzettelDatum, Date strafzettelUhrzeit, String strafzettelKennzeichen, String strafzettelMarke, String strafzettelFarbe, List<Kfz> kfzListe, List<Strafzettel> strafzettelListe, List<Strafverfolgung> strafverfolgungsListe, Data dbBean) {
        this.fahrzeughalterFID = fahrzeughalterFID;
        this.fahrzeughalterVorname = fahrzeughalterVorname;
        this.fahrzeughalterNachname = fahrzeughalterNachname;
        this.fahrzeughalterGeburtsdatum = fahrzeughalterGeburtsdatum;
        this.kfzKID = kfzKID;
        this.kfzFK_FID = kfzFK_FID;
        this.kfzFarbe = kfzFarbe;
        this.kfzKennzeichen = kfzKennzeichen;
        this.kfzMarke = kfzMarke;
        this.strafzettelSID = strafzettelSID;
        this.strafzettelFK_AID = strafzettelFK_AID;
        this.strafzettelDatum = strafzettelDatum;
        this.strafzettelUhrzeit = strafzettelUhrzeit;
        this.strafzettelKennzeichen = strafzettelKennzeichen;
        this.strafzettelMarke = strafzettelMarke;
        this.strafzettelFarbe = strafzettelFarbe;
        this.kfzListe = kfzListe;
        this.strafzettelListe = strafzettelListe;
        this.strafverfolgungsListe = strafverfolgungsListe;
        this.dbBean = dbBean;
    }

    @PostConstruct
    private void init(){
        // Erzeuge Objekte
        Strafzettel strafzettel = new Strafzettel();
        Kfz kfz = new Kfz();
        Fahrzeughalter fahrzeughalter = new Fahrzeughalter();
        
        // Fülle Objekte mit Daten aus der Datenbank
        this.kfzListe = dbBean.dbGetKfzList();
        this.strafzettelListe = dbBean.dbGetStrafzettelList();
        this.fahrzeughalterListe = dbBean.dBGetFahrzeughalterList();
        
        // Verweise die Daten aus den verschiedenen Listen in die internen Variablen
        this.kfzKID = kfz.getKid();
        this.kfzFK_FID = kfz.getFkFid();
        this.kfzFarbe = kfz.getFarbe();
        this.kfzKennzeichen = kfz.getKennzeichen();
        this.kfzMarke = kfz.getMarke();
        this.strafzettelSID = strafzettel.getSid();
        this.strafzettelFK_AID = strafzettel.getFkAid();
        this.strafzettelDatum = strafzettel.getDatum();
        this.strafzettelUhrzeit = strafzettel.getUhrzeit();
        this.strafzettelKennzeichen = strafzettel.getKennzeichen();
        this.strafzettelMarke = strafzettel.getMarke();
        this.strafzettelFarbe = strafzettel.getFarbe();
        this.fahrzeughalterFID = fahrzeughalter.getFid();
        this.fahrzeughalterVorname = fahrzeughalter.getVorname();
        this.fahrzeughalterNachname = fahrzeughalter.getNachname();
        this.fahrzeughalterGeburtsdatum = fahrzeughalter.getGeburtsdatum();
        
    }
    
    public Integer getFahrzeughalterFID() {
        return fahrzeughalterFID;
    }
    public void setFahrzeughalterFID(Integer fahrzeughalterFID) {
        this.fahrzeughalterFID = fahrzeughalterFID;
    }

    public String getFahrzeughalterVorname() {
        return fahrzeughalterVorname;
    }
    public void setFahrzeughalterVorname(String fahrzeughalterVorname) {
        this.fahrzeughalterVorname = fahrzeughalterVorname;
    }

    public String getFahrzeughalterNachname() {
        return fahrzeughalterNachname;
    }
    public void setFahrzeughalterNachname(String fahrzeughalterNachname) {
        this.fahrzeughalterNachname = fahrzeughalterNachname;
    }

    public Date getFahrzeughalterGeburtsdatum() {
        return fahrzeughalterGeburtsdatum;
    }
    public void setFahrzeughalterGeburtsdatum(Date fahrzeughalterGeburtsdatum) {
        this.fahrzeughalterGeburtsdatum = fahrzeughalterGeburtsdatum;
    }

    public Integer getKfzKID() {
        return kfzKID;
    }
    public void setKfzKID(Integer kfzKID) {
        this.kfzKID = kfzKID;
    }

    public Fahrzeughalter getKfzFK_FID() {
        return kfzFK_FID;
    }
    public void setKfzFK_FID(Fahrzeughalter kfzFK_FID) {
        this.kfzFK_FID = kfzFK_FID;
    }

    public String getKfzFarbe() {
        return kfzFarbe;
    }
    public void setKfzFarbe(String KfzFarbe) {
        this.kfzFarbe = kfzFarbe;
    }

    public String getKfzKennzeichen() {
        return kfzKennzeichen;
    }
    public void setKfzKennzeichen(String kfzKennzeichen) {
        this.kfzKennzeichen = kfzKennzeichen;
    }

    public String getKfzMarke() {
        return kfzMarke;
    }
    public void setKfzMarke(String kfzMarke) {
        this.kfzMarke = kfzMarke;
    }

    public Integer getStrafzettelSID() {
        return strafzettelSID;
    }
    public void setStrafzettelSID(Integer strafzettelSID) {
        this.strafzettelSID = strafzettelSID;
    }

    public Anschrift getStrafzettelFK_AID() {
        return strafzettelFK_AID;
    }
    public void setStrafzettelFK_AID(Anschrift strafzettelFK_AID) {
        this.strafzettelFK_AID = strafzettelFK_AID;
    }

    public Date getStrafzettelDatum() {
        return strafzettelDatum;
    }
    public void setStrafzettelDatum(Date strafzettelDatum) {
        this.strafzettelDatum = strafzettelDatum;
    }

    public Date getStrafzettelUhrzeit() {
        return strafzettelUhrzeit;
    }
    public void setStrafzettelUhrzeit(Date strafzettelUhrzeit) {
        this.strafzettelUhrzeit = strafzettelUhrzeit;
    }

    public String getStrafzettelKennzeichen() {
        return strafzettelKennzeichen;
    }
    public void setStrafzettelKennzeichen(String strafzettelKennzeichen) {
        this.strafzettelKennzeichen = strafzettelKennzeichen;
    }

    public String getStrafzettelMarke() {
        return strafzettelMarke;
    }
    public void setStrafzettelMarke(String strafzettelMarke) {
        this.strafzettelMarke = strafzettelMarke;
    }

    public String getStrafzettelFarbe() {
        return strafzettelFarbe;
    }
    public void setStrafzettelFarbe(String strafzettelFarbe) {
        this.strafzettelFarbe = strafzettelFarbe;
    }

    public List<Kfz> getKfzListe() {
        return kfzListe;
    }
    public void setKfzListe(List<Kfz> kfzListe) {
        this.kfzListe = kfzListe;
    }

    public List<Strafzettel> getStrafzettelListe() {
        return strafzettelListe;
    }
    public void setStrafzettelListe(List<Strafzettel> strafzettelListe) {
        this.strafzettelListe = strafzettelListe;
    }

    public List<Strafverfolgung> getStrafverfolgungsListe() {
        return strafverfolgungsListe;
    }
    public void setStrafverfolgungsListe(List<Strafverfolgung> strafverfolgungsListe) {
        this.strafverfolgungsListe = strafverfolgungsListe;
    }

    public Data getDbBean() {
        return dbBean;
    }
    public void setDbBean(Data dbBean) {
        this.dbBean = dbBean;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lb38
 */

@Entity
@Table(name="anschrift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="anschrift.findAll", query="SELECT a FROM Anschrift a"),
    @NamedQuery(name="anschrift.findByAID", query="SELECT a FROM Anschrift a WHERE a.aid = :aid"),
    @NamedQuery(name="anschrift.fingByOrt", query="SELECT a FROM Anschrift a WHERE a.ort = :ort"),
    @NamedQuery(name="anschrift.findByPLZ", query="SELECT a FROM Anschrift a WHERE a.plz = :plz"),
    @NamedQuery(name="anschrift.findByStrasse", query="SELECT a FROM Anschrift a WHERE a.strasse = :strasse")})

public class Anschrift implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    // Variablen innerhalb dieser Tabelle
    @Basic(optional = false)
    @Column(name="AID")
    private Integer aid;
    @Basic(optional = false)
    @Size(min = 1, max = 25)
    @Column(name="Hausnummer")
    private String hausnummer;
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name="Ort")
    private String ort;
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name="PLZ")
    private Integer plz;
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name="Strasse")
    private String strasse;
    
    //Zugriff auf andere Tabellen
    /*
        Entfällt hier, da keine FK in dieser Tabelle vorhanden sind
    */
    
    // Zugriff von anderen Tabellen auf diese
    @OneToMany(cascade = CascadeType.ALL, mappedBy="anschriftFKID")
    private Collection<Adresse> adresseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="strafzettelFKID")
    private Collection<Strafzettel> strafzettelCollection;

    // Konstruktor
    public Anschrift() {
    }
    public Anschrift(Integer aid) {
        this.aid = aid;
    }
    public Anschrift(Integer aid, String hausnummer, String ort, Integer plz, String strasse, Collection<Adresse> adresseCollection, Collection<Strafzettel> strafzettelCollection) {
        this.aid = aid;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.plz = plz;
        this.strasse = strasse;
        this.adresseCollection = adresseCollection;
        this.strafzettelCollection = strafzettelCollection;
    }
    
    // Setter und Getter
    public Integer getAid() {
        return aid;
    }
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getHausnummer() {
        return hausnummer;
    }
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Integer getPlz() {
        return plz;
    }
    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }
    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @XmlTransient
    public Collection<Strafzettel> getStrafzettelCollection() {
        return strafzettelCollection;
    }
    public void setStrafzettelCollection(Collection<Strafzettel> strafzettelCollection) {
        this.strafzettelCollection = strafzettelCollection;
    }
    
    // Memberfunktionen
    
}

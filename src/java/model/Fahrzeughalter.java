/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name="fahrzeughalter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="fahrzeughalter.findAll", query="SELECT f FROM Fahrzeughalter f"),
    @NamedQuery(name="fahrzeughalter.findByFID", query="SELECT f FROM Fahrzeughalter f WHERE f.fid = :fid"),
    @NamedQuery(name="fahrzeughalter.findByNachname", query="SELECT f FROM Fahrzeughalter f WHERE f.nachname = :nachname"),
    @NamedQuery(name="fahrzeughalter.findByVorname", query="SELECT f FROM Fahrzeughalter f WHERE f.vorname = :vorname"),
    @NamedQuery(name="fahrzeughalter.findByGeburtsdatum", query="SELECT f FROM Fahrzeughalter f WHERE f.geburtsdatum = :geburtsdatum")})

public class Fahrzeughalter implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // Interne Variablen
    @Basic(optional = false)
    @Column(name="FID")
    private Integer fid;
    @Basic(optional = false)
    @Size(min=1, max=24)
    @Column(name="Nachname")
    private String nachname;
    @Basic(optional = false)
    @Size(min=1, max=24)
    @Column(name="Vorname")
    private String vorname;
    @Basic(optional = false)
    @Column(name="Geburtsdatum")
    private Date geburtsdatum;
    
    // Verweis auf andere Tabellen
    /*
        entfällt hier, da keine FK in dieser Tabelle sind
    */
    
    // Verweis auf diese Tabelle
    @OneToMany(cascade = CascadeType.ALL, mappedBy="fahrzeughalterFKID")
    private Collection<Adresse> adresseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="fahrzeughalterFKID")
    private Collection<Kfz> kfzCollection;
    
    // Konstruktor
    public Fahrzeughalter() {
    }
    public Fahrzeughalter(Integer fid) {
        this.fid = fid;
    }
    public Fahrzeughalter(Integer fid, String nachname, String vorname, Date geburtsdatum, Collection<Adresse> adresseCollection, Collection<Kfz> kfzCollection) {
        this.fid = fid;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.adresseCollection = adresseCollection;
        this.kfzCollection = kfzCollection;
    }
    
    // Setter un Getter
    public Integer getFid() {
        return fid;
    }
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }
    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @XmlTransient
    public Collection<Kfz> getKfzCollection() {
        return kfzCollection;
    }
    public void setKfzCollection(Collection<Kfz> kfzCollection) {
        this.kfzCollection = kfzCollection;
    }
    
    // Memberfunktionen
    
    
}

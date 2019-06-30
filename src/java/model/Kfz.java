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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="kfz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="kfz.findAll", query="SELECT k FROM Kfz k"),
    @NamedQuery(name="kfz.findByKID", query="SELECT k FROM Kfz WHERE k.KID = :kid"),
    @NamedQuery(name="kfz.findByKennzeichen", query="SELECT k FROM Kfz k WHERE k.kennzeichen = :kennzeichen"),
    @NamedQuery(name="kfz.findByFarbe", query="SELECT k FROM Kfz k WHERE k.farbe = :farbe"),
    @NamedQuery(name="kfz.findByMarke", query="SELECT k FROM Kfz WHERE k.marke = :marke")})

public class Kfz implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // Internen Variablen
    @Basic(optional = false)
    @Column(name="KID")
    private Integer kid;
    @Basic(optional = false)
    @Column(name="Farbe")
    private String farbe;
    @Basic(optional = false)
    @Size(min=1, max=24)
    @Column(name="Kennzeichen")
    private String kennzeichen;
    @Basic(optional = false)
    @Size(min=1, max=24)
    @Column(name="Marke")
    private String marke;
    
    // Verweise auf andere Tabellen
    @JoinColumn(name="FK_FID", referencedColumnName="FID")
    @ManyToOne(optional = false)
    private Fahrzeughalter fahrzeughalterFKID;
    
    // Verweise auf diese Tabelle 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="kfzFKID")
    private Collection<Kfz> kfzCollection;

    // Konstruktor
    public Kfz() {
    }
    public Kfz(Integer kid) {
        this.kid = kid;
    }
    public Kfz(Integer kid, String farbe, String kennzeichen, String marke, Fahrzeughalter fahrzeughalterFKID, Collection<Kfz> kfzCollection) {
        this.kid = kid;
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.fahrzeughalterFKID = fahrzeughalterFKID;
        this.kfzCollection = kfzCollection;
    }
    
    // Setter und Getter
    public Integer getKid() {
        return kid;
    }
    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getFarbe() {
        return farbe;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }
    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getMarke() {
        return marke;
    }
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public Fahrzeughalter getFahrzeughalterFKID() {
        return fahrzeughalterFKID;
    }
    public void setFahrzeughalterFKID(Fahrzeughalter fahrzeughalterFKID) {
        this.fahrzeughalterFKID = fahrzeughalterFKID;
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

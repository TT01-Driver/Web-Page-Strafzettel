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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lb38
 */

// SQL-Abfragen
@Entity
@Table(name="adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="adresse.findAll", query="SELECT adr FROM Adresse adr"),
    @NamedQuery(name="adresse.findByAdrID", query="SELECT adr FROM Adresse adr WHERE adr.adrID = :adrID"),
    @NamedQuery(name="adresse.findByTelefon", query="SELECT adr FROM Adresse adr WHERE adr.telefon = :telefon")})

public class Adresse implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // Variablen innerhalb dieser Tabelle
    @Basic(optional = false)
    @Column(name="AdrID")
    private Integer adrID;
    @Basic(optional = false)
    @NotNull
    @Size(min=1,max=24)
    @Column(name="Telefon")
    private String telefon;
    
    // Verweis auf andere Tabellen
    @JoinColumn(name="FK_AID", referencedColumnName="AID")
    @ManyToOne(optional = false)
    private Anschrift anschriftIDFK;
    @JoinColumn(name="FK_FID", referencedColumnName="FID")
    @ManyToOne(optional = false)
    private Fahrzeughalter fahrzeughalterIDFK;
    
    //Verweis auf diese Tabelle
    /*
        Entfällt hier, da in den anderen Tabellen kein FK_adrID gibt
    */
    
    // Konstruktor  
    public Adresse() {
    }
    public Adresse(Integer adrID) {
        this.adrID = adrID;
    }
    public Adresse(Integer adrID, String telefon, Anschrift anschriftIDFK, Fahrzeughalter fahrzeughalterIDFK) {
        this.adrID = adrID;
        this.telefon = telefon;
        this.anschriftIDFK = anschriftIDFK;
        this.fahrzeughalterIDFK = fahrzeughalterIDFK;
    }

    // Setter und Getter
    public Integer getAdrID() {
        return adrID;
    }
    public void setAdrID(Integer adrID) {
        this.adrID = adrID;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Anschrift getAnschriftIDFK() {
        return anschriftIDFK;
    }
    public void setAnschriftIDFK(Anschrift anschriftIDFK) {
        this.anschriftIDFK = anschriftIDFK;
    }

    public Fahrzeughalter getFahrzeughalterIDFK() {
        return fahrzeughalterIDFK;
    }
    public void setFahrzeughalterIDFK(Fahrzeughalter fahrzeughalterIDFK) {
        this.fahrzeughalterIDFK = fahrzeughalterIDFK;
    }
    
    // Memberfunktionen
    
    
}

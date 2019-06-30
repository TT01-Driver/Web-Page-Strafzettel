/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lb38
 */
@Entity
@Table(name="strafzettel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="strafzettel.findAll", query="SELECT s FROM Strafzettel s"),
    @NamedQuery(name="strafzettel.findByID", query="SELECT s FROM Strafzettel s WHERE s.sid = :sid"),
    @NamedQuery(name="strafzettel.findByKennzeichen", query="SELECT s FROM Strafzettel s WHERE s.kennzeichen = :kennzeichen"),
    @NamedQuery(name="strafzettel.findByDatum", query="SELECT s FROM Strafzettel s WHERE s.datum = :datum"),
    @NamedQuery(name="strafzettel.fingByUhrzeit", query="SELECT s FROM Strafzettel s WHERE s.uhrzeit = :uhrzeit")})
public class Strafzettel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // Interne Variablen
    @Basic(optional = false)
    @Column(name="SID")
    private Integer sid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name="Kennzeichen")
    private String kennzeichen;
    @Basic(optional = false)
    @NotNull
    @Column(name="Datum")
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name="Uhrzeit")
    private Date uhrzeit;
    
    // Verweis auf andere Tabellen
    @JoinColumn(name="FK_AID", referencedColumnName="AID")
    @ManyToOne(optional = false)
    private Anschrift anschriftFKID;
    @JoinColumn(name="FK_KID", referencedColumnName="KID")
    @ManyToOne(optional = false)
    private Kfz kfzFKID;
    
    // Verweis von andern Tabellen auf diese
    /*
        Dies entfällt hier, da es keinen FK_SID gibt in anderen Tabellen
    */
    
    //Konstruktoren
    public Strafzettel() {
    }
    public Strafzettel(Integer sid) {
        this.sid = sid;
    }
    public Strafzettel(Integer sid, String kennzeichen, Date datum, Date uhrzeit, Anschrift anschriftFKID, Kfz kfzFKID) {
        this.sid = sid;
        this.kennzeichen = kennzeichen;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.anschriftFKID = anschriftFKID;
        this.kfzFKID = kfzFKID;
    }

    // Setter ind getter
    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }
    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getUhrzeit() {
        return uhrzeit;
    }
    public void setUhrzeit(Date uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public Anschrift getAnschriftFKID() {
        return anschriftFKID;
    }
    public void setAnschriftFKID(Anschrift anschriftFKID) {
        this.anschriftFKID = anschriftFKID;
    }

    public Kfz getKfzFKID() {
        return kfzFKID;
    }
    public void setKfzFKID(Kfz kfzFKID) {
        this.kfzFKID = kfzFKID;
    }
    
    // Memberfunktionen
    
}

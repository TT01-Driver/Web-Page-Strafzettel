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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lb38
 */
@Entity
@Table(name = "strafzettel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Strafzettel.findAll", query = "SELECT s FROM Strafzettel s")
    , @NamedQuery(name = "Strafzettel.findBySid", query = "SELECT s FROM Strafzettel s WHERE s.sid = :sid")
    , @NamedQuery(name = "Strafzettel.findByKennzeichen", query = "SELECT s FROM Strafzettel s WHERE s.kennzeichen = :kennzeichen")
    , @NamedQuery(name = "Strafzettel.findByDatum", query = "SELECT s FROM Strafzettel s WHERE s.datum = :datum")
    , @NamedQuery(name = "Strafzettel.findByUhrzeit", query = "SELECT s FROM Strafzettel s WHERE s.uhrzeit = :uhrzeit")
    , @NamedQuery(name = "Strafzettel.findByMarke", query = "SELECT s FROM Strafzettel s WHERE s.marke = :marke")
    , @NamedQuery(name = "Strafzettel.findByFarbe", query = "SELECT s FROM Strafzettel s WHERE s.farbe = :farbe")})
public class Strafzettel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SID")
    private Integer sid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Kennzeichen")
    private String kennzeichen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Uhrzeit")
    @Temporal(TemporalType.TIME)
    private Date uhrzeit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Marke")
    private String marke;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Farbe")
    private String farbe;
    @JoinColumn(name = "FK_AID", referencedColumnName = "AID")
    @ManyToOne(optional = false)
    private Anschrift fkAid;

    public Strafzettel() {
    }

    public Strafzettel(Integer sid) {
        this.sid = sid;
    }

    public Strafzettel(Integer sid, String kennzeichen, Date datum, Date uhrzeit, String marke, String farbe) {
        this.sid = sid;
        this.kennzeichen = kennzeichen;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.marke = marke;
        this.farbe = farbe;
    }

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

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public Anschrift getFkAid() {
        return fkAid;
    }

    public void setFkAid(Anschrift fkAid) {
        this.fkAid = fkAid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Strafzettel)) {
            return false;
        }
        Strafzettel other = (Strafzettel) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Strafzettel[ sid=" + sid + " ]";
    }
    
}

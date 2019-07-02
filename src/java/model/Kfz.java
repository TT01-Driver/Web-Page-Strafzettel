/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "kfz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kfz.findAll", query = "SELECT k FROM Kfz k")
    , @NamedQuery(name = "Kfz.findByKid", query = "SELECT k FROM Kfz k WHERE k.kid = :kid")
    , @NamedQuery(name = "Kfz.findByKennzeichen", query = "SELECT k FROM Kfz k WHERE k.kennzeichen = :kennzeichen")
    , @NamedQuery(name = "Kfz.findByFarbe", query = "SELECT k FROM Kfz k WHERE k.farbe = :farbe")
    , @NamedQuery(name = "Kfz.findByMarke", query = "SELECT k FROM Kfz k WHERE k.marke = :marke")})
public class Kfz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KID")
    private Integer kid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Kennzeichen")
    private String kennzeichen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Farbe")
    private String farbe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Marke")
    private String marke;
    @JoinColumn(name = "FK_PID", referencedColumnName = "PID")
    @ManyToOne(optional = false)
    private Person fkPid;

    public Kfz() {
    }

    public Kfz(Integer kid) {
        this.kid = kid;
    }

    public Kfz(Integer kid, String kennzeichen, String farbe, String marke) {
        this.kid = kid;
        this.kennzeichen = kennzeichen;
        this.farbe = farbe;
        this.marke = marke;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public Person getFkPid() {
        return fkPid;
    }

    public void setFkPid(Person fkPid) {
        this.fkPid = fkPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kfz)) {
            return false;
        }
        Kfz other = (Kfz) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Kfz[ kid=" + kid + " ]";
    }
    
}

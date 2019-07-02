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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lb38
 */
@Entity
@Table(name = "anschrift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anschrift.findAll", query = "SELECT a FROM Anschrift a")
    , @NamedQuery(name = "Anschrift.findByAid", query = "SELECT a FROM Anschrift a WHERE a.aid = :aid")
    , @NamedQuery(name = "Anschrift.findByStrasse", query = "SELECT a FROM Anschrift a WHERE a.strasse = :strasse")
    , @NamedQuery(name = "Anschrift.findByHausnummer", query = "SELECT a FROM Anschrift a WHERE a.hausnummer = :hausnummer")
    , @NamedQuery(name = "Anschrift.findByPlz", query = "SELECT a FROM Anschrift a WHERE a.plz = :plz")
    , @NamedQuery(name = "Anschrift.findByOrt", query = "SELECT a FROM Anschrift a WHERE a.ort = :ort")})
public class Anschrift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AID")
    private Integer aid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Strasse")
    private String strasse;
    @Size(max = 25)
    @Column(name = "Hausnummer")
    private String hausnummer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLZ")
    private int plz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Ort")
    private String ort;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAid")
    private Collection<Strafzettel> strafzettelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAid")
    private Collection<Adresse> adresseCollection;

    public Anschrift() {
    }

    public Anschrift(Integer aid) {
        this.aid = aid;
    }

    public Anschrift(Integer aid, String strasse, int plz, String ort) {
        this.aid = aid;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @XmlTransient
    public Collection<Strafzettel> getStrafzettelCollection() {
        return strafzettelCollection;
    }

    public void setStrafzettelCollection(Collection<Strafzettel> strafzettelCollection) {
        this.strafzettelCollection = strafzettelCollection;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }

    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anschrift)) {
            return false;
        }
        Anschrift other = (Anschrift) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Anschrift[ aid=" + aid + " ]";
    }
    
}

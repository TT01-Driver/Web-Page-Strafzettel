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
@Table(name = "adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
    , @NamedQuery(name = "Adresse.findByAdrID", query = "SELECT a FROM Adresse a WHERE a.adrID = :adrID")
    , @NamedQuery(name = "Adresse.findByTelefon", query = "SELECT a FROM Adresse a WHERE a.telefon = :telefon")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AdrID")
    private Integer adrID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Telefon")
    private String telefon;
    @JoinColumn(name = "FK_AID", referencedColumnName = "AID")
    @ManyToOne(optional = false)
    private Anschrift fkAid;
    @JoinColumn(name = "FK_FID", referencedColumnName = "FID")
    @ManyToOne(optional = false)
    private Fahrzeughalter fkFid;

    public Adresse() {
    }

    public Adresse(Integer adrID) {
        this.adrID = adrID;
    }

    public Adresse(Integer adrID, String telefon) {
        this.adrID = adrID;
        this.telefon = telefon;
    }

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

    public Anschrift getFkAid() {
        return fkAid;
    }

    public void setFkAid(Anschrift fkAid) {
        this.fkAid = fkAid;
    }

    public Fahrzeughalter getFkFid() {
        return fkFid;
    }

    public void setFkFid(Fahrzeughalter fkFid) {
        this.fkFid = fkFid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adrID != null ? adrID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.adrID == null && other.adrID != null) || (this.adrID != null && !this.adrID.equals(other.adrID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Adresse[ adrID=" + adrID + " ]";
    }
    
}

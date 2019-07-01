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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lb38
 */
@Entity
@Table(name = "fahrzeughalter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fahrzeughalter.findAll", query = "SELECT f FROM Fahrzeughalter f")
    , @NamedQuery(name = "Fahrzeughalter.findByFid", query = "SELECT f FROM Fahrzeughalter f WHERE f.fid = :fid")
    , @NamedQuery(name = "Fahrzeughalter.findByNachname", query = "SELECT f FROM Fahrzeughalter f WHERE f.nachname = :nachname")
    , @NamedQuery(name = "Fahrzeughalter.findByVorname", query = "SELECT f FROM Fahrzeughalter f WHERE f.vorname = :vorname")
    , @NamedQuery(name = "Fahrzeughalter.findByGeburtsdatum", query = "SELECT f FROM Fahrzeughalter f WHERE f.geburtsdatum = :geburtsdatum")})
public class Fahrzeughalter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FID")
    private Integer fid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nachname")
    private String nachname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Vorname")
    private String vorname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Geburtsdatum")
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFid")
    private Collection<Adresse> adresseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFid")
    private Collection<Kfz> kfzCollection;

    public Fahrzeughalter() {
    }

    public Fahrzeughalter(Integer fid) {
        this.fid = fid;
    }

    public Fahrzeughalter(Integer fid, String nachname, String vorname, Date geburtsdatum) {
        this.fid = fid;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fahrzeughalter)) {
            return false;
        }
        Fahrzeughalter other = (Fahrzeughalter) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fahrzeughalter[ fid=" + fid + " ]";
    }
    
}

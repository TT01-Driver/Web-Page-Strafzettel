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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPid", query = "SELECT p FROM Person p WHERE p.pid = :pid")
    , @NamedQuery(name = "Person.findByNachname", query = "SELECT p FROM Person p WHERE p.nachname = :nachname")
    , @NamedQuery(name = "Person.findByVorname", query = "SELECT p FROM Person p WHERE p.vorname = :vorname")
    , @NamedQuery(name = "Person.findByGeburtsdatum", query = "SELECT p FROM Person p WHERE p.geburtsdatum = :geburtsdatum")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
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
    @JoinColumn(name = "FK_AccID", referencedColumnName = "AccID")
    @ManyToOne(optional = false)
    private Accounts fKAccID;
    @JoinColumn(name = "FK_AdrID", referencedColumnName = "AdrID")
    @ManyToOne(optional = false)
    private Adresse fKAdrID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPid")
    private Collection<Kfz> kfzCollection;

    public Person() {
    }

    public Person(Integer pid) {
        this.pid = pid;
    }

    public Person(Integer pid, String nachname, String vorname, Date geburtsdatum) {
        this.pid = pid;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Accounts getFKAccID() {
        return fKAccID;
    }

    public void setFKAccID(Accounts fKAccID) {
        this.fKAccID = fKAccID;
    }

    public Adresse getFKAdrID() {
        return fKAdrID;
    }

    public void setFKAdrID(Adresse fKAdrID) {
        this.fKAdrID = fKAdrID;
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
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Person[ pid=" + pid + " ]";
    }
    
}

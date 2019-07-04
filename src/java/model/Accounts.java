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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccID", query = "SELECT a FROM Accounts a WHERE a.accID = :accID")
    , @NamedQuery(name = "Accounts.findByAccName", query = "SELECT a FROM Accounts a WHERE a.accName = :accName")
    , @NamedQuery(name = "Accounts.findByAccPW", query = "SELECT a FROM Accounts a WHERE a.accPW = :accPW")
    , @NamedQuery(name = "Accounts.findByAccNameAndAccPW", query = "SELECT a FROM Accounts a WHERE a.accName = :accName AND a.accPW = :accPW")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccID")
    private Integer accID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "AccName")
    private String accName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "AccPW")
    private String accPW;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKAccID")
    private Collection<Person> personCollection;

    public Accounts() {
    }

    public Accounts(Integer accID) {
        this.accID = accID;
    }

    public Accounts(Integer accID, String accName, String accPW) {
        this.accID = accID;
        this.accName = accName;
        this.accPW = accPW;
    }

    public Integer getAccID() {
        return accID;
    }

    public void setAccID(Integer accID) {
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPW() {
        return accPW;
    }

    public void setAccPW(String accPW) {
        this.accPW = accPW;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accID != null ? accID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accID == null && other.accID != null) || (this.accID != null && !this.accID.equals(other.accID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Accounts[ accID=" + accID + " ]";
    }
    
}

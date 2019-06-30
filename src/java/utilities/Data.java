/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import model.Kfz;

/**
 *
 * @author lb38
 */
@Named(value="Data")
@SessionScoped
public class Data implements Serializable {
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource 
    private UserTransaction ut;

    // konstruktor
    public Data() {
    }
    
    // Memberfunktionen
    public Kfz dbGetKfzByID(int ID){
        EntityManager em = emf.createEntityManager();       
        TypedQuery<Kfz> query = 
                em.createNamedQuery("kfz.findByKID", Kfz.class);
        query.setParameter("kid", ID);
        return query.getSingleResult();
    }
    
    public List<Kfz> dbGetKfzList(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Kfz> query = 
                em.createNamedQuery("kfz.findAll", Kfz.class);
        return query.getResultList();   
    }
    
    public List<Kfz> dbGetFahrzeugList(){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT k FROM Kfz k";
        
        TypedQuery<Kfz> query = em.createQuery(sql, Kfz.class);
        return query.getResultList();
    }
    
}

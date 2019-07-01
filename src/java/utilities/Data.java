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
import model.Fahrzeughalter;
import model.Kfz;
import controller.Strafverfolgung;
import model.Strafzettel;

/**
 *
 * @author lb38
 */
@Named(value="dbBean")
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
                em.createNamedQuery("Kfz.findAll", Kfz.class);
        return query.getResultList();   
    }
    
       public List<Kfz> dbGetKfzListByKennzeichen(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Kfz> query = 
                em.createNamedQuery("Kfz.findByKennzeichen", Kfz.class);
        return query.getResultList();   
    }
    
    public List<Strafzettel> dbGetStrafzettelList(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Strafzettel> query = 
                em.createNamedQuery("Strafzettel.findAll", Strafzettel.class);
        return query.getResultList();   
    }
   
    public List<Strafzettel> dbGetStrafzettelListByKennzeichen(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Strafzettel> query = 
                em.createNamedQuery("Strafzettel.findByKennzeichen", Strafzettel.class);
        return query.getResultList();   
    }

    public List<Fahrzeughalter> dBGetFahrzeughalterList() {
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Fahrzeughalter> query = 
                em.createNamedQuery("Fahrzeughalter.findAll", Fahrzeughalter.class);
        return query.getResultList();
    }
    
    public List<Strafverfolgung> dBGetStrafverfolgungList() {
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Strafverfolgung> query = 
                em.createNamedQuery("Strafverfolgung.findAll", Strafverfolgung.class);
        return query.getResultList();
    }
}
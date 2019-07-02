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
import model.Person;
import model.Kfz;
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
                em.createNamedQuery("Kfz.findByKID", Kfz.class);
        query.setParameter("kid", ID);
        return query.getSingleResult();
    }
    
    public List<Kfz> dbGetKfzList(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Kfz> query = 
                em.createNamedQuery("Kfz.findAll", Kfz.class);
        return query.getResultList();   
    }
    
       public List<Kfz> dbGetKfzListByKennzeichen(String kennzeichen){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Kfz> query = 
                em.createNamedQuery("Kfz.findByKennzeichen", Kfz.class);
        return query.setParameter("kennzeichen", kennzeichen).getResultList();
    }
    
    public List<Strafzettel> dbGetStrafzettelList(){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Strafzettel> query = 
                em.createNamedQuery("Strafzettel.findAll", Strafzettel.class);
        return query.getResultList();   
    }
   
    public List<Strafzettel> dbGetStrafzettelListByKennzeichen(String kennzeichen){
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Strafzettel> query = 
                em.createNamedQuery("Strafzettel.findByKennzeichen", Strafzettel.class);
        return query.setParameter("kennzeichen", kennzeichen).getResultList();   
    }

    public List<Person> dBGetPersonList() {
        EntityManager em = emf.createEntityManager();        
        TypedQuery<Person> query = 
                em.createNamedQuery("Person.findAll", Person.class);
        return query.getResultList();
    }
}
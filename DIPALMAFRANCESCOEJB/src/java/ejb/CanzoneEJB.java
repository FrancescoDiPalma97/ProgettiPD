/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import static ejb.Canzone.PRINTALL;
import static ejb.Canzone.PRINTBYCAT;
import static ejb.Canzone.PRINTBYID;
import static ejb.Canzone.PRINTBYVOTES;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author dipal
 */
@Stateless
@LocalBean
@Interceptors(LogInterceptor.class)
@WebService(serviceName= "CanzoneWS")//Ho scritto WebServices invece di WebService


public class CanzoneEJB implements CanzoneEJBRemote {
    @Inject
    private EntityManager em;
    
    public void addCanzone(Canzone c){
        em.persist(c);
    }
    
    public void updateCanzone(Canzone c){
        em.merge(c);
    }
    
    public void removeCanzone(Canzone c){
        em.remove(em.merge(c));
    }
    
    public Canzone printById(int id){
        TypedQuery<Canzone> query=em.createNamedQuery(PRINTBYID,Canzone.class);
        query.setParameter(1,id); //Ho inverito i parametri 
        return query.getSingleResult();
    }   

   
    public List<Canzone> printByCat(String cat){
        TypedQuery<Canzone> query=em.createNamedQuery(PRINTBYCAT,Canzone.class);
        query.setParameter(1,cat); //Ho inverito i parametri 
        return query.getResultList();
    }

    public List<Canzone> printAll(){
        TypedQuery<Canzone> query=em.createNamedQuery(PRINTALL,Canzone.class);
        return query.getResultList();
    }
    

    public List<Canzone> printByVotes(int v){
        TypedQuery<Canzone> query=em.createNamedQuery(PRINTBYVOTES,Canzone.class);
        query.setParameter(1,v); //Ho inverito i parametri 
        return query.getResultList();
    }

   
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.ComptageAeFacadeLocal;
import dz.elit.achat.entite.ComptageAe;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yacine-PC
 */
@Stateless
public class ComptageAeFacade extends AbstractFacade<ComptageAe> implements ComptageAeFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComptageAeFacade() {
        super(ComptageAe.class);
    }

//    @Override
//    public ComptageAe findAllComptageAe(){
//        Query q;
//        q = em.createNamedQuery("ComptageAe.findAll");
//        ComptageAe comptageAe =(ComptageAe) q.getSingleResult();
//        if(comptageAe == null)   
//            return null;
//        else      
//            return comptageAe;       
//    }
    @Override
    public List<ComptageAe> findAllComptageAe() {
        Query q = em.createNamedQuery("ComptageAe.findAll");
        List<ComptageAe> comptageAeList = q.getResultList();
        if (comptageAeList == null) {
            return null;
        } else {
            return comptageAeList;
        }
    }

    @Override
    public ComptageAe findComptageAeById(Object id) {
        Query q = em.createNamedQuery("ComptageAe.findById");
        q.setParameter("id", id);
        ComptageAe comptageAe = (ComptageAe) q.getSingleResult();
        if (comptageAe == null) {
            return null;
        } else {
            return comptageAe;
        }
    }

    public ComptageAe findComptageAeByPdlAeid(Integer id) {
        Query q = em.createNamedQuery("ComptageAe.findByPdlAeid");
        q.setParameter("pdlAeid", id);
        ComptageAe comptageAe = (ComptageAe) q.getSingleResult();
        if (comptageAe == null) {
            return null;
        } else {
            return comptageAe;
        }
    }
    

    @Override
    public void create(ComptageAe comptageAe) {
        em.persist(comptageAe);
    }

    // methode update :
    @Override
    public void updateComptageAe(ComptageAe comptageAe) {
        em.merge(comptageAe);
    }

    @Override
    public ComptageAe findComptageById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ComptageAe> findComptageByPdl(Integer Id)
    {
        Query q = em.createNamedQuery("ComptageAe.findComptageByPdl")
                .setParameter("id", Id);
        List<ComptageAe> l =  q.getResultList();  
        return l;
    }

    @Override
    public void Create(ComptageAe comptageAe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

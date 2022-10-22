/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.TensionFacadeLocal;
import dz.elit.achat.entite.Tension;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yasmine
 */
@Stateless
public class TensionFacade extends AbstractFacade<Tension> implements TensionFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TensionFacade() {
        super(Tension.class);
    }
    
    
    @Override
    public List<Tension> findByType(Integer type) {

        Query query = em.createNamedQuery("Tension.findByType");
      // query.setParameter("1",tensionDepart);
       // query.setParameter("2",tensionArrivee);
    query.setParameter("type", type);
    
    List<Tension> list= query.getResultList();
      return list.isEmpty() ? null : list;
    }
    
    
}

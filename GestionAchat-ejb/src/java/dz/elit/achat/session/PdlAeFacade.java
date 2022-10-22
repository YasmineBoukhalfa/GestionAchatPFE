/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.PdlAeFacadeLocal;
import dz.elit.achat.entite.PdlAe;
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
public class PdlAeFacade extends AbstractFacade<PdlAe> implements PdlAeFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PdlAeFacade() {
        super(PdlAe.class);
    }

    @Override
    public List<PdlAe> findPdlByType(String codePdl) {
        Query q = em.createNamedQuery("PdlAe.findByType")
                .setParameter("codePdl", codePdl);
        List<PdlAe> l = q.getResultList();
        return l;
    }

    @Override
    public void addPdl(PdlAe pdlAe) {
//        Query query = em.createNamedQuery("PdlAe.ajouterPdl");
//        query.setParameter(pdlAe.getIntitule(), intitule);

        em.persist(pdlAe);
        em.flush();

    }

    @Override
    public void updatPdl(PdlAe pdlAe) {

        em.merge(pdlAe);

    }

}

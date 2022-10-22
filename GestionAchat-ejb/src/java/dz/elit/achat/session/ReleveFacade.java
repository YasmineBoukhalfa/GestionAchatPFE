/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.ReleveFacadeLocal;
import dz.elit.achat.entite.Releve;
import dz.elit.achat.entite.TypeAe;
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
public class ReleveFacade extends AbstractFacade<Releve> implements ReleveFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReleveFacade() {
        super(Releve.class);
    }

    public void persist(Object object) {
        em.persist(object);
        em.flush();
    }

    @Override
    public TypeAe findTypeAeById(Integer id) {
        Query q = em.createNamedQuery("TypeAe.findById");
        q.setParameter("id", id);
        TypeAe typeAe = (TypeAe) q.getSingleResult();
        if (typeAe == null) {
            return null;
        } else {
            return typeAe;
        }
    }

    @Override
    public List<Releve> findReleveValidee() {
        Boolean valid = true;
        Query q = em.createNamedQuery("Releve.findByValidation")
                .setParameter("validation", valid);
        List<Releve> l = q.getResultList();
        return l;
    }

    @Override
    public List<Releve> findReleveNonValidee() {
        Boolean valid = false;
        Query q = em.createNamedQuery("Releve.findByValidation")
                .setParameter("validation", valid);
        List<Releve> l = q.getResultList();
        return l;
    }

    @Override
    public Releve findLastReleveValide(Long id, boolean b) {
        Query q = em.createNamedQuery("Releve.findLastRel")
                .setParameter("id", id)
                .setParameter("b", b);
        List<Releve> l = q.getResultList();
        return l.isEmpty() ? null : (l.get(0));
    }

    @Override
    public List<Releve> findReleveByComptage(Integer id) {
        Query q = em.createNamedQuery("Releve.findReleveByComptage")
                .setParameter("id", id);
        List<Releve> l = q.getResultList();
        return l;
    }

    @Override
    public Double findSomByAnneeMois(String type, Integer annee, Integer mois) {
        Query q = em.createNamedQuery("Releve.findSomByAnneeMois");
        q.setParameter("type", type);
        q.setParameter("annee", annee);
        q.setParameter("mois", mois);
        Double qte = (Double) q.getSingleResult();
        if(qte == null)   
            qte = 0.0;
        return qte;
    }

}

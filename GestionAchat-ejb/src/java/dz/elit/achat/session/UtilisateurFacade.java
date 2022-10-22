/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.UtilisateurFacadeLocal;
import dz.elit.achat.entite.Utilisateur;
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
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
    public Utilisateur find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    //chercher un utilisateur dans une liste
    @Override
    public Utilisateur findByUser(String nom,String mdp) {
        Query query = em.createNamedQuery("Utilisateur.findByUser");
        query.setParameter("nom",nom);
        query.setParameter("mdp", mdp);
//        query.setParameter("mdp", mdp);
        Utilisateur user;
        try {
            user = (Utilisateur) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("retourner list");
            return null;
        }
        return user;
    }

    @Override
    public boolean validerLogin(String nom, String mdp) {
        Query query = em.createNamedQuery("Utilisateur.validerLogin");
        query.setParameter("nom", nom);
        query.setParameter("mdp", mdp);
        return query.getResultList().size() > 0;
    }
    
    
    
//        public List<Utilisateur> findByUser(String nom,String mdp) {
//        Query query = em.createNamedQuery("Utilisateur.findByUser");
//        query.setParameter("nom",nom);
//        query.setParameter("mdp", mdp);
////        query.setParameter("mdp", mdp);
//        List<Utilisateur> user;
//        try {
//            user = query.getResultList();
//        } catch (Exception e) {
//            System.out.println("retourner list");
//            return null;
//        }
//        return user;
//    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.MotifModificationComptageAeFacadeLocal;
import dz.elit.achat.entite.MotifModificationComptageAe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class MotifModificationComptageAeFacade extends AbstractFacade<MotifModificationComptageAe> implements MotifModificationComptageAeFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotifModificationComptageAeFacade() {
        super(MotifModificationComptageAe.class);
    }

}

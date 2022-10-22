/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.MotifModificationFacadeLocal;
import dz.elit.achat.entite.MotifModification;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class MotifModificationFacade extends AbstractFacade<MotifModification> implements MotifModificationFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotifModificationFacade() {
        super(MotifModification.class);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.HistoriquePdlFacadeLocal;
import dz.elit.achat.entite.HistoriquePdl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class HistoriquePdlFacade extends AbstractFacade<HistoriquePdl> implements HistoriquePdlFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriquePdlFacade() {
        super(HistoriquePdl.class);
    }

}

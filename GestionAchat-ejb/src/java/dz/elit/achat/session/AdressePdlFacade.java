/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.AdressePdlFacadeLocal;
import dz.elit.achat.entite.AdressePdl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class AdressePdlFacade extends AbstractFacade<AdressePdl> implements AdressePdlFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdressePdlFacade() {
        super(AdressePdl.class);
    }

}

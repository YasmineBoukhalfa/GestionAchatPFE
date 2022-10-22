/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.CoordonneeGeoFacadeLocal;
import dz.elit.achat.entite.CoordonneeGeo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class CoordonneeGeoFacade extends AbstractFacade<CoordonneeGeo> implements CoordonneeGeoFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoordonneeGeoFacade() {
        super(CoordonneeGeo.class);
    }

}

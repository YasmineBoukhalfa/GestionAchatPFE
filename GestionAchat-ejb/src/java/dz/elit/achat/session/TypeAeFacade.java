/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.session;

import dz.elit.achat.service.TypeAeFacadeLocal;
import dz.elit.achat.entite.TypeAe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yasmine
 */
@Stateless
public class TypeAeFacade extends AbstractFacade<TypeAe> implements TypeAeFacadeLocal {

    @PersistenceContext(unitName = "GestionAchat-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeAeFacade() {
        super(TypeAe.class);
    }

}

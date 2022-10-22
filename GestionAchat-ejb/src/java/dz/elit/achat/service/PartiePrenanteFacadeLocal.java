/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.PartiePrenante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface PartiePrenanteFacadeLocal {

    void create(PartiePrenante partiePrenante);

    void edit(PartiePrenante partiePrenante);

    void remove(PartiePrenante partiePrenante);

    PartiePrenante find(Object id);

    List<PartiePrenante> findAll();

    List<PartiePrenante> findRange(int[] range);

    int count();

}

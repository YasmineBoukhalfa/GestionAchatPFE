/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.Nature;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface NatureFacadeLocal {

    void create(Nature nature);

    void edit(Nature nature);

    void remove(Nature nature);

    Nature find(Object id);

    List<Nature> findAll();

    List<Nature> findRange(int[] range);

    int count();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.Tension;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface TensionFacadeLocal {

    void create(Tension tension);

    void edit(Tension tension);

    void remove(Tension tension);

    Tension find(Object id);

    List<Tension> findAll();

    List<Tension> findRange(int[] range);

    int count();

   List<Tension> findByType(Integer type);

   // public List<Tension> findByType(int i);

    
    
}

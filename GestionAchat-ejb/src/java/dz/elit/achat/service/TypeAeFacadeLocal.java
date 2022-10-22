/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.TypeAe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface TypeAeFacadeLocal {

    void create(TypeAe typeAe);

    void edit(TypeAe typeAe);

    void remove(TypeAe typeAe);

    TypeAe find(Object id);

    List<TypeAe> findAll();

    List<TypeAe> findRange(int[] range);

    int count();

}

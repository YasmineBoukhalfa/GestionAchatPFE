/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.ModeDetermination;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface ModeDeterminationFacadeLocal {

    void create(ModeDetermination modeDetermination);

    void edit(ModeDetermination modeDetermination);

    void remove(ModeDetermination modeDetermination);

    ModeDetermination find(Object id);

    List<ModeDetermination> findAll();

    List<ModeDetermination> findRange(int[] range);

    int count();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.MotifModification;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface MotifModificationFacadeLocal {

    void create(MotifModification motifModification);

    void edit(MotifModification motifModification);

    void remove(MotifModification motifModification);

    MotifModification find(Object id);

    List<MotifModification> findAll();

    List<MotifModification> findRange(int[] range);

    int count();

}

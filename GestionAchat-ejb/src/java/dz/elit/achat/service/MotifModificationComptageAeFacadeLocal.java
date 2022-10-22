/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.MotifModificationComptageAe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface MotifModificationComptageAeFacadeLocal {

    void create(MotifModificationComptageAe motifModificationComptageAe);

    void edit(MotifModificationComptageAe motifModificationComptageAe);

    void remove(MotifModificationComptageAe motifModificationComptageAe);

    MotifModificationComptageAe find(Object id);

    List<MotifModificationComptageAe> findAll();

    List<MotifModificationComptageAe> findRange(int[] range);

    int count();

}

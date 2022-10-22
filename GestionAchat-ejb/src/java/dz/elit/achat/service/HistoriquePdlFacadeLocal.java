/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.HistoriquePdl;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface HistoriquePdlFacadeLocal {

    void create(HistoriquePdl historiquePdl);

    void edit(HistoriquePdl historiquePdl);

    void remove(HistoriquePdl historiquePdl);

    HistoriquePdl find(Object id);

    List<HistoriquePdl> findAll();

    List<HistoriquePdl> findRange(int[] range);

    int count();

}

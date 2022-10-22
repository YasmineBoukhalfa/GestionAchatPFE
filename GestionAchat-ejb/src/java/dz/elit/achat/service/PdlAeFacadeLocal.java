/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.Tension;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface PdlAeFacadeLocal {

    void create(PdlAe pdlAe);

    void edit(PdlAe pdlAe);

    void remove(PdlAe pdlAe);

    PdlAe find(Object id);

    List<PdlAe> findAll();

    List<PdlAe> findRange(int[] range);

    List<PdlAe> findPdlByType(String codePdl);

    int count();

    void addPdl(PdlAe pdlAe);

    public void updatPdl(PdlAe pdlAe);

    // list<PdlAe> ajoutPdl();
}

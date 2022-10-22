/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.ComptageAe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface ComptageAeFacadeLocal {

    void create(ComptageAe comptageAe);

    void edit(ComptageAe comptageAe);

    void remove(ComptageAe comptageAe);

    ComptageAe find(Object id);

    int count();

//
//    public void ajouterComptageAe(ComptageAe comptageAe);
    public void updateComptageAe(ComptageAe comptageAe);

    public ComptageAe findComptageById(Object id);

    public ComptageAe findComptageAeById(Object id);

    public List<ComptageAe> findAllComptageAe();

    public void Create(ComptageAe comptageAe);

    public List<ComptageAe> findComptageByPdl(Integer pdlAeid);

}

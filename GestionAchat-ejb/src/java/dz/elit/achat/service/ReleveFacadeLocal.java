/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.Releve;
import dz.elit.achat.entite.TypeAe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface ReleveFacadeLocal {

    void create(Releve releve);

    void edit(Releve releve);

    void remove(Releve releve);

    Releve find(Object id);

    List<Releve> findAll();

    List<Releve> findRange(int[] range);

    int count();
            
    public TypeAe findTypeAeById(Integer id);
    
    public List<Releve> findReleveValidee();
    
    public List<Releve> findReleveNonValidee();

    public Releve findLastReleveValide(Long id, boolean b);
    
    public List<Releve> findReleveByComptage(Integer id);

    public Double findSomByAnneeMois(String type, Integer annee, Integer mois);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.CoordonneeGeo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface CoordonneeGeoFacadeLocal {

    void create(CoordonneeGeo coordonneeGeo);

    void edit(CoordonneeGeo coordonneeGeo);

    void remove(CoordonneeGeo coordonneeGeo);

    CoordonneeGeo find(Object id);

    List<CoordonneeGeo> findAll();

    List<CoordonneeGeo> findRange(int[] range);

    int count();

}

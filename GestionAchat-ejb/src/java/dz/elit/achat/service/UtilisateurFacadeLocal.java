/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.service;

import dz.elit.achat.entite.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yasmine
 */
@Local
public interface UtilisateurFacadeLocal {

    public boolean validerLogin(String nom, String mdp);

    void create(Utilisateur typeAe);

    void edit(Utilisateur typeAe);

    void remove(Utilisateur typeAe);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();

//    public List<Utilisateur> findByUser(String nom,String mdp);
    public Utilisateur findByUser(String nom,String mdp);

}

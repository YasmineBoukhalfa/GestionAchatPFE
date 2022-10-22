/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.ModeDetermination;
import dz.elit.achat.service.ModeDeterminationFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "modeDeterminationController")
@ViewScoped
public class ModeDeterminationController implements Serializable {

    @EJB
    private ModeDeterminationFacadeLocal modeDeterminationFacadeLocal;

    private ModeDetermination modeDetermination;

    private String libelle;
    private String codeReleve;

    public ModeDeterminationController() {
    }

    @PostConstruct
    public void initialiserModeDetermination() {
        if (Util.getsession("session") == null) {
            try {
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {
            modeDetermination = new ModeDetermination();
            libelle = null;
            codeReleve = null;
        }
    }

    public ModeDeterminationFacadeLocal getModeDeterminationFacadeLocal() {
        return modeDeterminationFacadeLocal;
    }

    public void setModeDeterminationFacadeLocal(ModeDeterminationFacadeLocal modeDeterminationFacadeLocal) {
        this.modeDeterminationFacadeLocal = modeDeterminationFacadeLocal;
    }

    public ModeDetermination getModeDetermination() {
        return modeDetermination;
    }

    public void setModeDetermination(ModeDetermination modeDetermination) {
        this.modeDetermination = modeDetermination;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeReleve() {
        return codeReleve;
    }

    public void setCodeReleve(String codeReleve) {
        this.codeReleve = codeReleve;
    }

}

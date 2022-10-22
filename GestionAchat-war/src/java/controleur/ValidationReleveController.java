/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleurs.util.JsfUtil.getRequestParameter;
import dz.elit.achat.entite.ComptageAe;
import dz.elit.achat.entite.ModeDetermination;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.Releve;
import dz.elit.achat.entite.TypeAe;
import dz.elit.achat.service.ReleveFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ihab Boudissa
 */
@ManagedBean(name = "validationReleveController")
@ViewScoped
public class ValidationReleveController implements Serializable {

    @EJB
    private ReleveFacadeLocal releveFacadeLocal;

    private List<ModeDetermination> listModeDetermination;
    private List<Releve> listReleveValidee;
    private List<ComptageAe> listComptage;
    private List<PdlAe> listPdlAe;
    private List<TypeAe> listTypeAe;

    private ModeDetermination modeDetermination;
    private ComptageAe comptageAe;
    private Releve releve;

    private Integer indexReleve;
    private Integer mois;
    private Integer annee;
    private String description;
    private Integer comptageAeid;
    private Double quantite;
    private Integer modePhase;
    private Boolean validation;
    private Date dateHeureReleve;
    private Date dateValidation;

    //Mode Determination
    private String libelle;
    private String codeReleve;
    private Integer modeDeterminationid;

    public ValidationReleveController() {
    }

    //Appeler la liste des relèves validées
    @PostConstruct
    public void recupererListReleveValidee() {
        if (Util.getsession("session") == null) {
            try {
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {

            }
        } else {
            listReleveValidee = releveFacadeLocal.findReleveValidee();
        }

    }

    //initialisation des attributs
    public void initialiserController() {
        String id = getRequestParameter("edit");
        releve = releveFacadeLocal.find(Integer.parseInt(id));

        initialiserReleve();
    }

    public void initialiserReleve() {
        try {
            indexReleve = releve.getIndexReleve();
            description = releve.getDescription();
        } catch (Exception e) {
            System.out.println("Erreur dans l'importation des données de la relève");
        }
    }

    //getters & setters
    public List<ModeDetermination> getListModeDetermination() {
        return listModeDetermination;
    }

    public ComptageAe getComptageAe() {
        return comptageAe;
    }

    public void setComptageAe(ComptageAe comptageAe) {
        this.comptageAe = comptageAe;
    }

    public void setListModeDetermination(List<ModeDetermination> listModeDetermination) {
        this.listModeDetermination = listModeDetermination;
    }

    public ModeDetermination getModeDetermination() {
        return modeDetermination;
    }

    public void setModeDetermination(ModeDetermination modeDetermination) {
        this.modeDetermination = modeDetermination;
    }

    public Releve getReleve() {
        return releve;
    }

    public void setReleve(Releve releve) {
        this.releve = releve;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getComptageAeid() {
        return comptageAeid;
    }

    public void setComptageAeid(Integer comptageAeid) {
        this.comptageAeid = comptageAeid;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Integer getModeDeterminationid() {
        return modeDeterminationid;
    }

    public void setModeDeterminationid(Integer modeDeterminationid) {
        this.modeDeterminationid = modeDeterminationid;
    }

    public List<Releve> getListReleveValidee() {
        return listReleveValidee;
    }

    public void setListReleveValidee(List<Releve> listReleveValidee) {
        this.listReleveValidee = listReleveValidee;
    }

    public List<ComptageAe> getListComptage() {
        return listComptage;
    }

    public void setListComptage(List<ComptageAe> listComptage) {
        this.listComptage = listComptage;
    }

    public Integer getIndexReleve() {
        return indexReleve;
    }

    public void setIndexReleve(Integer indexReleve) {
        this.indexReleve = indexReleve;
    }

    public Integer getModePhase() {
        return modePhase;
    }

    public void setModePhase(Integer modePhase) {
        this.modePhase = modePhase;
    }

    public Date getDateHeureReleve() {
        return dateHeureReleve;
    }

    public void setDateHeureReleve(Date dateHeureReleve) {
        this.dateHeureReleve = dateHeureReleve;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }

    public List<TypeAe> getListTypeAe() {
        return listTypeAe;
    }

    public void setListTypeAe(List<TypeAe> listTypeAe) {
        this.listTypeAe = listTypeAe;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

}

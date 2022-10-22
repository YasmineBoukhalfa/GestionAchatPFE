/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.*;
import dz.elit.achat.entite.ComptageAe;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.service.ComptageAeFacadeLocal;
import dz.elit.achat.service.MarqueFacadeLocal;
import dz.elit.achat.service.MotifModificationComptageAeFacadeLocal;
import dz.elit.achat.service.NatureFacadeLocal;
import dz.elit.achat.service.PdlAeFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.faces.view.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Yacine-PC
 */
//@Named (value = "comptageAeController"


@ManagedBean(name = "comptageAeController")
@ViewScoped
public class ComptageAeController implements Serializable {
    
    private String intituleComptage;
    private String numSerie;
    private Integer pdlAeid;
    
    private Integer anneeFabrication;
    private Integer coeffLecture;
    private Date dateInstallation;
    private Date dateService;
    private Date datePose;
    private Boolean etatComptage;
    
    private Integer nbDigits;
    private Integer indexPose;
    private Integer indexDepose;
    private Integer modePhase;
    private Boolean remiseZero;
    


    // les attributs de la marque
    private Integer marqueid;
    private String libelleMarque;
    private String code;
    private String modeleMarque;
    private String typeMarque;

    //les attributs de releve:
    private Integer releveid;
//    private Integer annee;
//    private Date dateHeureReleve;
//    private Date dateValidation;
//    private String description;
//    private Integer indexReleve;
//    private Integer mois;
//    private Float quantite;
//    private Boolean validation;

    // les attributs de la nature:
    private Integer natureid;
    private String libelleNature;

    // les attributs de motif modification comptage ae
    private Integer motifModificationComptageAeid;
    private Integer motifModificationid;
    private Integer comptageAeid;
    private Date dateModification;

    // les attributs custom:
    @EJB
    private ComptageAeFacadeLocal comptageAeFacadeLocal;
    @EJB
    private NatureFacadeLocal natureFacadeLocal;
    @EJB
    private MarqueFacadeLocal marqueFacadeLocal;
    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;
//    @EJB
//    private ReleveFacadeLocal releveFacadeLocal;
    @EJB
    private MotifModificationComptageAeFacadeLocal mortifModificationComptageAeFacadeLocal;

    private PdlAe pdlAe;
    private List<PdlAe> listPdlAe;

    private Nature nature;
    private List<Nature> listNature;

    private Marque marque;
    private List<Marque> listMarque;

    private Releve releve;

    private ComptageAe comptageAe;

    private MotifModificationComptageAe motifModificationComptageAe;

    private Date dateDuJour;

    // les Methodes : 
    //init:
    public ComptageAeController() {
    }

    @PostConstruct
    public void initialiserController() {
        if (Util.getsession("session") == null) {
            try {
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {
            comptageAe = new ComptageAe();
            dateDuJour = new Date();

            initialiserComptageAe();
            initialiserNature();
            initialiserMotifModificationComptageAe();
            initialiserReleve();
            initiliserMarque();

//           comptageAe = comptageAeFacadeLocal.findComptageAeById(1);
//           anneeFabrication = comptageAe.getAnneeFabrication();
            listPdlAe = pdlAeFacadeLocal.findAll();
            listNature = natureFacadeLocal.findAll();
            listMarque = marqueFacadeLocal.findAll();
        }
    }

    public void initialiserComptageAe() {
        comptageAe = new ComptageAe();
        anneeFabrication = null;
        coeffLecture = null;
        dateInstallation = null;
        dateService = null;
        datePose = null;
        etatComptage = null;
        numSerie = null;
        nbDigits = null;
        indexPose = null;
        indexDepose = null;
        modePhase = null;
        remiseZero = null;
        intituleComptage = null;
    }

    public void initialiserNature() {
        nature = new Nature();
        natureid = null;
        libelleNature = null;
    }

    public void initialiserReleve() {
        releve = new Releve();
        releveid = null;
    }

    public void initiliserMarque() {
        marque = new Marque();
        marqueid = null;
        libelleMarque = null;
        code = null;
        modeleMarque = null;
        typeMarque = null;
    }

    public void initialiserMotifModificationComptageAe() {
        motifModificationComptageAe = new MotifModificationComptageAe();
        motifModificationComptageAeid = null;
        motifModificationid = null;
        comptageAeid = null;
        dateModification = null;
    }

    // Ajouter comptage :
    public void ajouterComptageAe() {
        
        comptageAe = new ComptageAe();
        comptageAe.setIntituleComptage(intituleComptage);
        comptageAe.setNumSerie(numSerie);
        comptageAe.setPdlAeid(pdlAeFacadeLocal.find(pdlAeid));
        
        comptageAe.setAnneeFabrication(anneeFabrication);
        comptageAe.setCoeffLecture(coeffLecture);
        comptageAe.setDateInstallation(dateInstallation);
        comptageAe.setDateService(dateService);
        comptageAe.setDatePose(datePose);
        comptageAe.setEtatComptage(etatComptage);
        comptageAe.setNbDigits(nbDigits);
        comptageAe.setIndexPose(indexPose);
        comptageAe.setIndexDepose(indexDepose);
        comptageAe.setModePhase(modePhase);
        comptageAe.setRemiseZero(remiseZero);
        comptageAe.setMarqueid(marqueFacadeLocal.find(marqueid));
        comptageAe.setNatureid(natureFacadeLocal.find(natureid));

        comptageAeFacadeLocal.create(comptageAe);
    }
    


    

    public PdlAeFacadeLocal getPdlAeFacadeLocal() {
        return pdlAeFacadeLocal;
    }

    public void setPdlAeFacadeLocal(PdlAeFacadeLocal pdlAeFacadeLocal) {
        this.pdlAeFacadeLocal = pdlAeFacadeLocal;
    }

    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }

    public List<Nature> getListNature() {
        return listNature;
    }

    public void setListNature(List<Nature> listNature) {
        this.listNature = listNature;
    }

    public List<Marque> getListMarque() {
        return listMarque;
    }

    // getters et setters
    public void setListMarque(List<Marque> listMarque) {
        this.listMarque = listMarque;
    }

    public Integer getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(Integer anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public Integer getCoeffLecture() {
        return coeffLecture;
    }

    public void setCoeffLecture(Integer coeffLecture) {
        this.coeffLecture = coeffLecture;
    }

    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

    public Date getDateService() {
        return dateService;
    }

    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }

    public Date getDatePose() {
        return datePose;
    }

    public void setDatePose(Date datePose) {
        this.datePose = datePose;
    }

    public Boolean getEtatComptage() {
        return etatComptage;
    }

    public void setEtatComptage(Boolean etatComptage) {
        this.etatComptage = etatComptage;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getNbDigits() {
        return nbDigits;
    }

    public void setNbDigits(Integer nbDigits) {
        this.nbDigits = nbDigits;
    }

    public Integer getIndexPose() {
        return indexPose;
    }

    public void setIndexPose(Integer indexPose) {
        this.indexPose = indexPose;
    }

    public Integer getIndexDepose() {
        return indexDepose;
    }

    public void setIndexDepose(Integer indexDepose) {
        this.indexDepose = indexDepose;
    }

    public Integer getModePhase() {
        return modePhase;
    }

    public void setModePhase(Integer modePhase) {
        this.modePhase = modePhase;
    }

    public Boolean getRemiseZero() {
        return remiseZero;
    }

    public void setRemiseZero(Boolean remiseZero) {
        this.remiseZero = remiseZero;
    }

    public String getIntituleComptage() {
        return intituleComptage;
    }

    public void setIntituleComptage(String intituleComptage) {
        this.intituleComptage = intituleComptage;
    }

    public Integer getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(Integer pdlAeid) {
        this.pdlAeid = pdlAeid;
    }

    public Integer getMarqueid() {
        return marqueid;
    }

    public void setMarqueid(Integer marqueid) {
        this.marqueid = marqueid;
    }

    public String getLibelleMarque() {
        return libelleMarque;
    }

    public void setLibelleMarque(String libelleMarque) {
        this.libelleMarque = libelleMarque;
    }

    public Integer getNatureid() {
        return natureid;
    }

    public void setNatureid(Integer natureid) {
        this.natureid = natureid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModeleMarque() {
        return modeleMarque;
    }

    public void setModeleMarque(String modeleMarque) {
        this.modeleMarque = modeleMarque;
    }

    public String getTypeMarque() {
        return typeMarque;
    }

    public void setTypeMarque(String typeMarque) {
        this.typeMarque = typeMarque;
    }

    public String getLibelleNature() {
        return libelleNature;
    }

    public void setLibelleNature(String libelleNature) {
        this.libelleNature = libelleNature;
    }

    public Integer getMotifModificationComptageAeid() {
        return motifModificationComptageAeid;
    }

    public void setMotifModificationComptageAeid(Integer motifModificationComptageAeid) {
        this.motifModificationComptageAeid = motifModificationComptageAeid;
    }

    public Integer getMotifModificationid() {
        return motifModificationid;
    }

    public void setMotifModificationid(Integer motifModificationid) {
        this.motifModificationid = motifModificationid;
    }

    public Integer getComptageAeid() {
        return comptageAeid;
    }

    public void setComptageAeid(Integer comptageAeid) {
        this.comptageAeid = comptageAeid;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public ComptageAe getComptageAe() {
        return comptageAe;
    }

    public void setComptageAe(ComptageAe comptageAe) {
        this.comptageAe = comptageAe;
    }

    public ComptageAeFacadeLocal getComptageAeFacadeLocal() {
        return comptageAeFacadeLocal;
    }

    public void setComptageAeFacadeLocal(ComptageAeFacadeLocal comptageAeFacadeLocal) {
        this.comptageAeFacadeLocal = comptageAeFacadeLocal;
    }

    public NatureFacadeLocal getNatureFacadeLocal() {
        return natureFacadeLocal;
    }

    public void setNatureFacadeLocal(NatureFacadeLocal natureFacadeLocal) {
        this.natureFacadeLocal = natureFacadeLocal;
    }

    public MarqueFacadeLocal getMarqueFacadeLocal() {
        return marqueFacadeLocal;
    }

    public void setMarqueFacadeLocal(MarqueFacadeLocal marqueFacadeLocal) {
        this.marqueFacadeLocal = marqueFacadeLocal;
    }
//
//    public ReleveFacadeLocal getReleveFacadeLocal() {
//        return releveFacadeLocal;
//    }
//
//    public void setReleveFacadeLocal(ReleveFacadeLocal releveFacadeLocal) {
//        this.releveFacadeLocal = releveFacadeLocal;
//    }
//

    public MotifModificationComptageAeFacadeLocal getMortifModificationComptageAeFacadeLocal() {
        return mortifModificationComptageAeFacadeLocal;
    }

    public void setMortifModificationComptageAeFacadeLocal(MotifModificationComptageAeFacadeLocal mortifModificationComptageAeFacadeLocal) {
        this.mortifModificationComptageAeFacadeLocal = mortifModificationComptageAeFacadeLocal;
    }

    public PdlAe getPdlAe() {
        return pdlAe;
    }

    public void setPdlAe(PdlAe pdlAe) {
        this.pdlAe = pdlAe;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Integer getReleveid() {
        return releveid;
    }

    public void setReleveid(Integer releveid) {
        this.releveid = releveid;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Releve getReleve() {
        return releve;
    }

    public void setReleve(Releve releve) {
        this.releve = releve;
    }

    public MotifModificationComptageAe getMotifModificationComptageAe() {
        return motifModificationComptageAe;
    }

    public void setMotifModificationComptageAe(MotifModificationComptageAe motifModificationComptageAe) {
        this.motifModificationComptageAe = motifModificationComptageAe;
    }

    public Date getDateDuJour() {
        return dateDuJour;
    }

    public void setDateDuJour(Date dateDuJour) {
        this.dateDuJour = dateDuJour;
    }

}

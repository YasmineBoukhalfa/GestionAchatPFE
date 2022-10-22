/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.ModeDetermination;
import dz.elit.achat.entite.Releve;
import dz.elit.achat.entite.ComptageAe;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.TypeAe;
import dz.elit.achat.service.ComptageAeFacadeLocal;
import dz.elit.achat.service.ReleveFacadeLocal;
import dz.elit.achat.service.ModeDeterminationFacadeLocal;
import dz.elit.achat.service.PdlAeFacadeLocal;
import dz.elit.achat.service.TypeAeFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "releveController")
@ViewScoped
public class ReleveController implements Serializable {

    @EJB
    private ReleveFacadeLocal releveFacadeLocal;

    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;

    @EJB
    private ModeDeterminationFacadeLocal modeDeterminationFacadeLocal;

    @EJB
    private ComptageAeFacadeLocal comptageAeFacadeLocal;

    @EJB
    private TypeAeFacadeLocal typeAeFacadeLocal;

    //Les listes
    private List<ModeDetermination> listModeDetermination;
    private List<PdlAe> listPdlAe;
    private List<PdlAe> listPdlByType;
    private List<TypeAe> listTypePdl;
    private List<ComptageAe> listCpt;

    //Attributs Relève
    private String codeReleve;
    private Integer annee;
    private Date dateHeureReleve;
    private Date dateValidation;
    private String description;
    private Integer indexReleve;
    private Integer ancienIndex;
    private Integer mois;
    private Double quantite;
    private Double qteEstime;
    private Boolean validation;

    //Attributs Comptage
    private Integer comptageid;
    private Integer modePhase;
    private Integer coeffLecture;
    private Integer anneeFabrication;
    private Date dateInstallation;
    private Date dateService;
    private Date datePose;
    private Boolean etatComptage;
    private String numSerie;
    private Integer nbDigits;
    private Integer indexPose;
    private Integer indexDepose;
    private Boolean remiseZero;
    private String intituleComptage;

    //PDL
    private Integer pdlAeid;
    private Integer typeAeid;
    private String codePdl;

    //Attribut Mode Determination
    private Integer modeDeterminationid;
    private String libelle;

    //Les objets
    private Releve releve;
    private ComptageAe comptageAe;
    private Integer comptageAeid;
    private PdlAe pdlAe;
    private ModeDetermination modeDetermination;
    private TypeAe typeAe;

    private Date dateDuJour = new Date();
    private Boolean render;

    //no-args constructeur
    public ReleveController() {
    }

    //initialisation des champs
    @PostConstruct
    public void initialiserController() {
        if (UtilisateurController.getsession("session") == null) {
            try {
                UtilisateurController.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {

            }
        } else {
            initialiserTypeAe();
            initialiserPdlAe();
            initialiserReleve();
            initialiserComptageAe();

            listTypePdl = typeAeFacadeLocal.findAll();
            listModeDetermination = modeDeterminationFacadeLocal.findAll();
        }

    }

    public void initialiserReleve() {
        releve = new Releve();
        annee = null;
        dateHeureReleve = null;
        dateValidation = null;
        description = null;
        indexReleve = null;
        ancienIndex = null;
        mois = null;
        quantite = null;
        codePdl = null;
    }

    public void initialiserComptageAe() {
        comptageAe = new ComptageAe();
        comptageid = null;
    }

    public void initialiserPdlAe() {
        pdlAe = new PdlAe();
        pdlAeid = null;
    }

    public void initialiserTypeAe() {
        typeAe = new TypeAe();
        codePdl = null;

        typeAeid = null;
    }

    //getters & setters des attributs
    public Integer getModeDeterminationid() {
        return modeDeterminationid;
    }

    public void setModeDeterminationid(Integer modeDeterminationid) {
        this.modeDeterminationid = modeDeterminationid;
    }

    public Double getQteEstime() {
        return qteEstime;
    }

    public void setQteEstime(Double qteEstime) {
        this.qteEstime = qteEstime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIndexReleve() {
        return indexReleve;
    }

    public void setIndexReleve(Integer indexReleve) {
        this.indexReleve = indexReleve;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public String getCodeReleve() {
        return codeReleve;
    }

    public void setCodeReleve(String codeReleve) {
        this.codeReleve = codeReleve;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
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

    public Date getDateDuJour() {
        return dateDuJour;
    }

    public void setDateDuJour(Date dateDuJour) {
        this.dateDuJour = dateDuJour;
    }

    public Integer getModePhase() {
        return modePhase;
    }

    public void setModePhase(Integer modePhase) {
        this.modePhase = modePhase;
    }

    public Integer getCoeffLecture() {
        return coeffLecture;
    }

    public void setCoeffLecture(Integer coeffLecture) {
        this.coeffLecture = coeffLecture;
    }

    public ComptageAe getComptageAe() {
        return comptageAe;
    }

    public void setComptageAe(ComptageAe comptageAe) {
        this.comptageAe = comptageAe;
    }

    public Releve getReleve() {
        return releve;
    }

    public void setReleve(Releve releve) {
        this.releve = releve;
    }

    public ModeDetermination getModeDetermination() {
        return modeDetermination;
    }

    public void setModeDetermination(ModeDetermination modeDetermination) {
        this.modeDetermination = modeDetermination;
    }

    public Integer getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(Integer pdlAeid) {
        this.pdlAeid = pdlAeid;
    }

    public Integer getTypeAeid() {
        return typeAeid;
    }

    public void setTypeAeid(Integer typeAeid) {
        this.typeAeid = typeAeid;
    }

    //getters & setters des listes
    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }

    public List<TypeAe> getListTypePdl() {
        return listTypePdl;
    }

    public void setListTypePdl(List<TypeAe> listTypePdl) {
        this.listTypePdl = listTypePdl;
    }

    public List<ModeDetermination> getListModeDetermination() {
        return listModeDetermination;
    }

    public void setListModeDetermination(List<ModeDetermination> listModeDetermination) {
        this.listModeDetermination = listModeDetermination;
    }

    public List<ComptageAe> getListCpt() {
        return listCpt;
    }

    public void setListCpt(List<ComptageAe> listCpt) {
        this.listCpt = listCpt;
    }

    //Getters & Setters
    public Integer getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(Integer anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
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

    public String getCodePdl() {
        return codePdl;
    }

    public void setCodePdl(String codePdl) {
        this.codePdl = codePdl;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<PdlAe> getListPdlByType() {
        return listPdlByType;
    }

    public void setListPdlByType(List<PdlAe> listPdlByType) {
        this.listPdlByType = listPdlByType;
    }

    public Integer getComptageid() {
        return comptageid;
    }

    public void setComptageid(Integer comptageid) {
        this.comptageid = comptageid;
    }

    public Integer getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(Integer ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    /*
     **************Méthodes**************
     */
    //Ajout d'une relève
    public void ajouterReleve() {
        releve = new Releve();
        calculQte();

        ModeDetermination mode = modeDeterminationFacadeLocal.find(getModeDeterminationid());

        releve.setDateHeureReleve(Date.from(Instant.now()));
        releve.setDescription(getDescription());
        releve.setIndexReleve(getIndexReleve());
        releve.setAncienIndex(getAncienIndex());

        LocalDate local = releve.getDateHeureReleve().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        mois = local.getMonthValue();
        annee = local.getYear();

        releve.setMois(mois);
        releve.setAnnee(annee);

        releve.setValidation(false);
        releve.setQuantite(getQuantite());

        releve.setComptageAeid(comptageAeFacadeLocal.find(comptageAe.getId()));
        releve.setModeDeterminationid(modeDeterminationFacadeLocal.find(modeDeterminationid));

        try {
            releveFacadeLocal.create(releve);
        } catch (Exception e) {
            System.out.println("create releve marche pas ");
        }

    }

    //Récupérer les Pdl par le Type
    public void initialiserPdlByType() {
        try {
            listPdlByType = pdlAeFacadeLocal.findPdlByType(codePdl);
            setListPdlByType(listPdlByType);
            System.out.println("find marche " + listPdlByType);
        } catch (Exception e) {
            System.out.println("find ne marche pas ");
        }
    }

    //Récupérer les comptages par le Pdl
    public void recupListCpt() {
        listCpt = comptageAeFacadeLocal.findComptageByPdl(pdlAeid);
    }

    //Récupérer la variable render pour changer la valeur de l'attribut 'Disabled' 
    //dans le cas d'Estimation pour les champs Quantité et Index releve 
    public void recupRender() {
        String mode = modeDeterminationFacadeLocal.find(modeDeterminationid).getCodeReleve();
        if (mode.equals("E")) {
            render = true;
        } else {
            render = false;
        }
    }

    //Récuperer l'ancien index
    public void recupAncienIndex() {
        comptageAe = comptageAeFacadeLocal.find(comptageAe.getId());
        Releve lastReleve = releveFacadeLocal.findLastReleveValide(comptageAe.getId(), true);

        //Si relève vide, on récupère l'index pose du comptage associé
        if (lastReleve == null) {
            ancienIndex = comptageAe.getIndexPose();

        } //Sinon, on récupère l'index de la dernière relève
        else {
            if (lastReleve.getIndexReleve() == null) {
                setAncienIndex(-1);
            } else {
                ancienIndex = lastReleve.getIndexReleve();
            }
            System.out.println("last releve ancien index :" + lastReleve.getIndexReleve());
        }
    }

    //Calculer la quantité des achats actives
    public Double calculQte() {
        comptageAe = comptageAeFacadeLocal.find(comptageAe.getId());
        ModeDetermination mode = null;
        try {
            mode = modeDeterminationFacadeLocal.find(getModeDeterminationid());
            System.out.println("mode trouvé" + mode);
        } catch (Exception e) {
            System.out.println("mode non trouvé");
        }

        FacesMessage facesMsg = new FacesMessage();

        Integer mdPhase = 0;
        if (comptageAe.getModePhase() == 3) {
            mdPhase = 1;
        }
        if (comptageAe.getModePhase() == 1) {
            mdPhase = 3;
        }

        //à supprimer
        if (comptageAe.getModePhase() == 2) {
            mdPhase = 2;
        }

        //Mode Releve = Estimation
        if (mode.getCodeReleve().equals("E")) {
            try {
                System.err.println("mode = " + mode.getCodeReleve());
            } catch (Exception e) {
                System.err.println("Erreur");
            }
        } else {
            //Cas normal
            if (getIndexReleve() > getAncienIndex()) {

                if (mode.getCodeReleve().equals("R") || mode.getCodeReleve().equals("T")) {
                    FacesContext.getCurrentInstance().addMessage("Le mode Télé relève / relève manuelle selectionné", facesMsg);

                    quantite = (double) mdPhase * comptageAe.getCoeffLecture() * (getIndexReleve() - getAncienIndex());
                    setQuantite(quantite);
                }
            }

            //Cas de Remise à Zéro
            if (getIndexReleve() < getAncienIndex()) {
                comptageAe.setRemiseZero(true);

                if (mode.getCodeReleve().equals("R") || mode.getCodeReleve().equals("T")) {
                    quantite = (double) comptageAe.getCoeffLecture() * (100000000 + getIndexReleve() - getAncienIndex());
                    setQuantite(quantite);
                }

            }

            //Ancien Index égal au nouvel Index
            if (Objects.equals(getIndexReleve(), getAncienIndex())) {
                setQuantite(0.0);
                FacesContext.getCurrentInstance().addMessage("Consommation nulle", facesMsg);
            }
        }
        return quantite;
    }

    //Récupérer la date du jour
    public String dateJour() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

}

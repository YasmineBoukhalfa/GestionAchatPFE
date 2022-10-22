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
import dz.elit.achat.service.ComptageAeFacadeLocal;
import dz.elit.achat.service.ModeDeterminationFacadeLocal;
import dz.elit.achat.service.PdlAeFacadeLocal;
import dz.elit.achat.service.ReleveFacadeLocal;
import dz.elit.achat.service.TypeAeFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "nonValidationReleveController")
@ViewScoped
public class NonValidationReleveController implements Serializable {

    @EJB
    private ReleveFacadeLocal releveFacadeLocal;

    @EJB
    private ComptageAeFacadeLocal comptageAeFacadeLocal;

    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;

    @EJB
    private ModeDeterminationFacadeLocal modeDeterminationFacadeLocal;

    @EJB
    private TypeAeFacadeLocal typeAeFacadeLocal;

    //Les listes
    private List<Releve> listReleveNonValidee;
    private List<ModeDetermination> listModeDetermination;
    private List<ComptageAe> listCpt;
    private List<PdlAe> listPdlByType;
    private List<TypeAe> listTypePdl;

    //Les attributs & objets
    private Releve releve;
    private ComptageAe comptageAe;
    private ModeDetermination modeDetermination;
    private Date dateHeureReleve;
    private Integer mois;
    private Double quantite;
    private Boolean validation;
    private String codePdl;
    private Boolean render;
    private Integer modeDeterminationid;
    private Integer modePhase;
    private Integer indexReleve;
    private String description;
    private Integer ancienIndex;
    private String pdl;
    private String cpt;
    private String type;
    private Integer pdlAeid;

    //no-args constructor
    public NonValidationReleveController() {
    }

    @PostConstruct
    //Récupérer la liste des relèves non validées
    public void recupererListReleveNonValidee() {
        if (UtilisateurController.getsession("session") == null) {
            try {
                UtilisateurController.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {

            }
        } else {
            listReleveNonValidee = releveFacadeLocal.findReleveNonValidee();
            listTypePdl = typeAeFacadeLocal.findAll();
            listModeDetermination = modeDeterminationFacadeLocal.findAll();
        }
    }

    //Récupérer les Pdl par le Type
    public void initialiserPdlByType() {
        System.err.println("releve.getComptageAeid().getPdlAeid().getTypeAeid().getCodePdl() " + releve.getComptageAeid().getPdlAeid().getTypeAeid().getCodePdl());
        listPdlByType = pdlAeFacadeLocal.findPdlByType(releve.getComptageAeid().getPdlAeid().getTypeAeid().getCodePdl());
    }

    //Récupérer les comptages par le Pdl
    public void recupListCpt() {
        listCpt = comptageAeFacadeLocal.findComptageByPdl(releve.getComptageAeid().getPdlAeid().getId());
    }

    public void initialiserController() {
        String id = getRequestParameter("edit");
        releve = releveFacadeLocal.find(Integer.parseInt(id));
        setReleve(releve);
        ModeDetermination mode = null;
        try {
            mode = modeDeterminationFacadeLocal.find(releve.getModeDeterminationid().getId());
            System.out.println("mode trouvé" + mode);
        } catch (Exception e) {
            System.out.println("mode non trouvé");
        }

        if (mode.getCodeReleve().equals("E")) {
            releve.setIndexReleve(null);
            recupRender();
        }

        initialiserReleve();
    }

    public void initialiserReleve() {
        try {
            type = releve.getComptageAeid().getPdlAeid().getTypeAeid().getLibelle();
            pdl = releve.getComptageAeid().getPdlAeid().getReference() + "-" + releve.getComptageAeid().getPdlAeid().getIntitule();
            cpt = releve.getComptageAeid().getNumSerie() + "-" + releve.getComptageAeid().getIntituleComptage();
            quantite = releve.getQuantite();
            dateHeureReleve = releve.getDateHeureReleve();
            mois = releve.getMois();
            ancienIndex = releve.getAncienIndex();
            indexReleve = releve.getIndexReleve();
            description = releve.getDescription();
        } catch (Exception e) {
            System.out.println("Erreur dans l'importation des données de la relève");
        }
    }

    public Integer getIndexReleve() {
        return indexReleve;
    }

    public void setIndexReleve(Integer indexReleve) {
        this.indexReleve = indexReleve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //getters & setters
    public List<Releve> getListReleveNonValidee() {
        return listReleveNonValidee;
    }

    public void setListReleveNonValidee(List<Releve> listReleveNonValidee) {
        this.listReleveNonValidee = listReleveNonValidee;
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

    public List<ModeDetermination> getListModeDetermination() {
        return listModeDetermination;
    }

    public void setListModeDetermination(List<ModeDetermination> listModeDetermination) {
        this.listModeDetermination = listModeDetermination;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Date getDateHeureReleve() {
        return dateHeureReleve;
    }

    public void setDateHeureReleve(Date dateHeureReleve) {
        this.dateHeureReleve = dateHeureReleve;
    }

    public Integer getModePhase() {
        return modePhase;
    }

    public void setModePhase(Integer modePhase) {
        this.modePhase = modePhase;
    }

    public ComptageAe getComptageAe() {
        return comptageAe;
    }

    public void setComptageAe(ComptageAe comptageAe) {
        this.comptageAe = comptageAe;
    }

    public Integer getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(Integer ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Integer getModeDeterminationid() {
        return modeDeterminationid;
    }

    public void setModeDeterminationid(Integer modeDeterminationid) {
        this.modeDeterminationid = modeDeterminationid;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public List<ComptageAe> getListCpt() {
        return listCpt;
    }

    public void setListCpt(List<ComptageAe> listCpt) {
        this.listCpt = listCpt;
    }

    public List<PdlAe> getListPdlByType() {
        return listPdlByType;
    }

    public void setListPdlByType(List<PdlAe> listPdlByType) {
        this.listPdlByType = listPdlByType;
    }

    public String getCodePdl() {
        return codePdl;
    }

    public void setCodePdl(String codePdl) {
        this.codePdl = codePdl;
    }

    public Integer getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(Integer pdlAeid) {
        this.pdlAeid = pdlAeid;
    }

    public List<TypeAe> getListTypePdl() {
        return listTypePdl;
    }

    public void setListTypePdl(List<TypeAe> listTypePdl) {
        this.listTypePdl = listTypePdl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ModeDetermination getModeDetermination() {
        return modeDetermination;
    }

    public void setModeDetermination(ModeDetermination modeDetermination) {
        this.modeDetermination = modeDetermination;
    }

    public String getPdl() {
        return pdl;
    }

    public void setPdl(String pdl) {
        this.pdl = pdl;
    }

    public String getCpt() {
        return cpt;
    }

    public void setCpt(String cpt) {
        this.cpt = cpt;
    }

    /**
     * ************Méthodes*************
     */
    //Récupérer la variable render pour changer la valeur de l'attribut 'Disabled' 
    //dans le cas d'Estimation pour les champs Quantité et Index releve 
    public void recupRender() {
        String mode = modeDeterminationFacadeLocal.find(releve.getModeDeterminationid().getId()).getCodeReleve();
        if (mode.equals("E")) {

            render = true;
        } else {
            render = false;
        }
    }

    //Valider une relève
    public void valider() {
        String id = getRequestParameter("valid");
        releve = releveFacadeLocal.find(Integer.parseInt(id));
        releve.setValidation(true);
        releve.setDateValidation(Date.from(Instant.now()));
        releveFacadeLocal.edit(releve);
    }

    //Consulter les informations d'une relève non validée
    public void consulter() {
        String id = getRequestParameter("consult");
        releve = releveFacadeLocal.find(Integer.parseInt(id));

        comptageAe = comptageAeFacadeLocal.find(releve.getComptageAeid().getId());

        setModePhase(comptageAe.getModePhase());
        modeDetermination = modeDeterminationFacadeLocal.find(releve.getModeDeterminationid().getId());
    }

    //Récupérer les informations d'une relève
    public void recuperer() {
        String id = getRequestParameter("supp");
        System.out.println("id :" + id);
        releve = releveFacadeLocal.find(Integer.parseInt(id));
    }

    //Supprimer une relève non validée
    public String delete() {
        releveFacadeLocal.remove(releve);
        return "NonValidationReleve.xhtml";
    }

    //Calculer la quantité des achats actives
    public Double calculQte() {

        comptageAe = comptageAeFacadeLocal.find(releve.getComptageAeid().getId());
        System.out.println("comptage trouvé" + comptageAe);

        ModeDetermination mode = modeDeterminationFacadeLocal.find(releve.getModeDeterminationid().getId());
        System.out.println("mode trouvé" + mode);

        FacesMessage facesMsg = new FacesMessage();

        Integer mdPhase = 0;
        if (releve.getComptageAeid().getModePhase() == 3) {
            mdPhase = 1;
        }
        if (releve.getComptageAeid().getModePhase() == 1) {
            mdPhase = 3;
        }
        if (releve.getComptageAeid().getModePhase() == 2) {
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
            if (releve.getIndexReleve() > releve.getAncienIndex()) {

                if (mode.getCodeReleve().equals("R") || mode.getCodeReleve().equals("T")) {
                    FacesContext.getCurrentInstance().addMessage("Le mode Télé relève / relève manuelle selectionné", facesMsg);

                    quantite = (double) mdPhase * comptageAe.getCoeffLecture() * (releve.getIndexReleve() - releve.getAncienIndex());
                    releve.setQuantite(quantite);
                }
            }

            //Cas de Remise à Zéro
            if (releve.getIndexReleve() < releve.getAncienIndex()) {
                comptageAe.setRemiseZero(true);

                if (mode.getCodeReleve().equals("R") || mode.getCodeReleve().equals("T")) {
                    quantite = (double) comptageAe.getCoeffLecture() * (100000000 + releve.getIndexReleve() - releve.getAncienIndex());
                    releve.setQuantite(quantite);
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

    //Modifier les informations d'une relève validée
    public void modifier() {
        setDescription(getDescription());

        ModeDetermination mode = null;
        try {
            mode = modeDeterminationFacadeLocal.find(releve.getModeDeterminationid().getId());
            System.out.println("mode trouvé" + mode);
        } catch (Exception e) {
            System.out.println("mode non trouvé");
        }

        try {
            if (mode.getCodeReleve().equals("E")) {
                try {
                    releve.setIndexReleve(null);
                    setQuantite(getQuantite());
                    System.out.println("quantite  trouvé" + getQuantite());
                } catch (Exception e) {
                    System.out.println("code non trouvé");
                }
            } else {
                releve.setQuantite(calculQte());
            }
        } catch (Exception e) {
            System.out.println("probleme if");
        }

        releve.setModeDeterminationid(modeDeterminationFacadeLocal.find(mode.getId()));

        releveFacadeLocal.edit(releve);
    }

    //Récuperer l'ancien index
    public void recupAncienIndex() {
        comptageAe = comptageAeFacadeLocal.find(comptageAe.getId());
        Releve lastReleve = releveFacadeLocal.findLastReleveValide(comptageAe.getId(), true);

        //Si relève vide, on récupère l'index pose du comptage associé
        if (lastReleve == null) {
            ancienIndex = comptageAe.getIndexPose();
        } //Sinon, on récupère l'index de la dernière relève validée
        else {
            ancienIndex = lastReleve.getIndexReleve();
        }
    }

}

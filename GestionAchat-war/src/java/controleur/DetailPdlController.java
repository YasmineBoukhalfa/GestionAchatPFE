/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleurs.util.JsfUtil.getRequestParameter;
import dz.elit.achat.entite.AdressePdl;
import dz.elit.achat.entite.CoordonneeGeo;
import static dz.elit.achat.entite.CoordonneeGeo_.pdlAe;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.Tension;
import dz.elit.achat.service.PdlAeFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
//import javax.faces.bean.ViewScoped;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "detailPdlController")
@ViewScoped
public class DetailPdlController implements Serializable {

    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;

    private List<PdlAe> listPdlAe;

// les attribts de pdl
    private PdlAe pdlAe;
    private String adrPdl;
    private Date datePv;
    private String intitule;
    private String puissance;
    private String reference;

    //les attributs de tension 
    private Tension tensionArriveid;
    private Tension tensionDepartid;

    //les attribts de cordonnées géo 
    private Integer coordonneeGeoid;
    private String longitude;
    private String lattitude;

    //les attributs de partie prenante
    private Integer partieReceptriceid;
    private Integer partieEmetriceid;
    private Integer id;

    private PdlAe detail;

    public DetailPdlController() {
    }

    @PostConstruct
    public void initialiserControlleur() {
        if (Util.getsession("session") == null) {
            try {
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {
            String id = getRequestParameter("id");
            pdlAe = pdlAeFacadeLocal.find(Integer.parseInt(id));
            afficherPdl();
        }
    }

    public void afficherPdl() {

//        this.puissance = pdlAe.getPuissance();
//       this.intitule= pdlAe.getIntitule();
//       this.reference=pdlAe.getReference();
//       this.datePv=pdlAe.getDatePv();
//       //this.coordonneeGeoid=pdlAe.getCoordonneeGeoid().getLatitude();
//         this.tensionArriveid=
        listPdlAe = pdlAeFacadeLocal.findAll();
    }

    public PdlAeFacadeLocal getPdlAeFacadeLocal() {
        return pdlAeFacadeLocal;
    }

    public void setPdlAeFacadeLocal(PdlAeFacadeLocal pdlAeFacadeLocal) {
        this.pdlAeFacadeLocal = pdlAeFacadeLocal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public PdlAe getPdlAe() {
        return pdlAe;
    }

    public void setPdlAe(PdlAe pdlAe) {
        this.pdlAe = pdlAe;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PdlAe getDetail() {
        return detail;
    }

    public void setDetail(PdlAe detail) {
        this.detail = detail;
    }

    public Date getDatePv() {
        return datePv;
    }

    public void setDatePv(Date datePv) {
        this.datePv = datePv;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleurs.util.JsfUtil.getRequestParameter;
import dz.elit.achat.entite.CoordonneeGeo;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.TypeAe;
import dz.elit.achat.service.PdlAeFacadeLocal;
import dz.elit.achat.service.TensionFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.view.ViewScoped;

/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "listePdlAeController")
@ViewScoped

public class ListePdlAeController implements Serializable {

    @EJB
    private TensionFacadeLocal tensionFacade;

    /**
     * Creates a new instance of ListePdlAeController
     */
    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;

    private List<PdlAe> listPdlAe;
    //private List<PdlAe> listePdl;

    private PdlAe pdlAe;
    private CoordonneeGeo cordGeo;
    private TypeAe typeAe;
// les attribts de pdl
    private Integer id;
    private String adrPdl;
    private Date date;
    private String intitule;

    private String puissance;
    private String reference;

    //les attributs de tension 
    private Integer tensiona;
    private Integer tensiond;

    //les attribts de cordonnées géo 
    private Integer coordonneeGeoid;
    private String longitude;
    private String lattitude;
    //les attributs de typr ae

    public ListePdlAeController() {
    }

    @PostConstruct
    public void initialiserController() {
        if (Util.getsession("session") == null) {
            try {
//                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
                Util.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {

            initialiserAttribues();

            initialiserListes();
        }
        //initpdlae();
    }

    public void initialiserAttribues() {
        pdlAe = new PdlAe();
        cordGeo = new CoordonneeGeo();
        this.id = null;
        this.adrPdl = null;
//        this.datePv = null;
//        this.adrsPdlid = null;
        this.intitule = null;
        this.coordonneeGeoid = null;
        this.lattitude = null;
        this.longitude = null;
        // this.nombreTransformation=0; 
        this.puissance = null;
        this.reference = null;
//        this.tensionDepartid = null;
//        this.tensionArriveid = null;
//        this.partieEmetriceid = null;
//        this.partieReceptriceid = null;
//        this.TypeAeid = null;
    }

    public void initialiserListes() {
        listPdlAe = pdlAeFacadeLocal.findAll();
//        listTypeAe = typeAeFacadeLocal.findAll();
//        listTensionDepart = tensionDepartFacadeLocal.findByType(1);
//        listTensionArrive = tensionArriveeFacadeLocal.findByType(2);
//        listEmetrice = EmetriceFacadeLocal.findAll();
//        listReceptrice = ReceptriceFacadeLocal.findAll();

    }

//    public void initpdlae() {
//        String id = getRequestParameter("id");
//        if (id != null) {
//            pdlAe = pdlAeFacadeLocal.find(Integer.parseInt(id));
//            //System.out.println("reference" + achatPdlElec.getReference());
//            //chargerPdl();
//            reference = pdlAe.getReference();
//            adrPdl = pdlAe.getAdrPdl();
//            lattitude = pdlAe.getCoordonneeGeoid().getLatitude();
//            longitude = pdlAe.getCoordonneeGeoid().getLongitude();
//            //System.out.println(achatPdlElec.getCoordonneesGeoid().getLatitude());
//
//        }
//    public void init() {
////      
//        pdlAe = new PdlAe();
//       // initialiser();
//        listPdlAe = pdlAeFacadeLocal.findAll();
//        
//    }
    public String delete() {
        String id = getRequestParameter("id");
        pdlAe = pdlAeFacadeLocal.find(Integer.parseInt(id));
        pdlAeFacadeLocal.remove(pdlAe);
        return "listePdl.xhtml";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
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

    public Integer getTensiona() {
        return tensiona;
    }

    public void setTensiona(Integer tensiona) {
        this.tensiona = tensiona;
    }

    public Integer getTensiond() {
        return tensiond;
    }

    public void setTensiond(Integer tensiond) {
        this.tensiond = tensiond;
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

    public CoordonneeGeo getCordGeo() {
        return cordGeo;
    }

    public void setCordGeo(CoordonneeGeo cordGeo) {
        this.cordGeo = cordGeo;
    }

    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }
//
//    public List<PdlAe> getListePdl() {
//        return listePdl;
//    }
//
//    public void setListePdl(List<PdlAe> listePdl) {
//        this.listePdl = listePdl;
//    }

}

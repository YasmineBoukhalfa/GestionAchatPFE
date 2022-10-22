/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dz.elit.achat.entite.AdressePdl;
import dz.elit.achat.entite.CoordonneeGeo;
import dz.elit.achat.entite.PartiePrenante;
import dz.elit.achat.entite.PdlAe;
import dz.elit.achat.entite.Tension;
import dz.elit.achat.entite.TypeAe;
import dz.elit.achat.service.AdressePdlFacadeLocal;
import dz.elit.achat.service.CoordonneeGeoFacadeLocal;
import dz.elit.achat.service.PartiePrenanteFacadeLocal;
import dz.elit.achat.service.PdlAeFacadeLocal;
import dz.elit.achat.service.TensionFacadeLocal;
import dz.elit.achat.service.TypeAeFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.security.cert.CRLReason;
import java.util.Date;
import java.util.List;
//import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

//import javax.faces.view.ViewScoped;
/**
 *
 * @author Yasmine
 */
@ManagedBean(name = "pdlController")
@ViewScoped
public class PdlController implements Serializable {

    @EJB
    private AdressePdlFacadeLocal adressPdlFacadeLocal;

    @EJB
    private PartiePrenanteFacadeLocal ReceptriceFacadeLocal;

    @EJB
    private PartiePrenanteFacadeLocal EmetriceFacadeLocal;

    @EJB
    private TypeAeFacadeLocal typeAeFacadeLocal;

    @EJB
    private PdlAeFacadeLocal pdlAeFacadeLocal;

    @EJB
    private TensionFacadeLocal tensionDepartFacadeLocal;

    @EJB
    private TensionFacadeLocal tensionArriveeFacadeLocal;

    @EJB
    private CoordonneeGeoFacadeLocal coordonneeGeoFacadeLocal;

//    @EJB
//    private AdressePdlFacadeLocal adressePdlFacadeLocal;
    // private PdlAe pdlAe;
    private Integer adressePdlid;

    //private AdressePdl adrsPdl;
    //private CoordonneeGeo cordGeo;
    //private TypeAe typeAe ;
// les attribts de pdl
    private String adrPdl;
    private Date datePv;
    private String intitule;
    //private Integer nombreTransformation;
    private String puissance;
    private String reference;
    private Date dateDuJour;

    private long adrsPdlid;

    private CoordonneeGeo cordGeo;

    //les attributs de tension 
    private Integer tensionArriveid;
    private Integer tensionDepartid;

    //les attribts de cordonnées géo 
    private Long coordonneeGeoid;
    private String longitude;
    private String lattitude;

    //les attributs de typr ae
    private Integer typeAeid;
    private String codePdl;
    private String libelle;

    //les attributs de partie prenante
    private Long partieReceptriceid;
    private Long partieEmetriceid;

    //folio 
    private String folio;

    //list pdl 
    private List<PdlAe> listPdlAe;
    private PdlAe pdlAe;

    private List<AdressePdl> listAdrs;

    //list typeae
    private List<TypeAe> listTypeAe;
    // private TypeAe typeAe;

    //list tension
    private List<Tension> listTensionArrive;
    private Tension tensionArrive;

    private List<Tension> listTensionDepart;
    private Tension tensionDepart;

    //list partie prenente
    private List<PartiePrenante> listReceptrice;
    private PartiePrenante receptrice;

    private List<PartiePrenante> listEmetrice;
    private PartiePrenante emetrice;
    private List<CoordonneeGeo> listCordo;
    //private CoordonneeGeo cordo;

    //private Object TypeAeFacade;
    public PdlController() {

    }

    @PostConstruct
    public void initialiserController() {
        if (UtilisateurController.getsession("session") == null) {
            try {
                UtilisateurController.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {
            initialiserAttribues();

            initialiserListes();
        }

    }

    public void initialiserAttribues() {
        pdlAe = new PdlAe();

        this.adressePdlid = null;
        this.adrPdl = null;
        this.datePv = null;
        this.folio = null;
        this.intitule = null;
        this.coordonneeGeoid = null;
        this.lattitude = null;
        this.longitude = null;

        this.puissance = null;
        this.reference = null;
        this.tensionDepartid = null;
        this.tensionArriveid = null;
        this.partieEmetriceid = null;
        this.partieReceptriceid = null;
        this.typeAeid = null;
        dateDuJour = new Date();

        this.adrsPdlid = 0;
    }

    public void initialiserListes() {

        listPdlAe = pdlAeFacadeLocal.findAll();
        listTypeAe = typeAeFacadeLocal.findAll();
        listTensionDepart = tensionDepartFacadeLocal.findByType(1);
        listTensionArrive = tensionArriveeFacadeLocal.findByType(2);
        listEmetrice = EmetriceFacadeLocal.findAll();
        listReceptrice = ReceptriceFacadeLocal.findAll();

//         listAdrs=adressPdlFacadeLocal.findAll();
    }
//   public String ajoutPdl(){
//   this.pdlAeFacadeLocal.create(this.pdlAe);
//   this.pdlAe=new PdlAe();
//   System.out.println("controleur.PdlController.ajoutPdl()");
//   return "listePdl";
//   }

    public void ajoutPdl() {

//                pdlAe = new PdlAe();
        cordGeo = new CoordonneeGeo();

        reference = "E" + folio + typeAeFacadeLocal.find(typeAeid).getCodePdl();
        pdlAe.setIntitule(intitule);
        pdlAe.setDatePv(datePv);

        pdlAe.setReference(reference);
        pdlAe.setPuissance(puissance);

        pdlAe.setTypeAeid(typeAeFacadeLocal.find(typeAeid));
        pdlAe.setAdrPdl(adrPdl);

        if (Integer.parseInt(lattitude) < 360 && Integer.parseInt(lattitude) > 0) {
            cordGeo.setLatitude(lattitude);
        } else {
            System.out.println("Erreur lattitude");
        }

        if (Integer.parseInt(longitude) < 180 && Integer.parseInt(longitude) > 0) {
            cordGeo.setLongitude(longitude);
        } else {
            System.out.println("Erreur longitude");
        }

        pdlAe.setCoordonneeGeoid(cordGeo);

        pdlAe.setTensionArriveeid(tensionArriveeFacadeLocal.find(tensionArriveid));

        pdlAe.setTensionDepartid(tensionDepartFacadeLocal.find(tensionDepartid));

        pdlAe.setPartieEmmetriceid(EmetriceFacadeLocal.find(partieEmetriceid));

        pdlAe.setPartieReceptriceid(ReceptriceFacadeLocal.find(partieReceptriceid));

        try {
            pdlAeFacadeLocal.create(pdlAe);
        } catch (Exception e) {
            System.out.println("erreur ajout");
        }

    }

    //les getter et setter
    //pdlAe
    public PdlAe getPdlAe() {
        return pdlAe;
    }

    public void setPdlAe(PdlAe pdlAe) {
        this.pdlAe = pdlAe;
    }

    //adresse pdlid
    public Long getAdrsPdlid() {
        return adrsPdlid;
    }

    public void setAdrsPdlid(Long adrsPdlid) {
        this.adrsPdlid = adrsPdlid;

    }
    // coordo geo 

    public List<CoordonneeGeo> getListCordo() {
        return listCordo;
    }

    public void setListCordo(List<CoordonneeGeo> listCordo) {
        this.listCordo = listCordo;
    }

//AdrPdl
    public String getAdrPdl() {
        return adrPdl;
    }

    public void setAdrPdl(String adrPdl) {
        this.adrPdl = adrPdl;
    }
//date PV

    public Date getDatePv() {
        return datePv;
    }

    public void setDatePv(Date datePv) {
        this.datePv = datePv;
    }
// date du jour 

    public Date getDateDuJour() {
        return dateDuJour;
    }

    public void setDateDuJour(Date dateDuJour) {
        this.dateDuJour = dateDuJour;
    }

    //intitule
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
//puissance

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

//Reference
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    //coordonnée Géo
    public CoordonneeGeo getCordGeo() {
        return cordGeo;
    }

    public void setCordGeo(CoordonneeGeo cordGeo) {
        this.cordGeo = cordGeo;
    }

    //Tension Arrivéeid
    public Integer getTensionArriveid() {
        return tensionArriveid;
    }

    public void setTensionArriveid(Integer tensionArriveid) {
        this.tensionArriveid = tensionArriveid;
    }
//Tension Departid

    public Integer getTensionDepartid() {
        return tensionDepartid;
    }

    public void setTensionDepartid(Integer tensionDepartid) {
        this.tensionDepartid = tensionDepartid;
    }
//list Tension Arrivée

    public List<Tension> getListTensionArrive() {
        return listTensionArrive;
    }

    public void setListTensionArrive(List<Tension> listTensionArrive) {
        this.listTensionArrive = listTensionArrive;
    }
//list Tension Depart

    public List<Tension> getListTensionDepart() {
        return listTensionDepart;
    }

    public void setListTensionDepart(List<Tension> listTensionDepart) {
        this.listTensionDepart = listTensionDepart;
    }
//coordoonee Geoid

    public Long getCoordonneeGeoid() {
        return coordonneeGeoid;
    }

    public void setCoordonneeGeoid(Long coordonneeGeoid) {
        this.coordonneeGeoid = coordonneeGeoid;
    }
//lngitude

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
//lattitude 

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
//TypeAeid

    public Integer getTypeAeid() {
        return typeAeid;
    }

    public void setTypeAeid(Integer typeAeid) {
        this.typeAeid = typeAeid;
    }

//CodePdL
    public String getCodePdl() {
        return codePdl;
    }

    public void setCodePdl(String codePdl) {
        this.codePdl = codePdl;
    }
//Libelle

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
//liste type Ae

    public List<TypeAe> getListTypeAe() {
        return listTypeAe;
    }

    public void setListTypeAe(List<TypeAe> listTypeAe) {
        this.listTypeAe = listTypeAe;
    }

//les parties prenantes id
    public Long getPartieReceptriceid() {
        return partieReceptriceid;
    }

    public void setPartieReceptriceid(Long partieReceptriceid) {
        this.partieReceptriceid = partieReceptriceid;
    }

    public Long getPartieEmetriceid() {
        return partieEmetriceid;
    }

    public void setPartieEmetriceid(Long partieEmetriceid) {
        this.partieEmetriceid = partieEmetriceid;
    }
//liste Partie prenante
    //liste receptrice

    public List<PartiePrenante> getListReceptrice() {
        return listReceptrice;
    }

    public void setListReceptrice(List<PartiePrenante> listReceptrice) {
        this.listReceptrice = listReceptrice;
    }
//liste emetrice

    public List<PartiePrenante> getListEmetrice() {
        return listEmetrice;
    }

    public void setListEmetrice(List<PartiePrenante> listEmetrice) {
        this.listEmetrice = listEmetrice;
    }
//liste pdlAe

    public List<PdlAe> getListPdlAe() {
        return listPdlAe;
    }

    public void setListPdlAe(List<PdlAe> listPdlAe) {
        this.listPdlAe = listPdlAe;
    }

    public List<AdressePdl> getListAdrs() {
        return listAdrs;
    }

    public void setListAdrs(List<AdressePdl> listAdrs) {
        this.listAdrs = listAdrs;
    }

    public Integer getAdressePdlid() {
        return adressePdlid;
    }

    public void setAdressePdlid(Integer adressePdlid) {
        this.adressePdlid = adressePdlid;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

}

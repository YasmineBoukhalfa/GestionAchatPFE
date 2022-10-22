/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleurs.util.JsfUtil.getRequestParameter;
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
@ManagedBean(name = "modifierPdlController")
@ViewScoped
public class ModifierPdlController implements Serializable {

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
    private Long adressePdlid;

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
    private CoordonneeGeo cordo;
    private Integer id;

    //private Object TypeAeFacade;
    public ModifierPdlController() {

    }

    @PostConstruct
    public void init() {
        if (UtilisateurController.getsession("session") == null) {
            try {
                UtilisateurController.redirectTo("/GestionAchat-war/faces/releve/Login.xhtml");
            } catch (IOException ex) {
            }
        } else {

            String id = getRequestParameter("id");
            System.out.println("id" + id);
            System.out.println("Integer.parseInt(id)" + Integer.parseInt(id));
            pdlAe = pdlAeFacadeLocal.find(Integer.parseInt(id));
            System.err.println("pdlAe " + pdlAe.getIntitule());
//            pdlAe = pdlAeFacadeLocal.find(Integer.parseInt(id));
//              pdlAe = pdlAeFacadeLocal.find(id);

            initialiserAttribuespdl();
            initialiserListes();
        }
    }

    public void initialiserAttribuespdl() {

        // this.adressePdlid = pdlAe.getAdressePdlid().getId();
        this.adrPdl = pdlAe.getAdrPdl();
        this.datePv = pdlAe.getDatePv();

        this.intitule = pdlAe.getIntitule();
        this.coordonneeGeoid = pdlAe.getCoordonneeGeoid().getId();
        //this.lattitude = pdlAe.getCoordonneeGeoid().getLatitude();
        //this.longitude = pdlAe.getCoordonneeGeoid().getLongitude();

        this.puissance = pdlAe.getPuissance();
        this.reference = pdlAe.getReference();
        this.tensionDepartid = pdlAe.getTensionDepartid().getId();
        this.tensionArriveid = pdlAe.getTensionArriveeid().getId();
        this.partieEmetriceid = pdlAe.getPartieEmmetriceid().getId();
        this.partieReceptriceid = pdlAe.getPartieReceptriceid().getId();
        this.typeAeid = pdlAe.getTypeAeid().getId();
//        this.adrsPdlid = pdlAe.getAdressePdlid().getId();

        cordGeo = coordonneeGeoFacadeLocal.find(coordonneeGeoid);
        lattitude = cordGeo.getLatitude();
        longitude = cordGeo.getLongitude();

    }

    public void initialiserListes() {

        listPdlAe = pdlAeFacadeLocal.findAll();
        listTypeAe = typeAeFacadeLocal.findAll();
        listTensionDepart = tensionDepartFacadeLocal.findByType(1);
        listTensionArrive = tensionArriveeFacadeLocal.findByType(2);
        listEmetrice = EmetriceFacadeLocal.findAll();
        listReceptrice = ReceptriceFacadeLocal.findAll();
//         listCordo=coordonneeGeoFacadeLocal.findAll();

//         listAdrs=adressPdlFacadeLocal.findAll();
    }
//   public String ajoutPdl(){
//   this.pdlAeFacadeLocal.create(this.pdlAe);
//   this.pdlAe=new PdlAe();
//   System.out.println("controleur.PdlController.ajoutPdl()");
//   return "listePdl";
//   }

    public void updatePdl() {

//                pdlAe = new PdlAe();
        cordGeo = new CoordonneeGeo();

        System.err.println("debut");
        pdlAe.setIntitule(intitule);
        pdlAe.setDatePv(datePv);
        pdlAe.setReference(reference);
        pdlAe.setPuissance(puissance);
        pdlAe.setAdrPdl(adrPdl);
        System.err.println("debut " + intitule + " " + datePv + " " + reference + " " + puissance + " " + adrPdl);
        pdlAe.setTypeAeid(typeAeFacadeLocal.find(typeAeid));
        System.err.println("pdlAe.setTypeAeid " + pdlAe.getTypeAeid());
        pdlAe.setTensionArriveeid(tensionArriveeFacadeLocal.find(tensionArriveid));
        System.err.println("pdlAe.setTensionArriveeid " + pdlAe.getTensionArriveeid());
        pdlAe.setTensionDepartid(tensionDepartFacadeLocal.find(tensionDepartid));
        System.err.println("pdlAe.setTensionDepartid " + pdlAe.getTensionDepartid());
        pdlAe.setPartieEmmetriceid(EmetriceFacadeLocal.find(partieEmetriceid));
        System.err.println("pdlAe.setPartieEmmetriceid " + pdlAe.getPartieEmmetriceid());
        pdlAe.setPartieReceptriceid(ReceptriceFacadeLocal.find(partieReceptriceid));
        System.err.println("pdlAe.setPartieReceptriceid " + pdlAe.getPartieReceptriceid());

        cordGeo.setLatitude(lattitude);
        cordGeo.setLongitude(longitude);
        pdlAe.setCoordonneeGeoid(cordGeo);

//                pdlAe.setAdressePdlid(adressPdlFacadeLocal.find(adrsPdlid)); yacine
//System.err.println("pdlAe.setAdressePdlid "+pdlAe.getAdressePdlid());
        pdlAeFacadeLocal.edit(pdlAe);

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Long getAdressePdlid() {
        return adressePdlid;
    }

    public void setAdressePdlid(Long adressePdlid) {
        this.adressePdlid = adressePdlid;
    }

}

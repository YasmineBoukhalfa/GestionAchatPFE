/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.entite;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ihab Boudissa
 */
@Entity
@Table(name = "pdl_ae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PdlAe.findAll", query = "SELECT p FROM PdlAe p"),
    @NamedQuery(name = "PdlAe.findById", query = "SELECT p FROM PdlAe p WHERE p.id = :id"),
    @NamedQuery(name = "PdlAe.findByAdrPdl", query = "SELECT p FROM PdlAe p WHERE p.adrPdl = :adrPdl"),
    @NamedQuery(name = "PdlAe.findByDatePv", query = "SELECT p FROM PdlAe p WHERE p.datePv = :datePv"),
    @NamedQuery(name = "PdlAe.findByIntitule", query = "SELECT p FROM PdlAe p WHERE p.intitule = :intitule"),
   
    @NamedQuery(name = "PdlAe.findByPuissance", query = "SELECT p FROM PdlAe p WHERE p.puissance = :puissance"),
    @NamedQuery(name = "PdlAe.findByType", query = "SELECT p FROM PdlAe p WHERE p.typeAeid.codePdl = :codePdl"),
    @NamedQuery(name = "PdlAe.findByReference", query = "SELECT p FROM PdlAe p WHERE p.reference = :reference")})
public class PdlAe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    
    @Column(name = "adr_pdl")
    private String adrPdl;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "date_pv")
    @Temporal(TemporalType.DATE)
    private Date datePv;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "intitule")
    private String intitule;
    
// 
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "puissance")
    private String puissance;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "reference")
    private String reference;
    
    /*@OneToMany(cascade = {CascadeType.DETACH,
                         CascadeType.MERGE,
                         CascadeType.PERSIST,
                         CascadeType.REFRESH}
                         ,mappedBy = "pdlAeid")
    private List<HistoriquePdl> historiquePdlList;*/
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pdlAeid")
    private List<ComptageAe> comptageAeList;
    
    @JoinColumn(name = "adresse_pdlid", referencedColumnName = "id")    
    @OneToOne(optional = false)
    private AdressePdl adressePdlid;
    
    @JoinColumn(name = "coordonnee_geoid", referencedColumnName = "id")
    @OneToOne(cascade= CascadeType.PERSIST)
    private CoordonneeGeo coordonneeGeoid;
    
    @JoinColumn(name = "partie_receptriceid", referencedColumnName = "id") 
    @ManyToOne(optional = false)
    private PartiePrenante partieReceptriceid;
    
    @JoinColumn(name = "partie_emmetriceid", referencedColumnName = "id")    
    @ManyToOne(optional = false)
    private PartiePrenante partieEmmetriceid;
    
    @JoinColumn(name = "tension_departid", referencedColumnName = "id")  
    @ManyToOne(optional = false)
    private Tension tensionDepartid;
    
    @JoinColumn(name = "tension_arriveeid", referencedColumnName = "id")  
    @ManyToOne(optional = false)
    private Tension tensionArriveeid;
    @JoinColumn(name = "type_aeid", referencedColumnName = "id")
    
    @ManyToOne(optional = false)
    private TypeAe typeAeid;

    public PdlAe() {
    }


    public PdlAe(Integer id, String adrPdl, Date datePv, String intitule, Integer nombreTransformation, String puissance, String reference) {
        this.id = id;
        this.adrPdl = adrPdl;
        this.datePv = datePv;
        this.intitule = intitule;
       
        this.puissance = puissance;
        this.reference = reference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdrPdl() {
        return adrPdl;
    }

    public void setAdrPdl(String adrPdl) {
        this.adrPdl = adrPdl;
    }

    public Date getDatePv() {
        return datePv;
    }

    public void setDatePv(Date datePv) {
        this.datePv = datePv;
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


    @XmlTransient
    public List<ComptageAe> getComptageAeList() {
        return comptageAeList;
    }

    public void setComptageAeList(List<ComptageAe> comptageAeList) {
        this.comptageAeList = comptageAeList;
    }

    public AdressePdl getAdressePdlid() {
        return adressePdlid;
    }

    public void setAdressePdlid(AdressePdl adressePdlid) {
        this.adressePdlid = adressePdlid;
    }

    public CoordonneeGeo getCoordonneeGeoid() {
        return coordonneeGeoid;
    }

    public void setCoordonneeGeoid(CoordonneeGeo coordonneeGeoid) {
        this.coordonneeGeoid = coordonneeGeoid;
    }

    public PartiePrenante getPartieReceptriceid() {
        return partieReceptriceid;
    }

    public void setPartieReceptriceid(PartiePrenante partieReceptriceid) {
        this.partieReceptriceid = partieReceptriceid;
    }

    public PartiePrenante getPartieEmmetriceid() {
        return partieEmmetriceid;
    }

    public void setPartieEmmetriceid(PartiePrenante partieEmmetriceid) {
        this.partieEmmetriceid = partieEmmetriceid;
    }

    public Tension getTensionDepartid() {
        return tensionDepartid;
    }

    public void setTensionDepartid(Tension tensionDepartid) {
        this.tensionDepartid = tensionDepartid;
    }

    public Tension getTensionArriveeid() {
        return tensionArriveeid;
    }

    public void setTensionArriveeid(Tension tensionArriveeid) {
        this.tensionArriveeid = tensionArriveeid;
    }

    public TypeAe getTypeAeid() {
        return typeAeid;
    }

    public void setTypeAeid(TypeAe typeAeid) {
        this.typeAeid = typeAeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PdlAe)) {
            return false;
        }
        PdlAe other = (PdlAe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.PdlAe[ id=" + id + " ]";
    }
    
}

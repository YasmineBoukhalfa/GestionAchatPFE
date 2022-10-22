/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ihab Boudissa
 */
@Entity
@Table(name = "historique_pdl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriquePdl.findAll", query = "SELECT h FROM HistoriquePdl h"),
    @NamedQuery(name = "HistoriquePdl.findById", query = "SELECT h FROM HistoriquePdl h WHERE h.id = :id"),
    @NamedQuery(name = "HistoriquePdl.findByPuissance", query = "SELECT h FROM HistoriquePdl h WHERE h.puissance = :puissance"),
    @NamedQuery(name = "HistoriquePdl.findByIntitule", query = "SELECT h FROM HistoriquePdl h WHERE h.intitule = :intitule"),
    @NamedQuery(name = "HistoriquePdl.findByReference", query = "SELECT h FROM HistoriquePdl h WHERE h.reference = :reference"),
    @NamedQuery(name = "HistoriquePdl.findByDatePv", query = "SELECT h FROM HistoriquePdl h WHERE h.datePv = :datePv"),
    @NamedQuery(name = "HistoriquePdl.findByAdrPdl", query = "SELECT h FROM HistoriquePdl h WHERE h.adrPdl = :adrPdl"),
    @NamedQuery(name = "HistoriquePdl.findByNombreTransformation", query = "SELECT h FROM HistoriquePdl h WHERE h.nombreTransformation = :nombreTransformation")})
public class HistoriquePdl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "puissance")
    private String puissance;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "intitule")
    private String intitule;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reference")
    private String reference;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_pv")
    @Temporal(TemporalType.DATE)
    private Date datePv;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adr_pdl")
    private String adrPdl;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_transformation")
    private Integer nombreTransformation;

    @JoinColumn(name = "pdl_aeid", referencedColumnName = "id")

    @Basic(optional = false)
    @NotNull
    @Column(name = "tension_arriveeid")
    private Integer tensionArriveeid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tension_departid")
    private Integer tensionDepartid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "type_aeid")
    private Integer typeAeid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "adresse_pdlid")
    private Integer adressePdlid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "coordonnee_geoid")
    private Integer coordonneeGeoid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "partie_emmetriceid")
    private Integer partieEmmetriceid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "partie_receptriceid")
    private Integer partieReceptriceid;

    @ManyToOne(optional = false)
    private PdlAe pdlAeid;

    public HistoriquePdl() {
    }

    public HistoriquePdl(Integer id, String puissance, String intitule, String reference, Date datePv, String adrPdl, Integer nombreTransformation) {
        this.id = id;
        this.puissance = puissance;
        this.intitule = intitule;
        this.reference = reference;
        this.datePv = datePv;
        this.adrPdl = adrPdl;
        this.nombreTransformation = nombreTransformation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDatePv() {
        return datePv;
    }

    public void setDatePv(Date datePv) {
        this.datePv = datePv;
    }

    public String getAdrPdl() {
        return adrPdl;
    }

    public void setAdrPdl(String adrPdl) {
        this.adrPdl = adrPdl;
    }

    public Integer getNombreTransformation() {
        return nombreTransformation;
    }

    public void setNombreTransformation(Integer nombreTransformation) {
        this.nombreTransformation = nombreTransformation;
    }

    public PdlAe getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(PdlAe pdlAeid) {
        this.pdlAeid = pdlAeid;
    }

    public Integer getPartieReceptriceid() {
        return partieReceptriceid;
    }

    public void setPartieReceptriceid(Integer partieReceptriceid) {
        this.partieReceptriceid = partieReceptriceid;
    }

    public Integer getPartieEmmetriceid() {
        return partieEmmetriceid;
    }

    public void setPartieEmmetriceid(Integer partieEmmetriceid) {
        this.partieEmmetriceid = partieEmmetriceid;
    }

    public Integer getTensionDepartid() {
        return tensionDepartid;
    }

    public void setTensionDepartid(Integer tensionDepartid) {
        this.tensionDepartid = tensionDepartid;
    }

    public Integer getTensionArriveeid() {
        return tensionArriveeid;
    }

    public void setTensionArriveeid(Integer tensionArriveeid) {
        this.tensionArriveeid = tensionArriveeid;
    }

    public Integer getTypeAeid() {
        return typeAeid;
    }

    public void setTypeAeid(Integer typeAeid) {
        this.typeAeid = typeAeid;
    }

    public Integer getAdressePdlid() {
        return adressePdlid;
    }

    public void setAdressePdlid(Integer adressePdlid) {
        this.adressePdlid = adressePdlid;
    }

    public Integer getCoordonneeGeoid() {
        return coordonneeGeoid;
    }

    public void setCoordonneeGeoid(Integer coordonneeGeoid) {
        this.coordonneeGeoid = coordonneeGeoid;
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
        if (!(object instanceof HistoriquePdl)) {
            return false;
        }
        HistoriquePdl other = (HistoriquePdl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.HistoriquePdl[ id=" + id + " ]";
    }

}

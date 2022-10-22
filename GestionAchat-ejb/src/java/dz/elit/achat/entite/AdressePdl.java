/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.elit.achat.entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ihab Boudissa
 */
@Entity
@Table(name = "adresse_pdl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdressePdl.findAll", query = "SELECT a FROM AdressePdl a"),
    @NamedQuery(name = "AdressePdl.findById", query = "SELECT a FROM AdressePdl a WHERE a.id = :id"),
    @NamedQuery(name = "AdressePdl.findByRue", query = "SELECT a FROM AdressePdl a WHERE a.rue = :rue"),
    @NamedQuery(name = "AdressePdl.findByBoulevard", query = "SELECT a FROM AdressePdl a WHERE a.boulevard = :boulevard"),
    @NamedQuery(name = "AdressePdl.findByImpasse", query = "SELECT a FROM AdressePdl a WHERE a.impasse = :impasse"),
    @NamedQuery(name = "AdressePdl.findByDomaine", query = "SELECT a FROM AdressePdl a WHERE a.domaine = :domaine"),
    @NamedQuery(name = "AdressePdl.findByZoneIndustrielle", query = "SELECT a FROM AdressePdl a WHERE a.zoneIndustrielle = :zoneIndustrielle"),
    @NamedQuery(name = "AdressePdl.findByNumero", query = "SELECT a FROM AdressePdl a WHERE a.numero = :numero")})
public class AdressePdl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rue")
    private String rue;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "boulevard")
    private String boulevard;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "impasse")
    private String impasse;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "domaine")
    private String domaine;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "zone_industrielle")
    private String zoneIndustrielle;

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private long numero;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adressePdlid")
    private List<PdlAe> pdlAeList;

    public AdressePdl() {
    }

    public AdressePdl(Long id, String rue, String boulevard, String impasse, String domaine, String zoneIndustrielle, long numero) {
        this.id = id;
        this.rue = rue;
        this.boulevard = boulevard;
        this.impasse = impasse;
        this.domaine = domaine;
        this.zoneIndustrielle = zoneIndustrielle;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getBoulevard() {
        return boulevard;
    }

    public void setBoulevard(String boulevard) {
        this.boulevard = boulevard;
    }

    public String getImpasse() {
        return impasse;
    }

    public void setImpasse(String impasse) {
        this.impasse = impasse;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getZoneIndustrielle() {
        return zoneIndustrielle;
    }

    public void setZoneIndustrielle(String zoneIndustrielle) {
        this.zoneIndustrielle = zoneIndustrielle;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<PdlAe> getPdlAeList() {
        return pdlAeList;
    }

    public void setPdlAeList(List<PdlAe> pdlAeList) {
        this.pdlAeList = pdlAeList;
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
        if (!(object instanceof AdressePdl)) {
            return false;
        }
        AdressePdl other = (AdressePdl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.AdressePdl[ id=" + id + " ]";
    }

}

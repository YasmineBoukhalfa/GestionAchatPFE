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
@Table(name = "releve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Releve.findAll", query = "SELECT r FROM Releve r"),
    @NamedQuery(name = "Releve.findById", query = "SELECT r FROM Releve r WHERE r.id = :id"),
    @NamedQuery(name = "Releve.findByAnnee", query = "SELECT r FROM Releve r WHERE r.annee = :annee"),
    @NamedQuery(name = "Releve.findByDateHeureReleve", query = "SELECT r FROM Releve r WHERE r.dateHeureReleve = :dateHeureReleve"),
    @NamedQuery(name = "Releve.findByDateValidation", query = "SELECT r FROM Releve r WHERE r.dateValidation = :dateValidation"),
    @NamedQuery(name = "Releve.findByDescription", query = "SELECT r FROM Releve r WHERE r.description = :description"),
    @NamedQuery(name = "Releve.findByIndexReleve", query = "SELECT r FROM Releve r WHERE r.indexReleve = :indexReleve"),
    @NamedQuery(name = "Releve.findByAncienIndex", query = "SELECT r FROM Releve r WHERE r.ancienIndex = :ancienIndex"),
    @NamedQuery(name = "Releve.findByMois", query = "SELECT r FROM Releve r WHERE r.mois = :mois"),
    @NamedQuery(name = "Releve.findByQuantite", query = "SELECT r FROM Releve r WHERE r.quantite = :quantite"),
    @NamedQuery(name = "Releve.findByValidation", query = "SELECT r FROM Releve r WHERE r.validation = :validation"),
    @NamedQuery(name = "Releve.findLastRel", query = "SELECT r FROM Releve r WHERE r.validation = :b AND r.comptageAeid.id = :id ORDER BY r.id DESC"),
    @NamedQuery(name = "Releve.findReleveByComptage", query = "SELECT r FROM Releve r WHERE r.comptageAeid.id = :id"), 
    @NamedQuery(name = "Releve.findSomByAnneeMois", query = "SELECT SUM(r.quantite) FROM Releve r WHERE r.comptageAeid.pdlAeid.typeAeid.codePdl = :type AND r.annee = :annee AND r.mois = :mois"),
})
public class Releve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    private Integer annee;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_heure_releve")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureReleve;

    @Basic(optional = false)
    @Column(name = "date_validation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "index_releve")
    private Integer indexReleve;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancien_index")
    private Integer ancienIndex;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mois")
    private Integer mois;

    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private double quantite;

    @Column(name = "validation")
    private Boolean validation;

    @JoinColumn(name = "comptage_aeid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComptageAe comptageAeid;

    @JoinColumn(name = "mode_determinationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ModeDetermination modeDeterminationid;

    public Releve() {
    }

    public Releve(Integer id, Integer annee, Date dateHeureReleve, Date dateValidation, Integer ancienIndex, Integer indexReleve, Integer mois, double quantite) {
        this.id = id;
        this.annee = annee;
        this.dateHeureReleve = dateHeureReleve;
        this.dateValidation = dateValidation;
        this.indexReleve = indexReleve;
        this.ancienIndex = ancienIndex;
        this.mois = mois;
        this.quantite = quantite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAncienIndex() {
        return ancienIndex;
    }

    public void setAncienIndex(Integer ancienIndex) {
        this.ancienIndex = ancienIndex;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public ComptageAe getComptageAeid() {
        return comptageAeid;
    }

    public void setComptageAeid(ComptageAe comptageAeid) {
        this.comptageAeid = comptageAeid;
    }

    public ModeDetermination getModeDeterminationid() {
        return modeDeterminationid;
    }

    public void setModeDeterminationid(ModeDetermination modeDeterminationid) {
        this.modeDeterminationid = modeDeterminationid;
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
        if (!(object instanceof Releve)) {
            return false;
        }
        Releve other = (Releve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.Releve[ id=" + id + " ]";
    }

}

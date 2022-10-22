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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ihab Boudissa
 */
@Entity
@Table(name = "motif_modification_comptage_ae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotifModificationComptageAe.findAll", query = "SELECT m FROM MotifModificationComptageAe m"),

    @NamedQuery(name = "MotifModificationComptageAe.findByDateModification", query = "SELECT m FROM MotifModificationComptageAe m WHERE m.dateModification = :dateModification")})

public class MotifModificationComptageAe implements Serializable {

    //private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected MotifModificationComptageAe motifModificationComptageAe;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    @Basic(optional = false)
    @NotNull
    private Integer motifModificationComptageAe;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @JoinColumn(name = "comptage_aeid", referencedColumnName = "id", insertable = false, updatable = false)

    @ManyToOne(optional = false)
    private ComptageAe comptageAe;
    @JoinColumn(name = "motif_modificationid", referencedColumnName = "id", insertable = false, updatable = false)

    @ManyToOne(optional = false)
    private MotifModification motifModification;

    public MotifModificationComptageAe() {
    }

//    public MotifModificationComptageAe(MotifModificationComptageAe motifModificationComptageAe) {
//        this.motifModificationComptageAe = motifModificationComptageAe;
//    }
//
//    public MotifModificationComptageAe(MotifModificationComptageAe motifModificationComptageAe, Date dateModification) {
//        this.motifModificationComptageAe = motifModificationComptageAe;
//        this.dateModification = dateModification;
//    }
//
//    public MotifModificationComptageAe(Integer id, Integer motifModificationid, long comptageAeid) {
//        this.motifModificationComptageAe = new MotifModificationComptageAe(id, motifModificationid, comptageAeid);
//    }
//    public MotifModificationComptageAe getMotifModificationComptageAe() {
//        return motifModificationComptageAe;
//    }
//
//    public void setMotifModificationComptageAe(MotifModificationComptageAe motifModificationComptageAe) {
//        this.motifModificationComptageAe = motifModificationComptageAe;
//    }
    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public ComptageAe getComptageAe() {
        return comptageAe;
    }

    public void setComptageAe(ComptageAe comptageAe) {
        this.comptageAe = comptageAe;
    }

    public MotifModification getMotifModification() {
        return motifModification;
    }

    public void setMotifModification(MotifModification motifModification) {
        this.motifModification = motifModification;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (motifModificationComptageAe != null ? motifModificationComptageAe.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof MotifModificationComptageAe)) {
//            return false;
//        }
//        MotifModificationComptageAe other = (MotifModificationComptageAe) object;
//        if ((this.motifModificationComptageAe == null && other.motifModificationComptageAe != null) || (this.motifModificationComptageAe != null && !this.motifModificationComptageAe.equals(other.motifModificationComptageAe))) {
//            return false;
//        }
//        return true;
//    }
    public int getMotifModificationComptageAe() {
        return motifModificationComptageAe;
    }

    public void setMotifModificationComptageAe(int motifModificationComptageAe) {
        this.motifModificationComptageAe = motifModificationComptageAe;
    }

//    @Override
//    public String toString() {
//        return "dz.elit.achat.entite.MotifModificationComptageAe[ motifModificationComptageAe=" + motifModificationComptageAe + " ]";
//    }
}

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
@Table(name = "comptage_ae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComptageAe.findAll", query = "SELECT c FROM ComptageAe c"),
    @NamedQuery(name = "ComptageAe.findById", query = "SELECT c FROM ComptageAe c WHERE c.id = :id"),
    @NamedQuery(name = "ComptageAe.findByAnneeFabrication", query = "SELECT c FROM ComptageAe c WHERE c.anneeFabrication = :anneeFabrication"),
    @NamedQuery(name = "ComptageAe.findByCoeffLecture", query = "SELECT c FROM ComptageAe c WHERE c.coeffLecture = :coeffLecture"),
    @NamedQuery(name = "ComptageAe.findByDateInstallation", query = "SELECT c FROM ComptageAe c WHERE c.dateInstallation = :dateInstallation"),
    @NamedQuery(name = "ComptageAe.findByDateService", query = "SELECT c FROM ComptageAe c WHERE c.dateService = :dateService"),
    @NamedQuery(name = "ComptageAe.findByDatePose", query = "SELECT c FROM ComptageAe c WHERE c.datePose = :datePose"),
    @NamedQuery(name = "ComptageAe.findByEtatComptage", query = "SELECT c FROM ComptageAe c WHERE c.etatComptage = :etatComptage"),
    @NamedQuery(name = "ComptageAe.findByNumSerie", query = "SELECT c FROM ComptageAe c WHERE c.numSerie = :numSerie"),
    @NamedQuery(name = "ComptageAe.findByNbDigits", query = "SELECT c FROM ComptageAe c WHERE c.nbDigits = :nbDigits"),
    @NamedQuery(name = "ComptageAe.findByIndexPose", query = "SELECT c FROM ComptageAe c WHERE c.indexPose = :indexPose"),
    @NamedQuery(name = "ComptageAe.findByIndexDepose", query = "SELECT c FROM ComptageAe c WHERE c.indexDepose = :indexDepose"),
    @NamedQuery(name = "ComptageAe.findByModePhase", query = "SELECT c FROM ComptageAe c WHERE c.modePhase = :modePhase"),
    @NamedQuery(name = "ComptageAe.findByRemiseZero", query = "SELECT c FROM ComptageAe c WHERE c.remiseZero = :remiseZero"),
    
    @NamedQuery(name = "ComptageAe.findComptageByPdl", query = "SELECT c FROM ComptageAe c WHERE c.pdlAeid.id = :id"),
    
    @NamedQuery(name = "ComptageAe.findByIntituleComptage", query = "SELECT c FROM ComptageAe c WHERE c.intituleComptage = :intituleComptage"),})

public class ComptageAe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "annee_fabrication")
    private Integer anneeFabrication;

    @Basic(optional = false)
    @NotNull
    @Column(name = "coeff_lecture")
    private long coeffLecture;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_installation")
    @Temporal(TemporalType.DATE)
    private Date dateInstallation;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_service")
    @Temporal(TemporalType.DATE)
    private Date dateService;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_pose")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePose;

    @Basic(optional = false)
    @NotNull
    @Column(name = "etat_comptage")
    private Boolean etatComptage;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_serie")
    private String numSerie;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_digits")
    private Integer nbDigits;

    @Basic(optional = false)
    @NotNull
    @Column(name = "index_pose")
    private Integer indexPose;

    @Column(name = "index_depose")
    private Integer indexDepose;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mode_phase")
    private Integer modePhase;

    @Basic(optional = false)
    @NotNull
    @Column(name = "remise_zero")
    private Boolean remiseZero;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "intitule_comptage")
    private String intituleComptage;

    @JoinColumn(name = "marqueid", referencedColumnName = "id")

    @ManyToOne(optional = false)
    private Marque marqueid;
    @JoinColumn(name = "natureid", referencedColumnName = "id")

    @ManyToOne(optional = false)
    private Nature natureid;
    @JoinColumn(name = "pdl_aeid", referencedColumnName = "id")

    @ManyToOne(optional = false)
    private PdlAe pdlAeid;

    public ComptageAe() {
    }

    public ComptageAe(Long id, int anneeFabrication, long coeffLecture, Date dateInstallation, Date dateService, Date datePose, boolean etatComptage, String numSerie, int nbDigits, int indexPose, int modePhase, boolean remiseZero, String intituleComptage) {
        this.id = id;
        this.anneeFabrication = anneeFabrication;
        this.coeffLecture = coeffLecture;
        this.dateInstallation = dateInstallation;
        this.dateService = dateService;
        this.datePose = datePose;
        this.etatComptage = etatComptage;
        this.numSerie = numSerie;
        this.nbDigits = nbDigits;
        this.indexPose = indexPose;
        this.modePhase = modePhase;
        this.remiseZero = remiseZero;
        this.intituleComptage = intituleComptage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public long getCoeffLecture() {
        return coeffLecture;
    }

    public void setCoeffLecture(long coeffLecture) {
        this.coeffLecture = coeffLecture;
    }

    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

    public Date getDateService() {
        return dateService;
    }

    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }

    public Date getDatePose() {
        return datePose;
    }

    public void setDatePose(Date datePose) {
        this.datePose = datePose;
    }

    public boolean getEtatComptage() {
        return etatComptage;
    }

    public void setEtatComptage(boolean etatComptage) {
        this.etatComptage = etatComptage;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getNbDigits() {
        return nbDigits;
    }

    public void setNbDigits(Integer nbDigits) {
        this.nbDigits = nbDigits;
    }

    public Integer getIndexPose() {
        return indexPose;
    }

    public void setIndexPose(Integer indexPose) {
        this.indexPose = indexPose;
    }

    public Integer getIndexDepose() {
        return indexDepose;
    }

    public void setIndexDepose(Integer indexDepose) {
        this.indexDepose = indexDepose;
    }

    public Integer getModePhase() {
        return modePhase;
    }

    public void setModePhase(Integer modePhase) {
        this.modePhase = modePhase;
    }

    public boolean getRemiseZero() {
        return remiseZero;
    }

    public void setRemiseZero(boolean remiseZero) {
        this.remiseZero = remiseZero;
    }

    public String getIntituleComptage() {
        return intituleComptage;
    }

    public void setIntituleComptage(String intituleComptage) {
        this.intituleComptage = intituleComptage;
    }

    public Marque getMarqueid() {
        return marqueid;
    }

    public void setMarqueid(Marque marqueid) {
        this.marqueid = marqueid;
    }

    public Nature getNatureid() {
        return natureid;
    }

    public void setNatureid(Nature natureid) {
        this.natureid = natureid;
    }

    public PdlAe getPdlAeid() {
        return pdlAeid;
    }

    public void setPdlAeid(PdlAe pdlAeid) {
        this.pdlAeid = pdlAeid;
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
        if (!(object instanceof ComptageAe)) {
            return false;
        }
        ComptageAe other = (ComptageAe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.ComptageAe[ id=" + id + " ]";
    }

    public void setPdlAeid(int i) {
        this.pdlAeid.setId(i);
    }

    public void setMarqueid(int i) {
        this.marqueid.setId(i);
    }

    public void setNatureid(int i) {
        this.natureid.setId(i);
    }
}

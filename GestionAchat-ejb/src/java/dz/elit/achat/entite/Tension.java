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
import javax.persistence.OneToMany;
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
@Table(name = "tension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tension.findAll", query = "SELECT t FROM Tension t"),
    @NamedQuery(name = "Tension.findById", query = "SELECT t FROM Tension t WHERE t.id = :id"),
    @NamedQuery(name = "Tension.findByLibelle", query = "SELECT t FROM Tension t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tension.findByType", query = "SELECT t FROM Tension t WHERE t.type = :type"),
    @NamedQuery(name = "Tension.findByValeur", query = "SELECT t FROM Tension t WHERE t.valeur = :valeur")})
public class Tension implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle")
    private String libelle;

    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Integer type;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur")
    private Integer valeur;

    public Tension() {
    }

    public Tension(Integer id, String libelle, Integer type, Integer valeur) {
        this.id = id;
        this.libelle = libelle;
        this.type = type;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
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
        if (!(object instanceof Tension)) {
            return false;
        }
        Tension other = (Tension) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.Tension[ id=" + id + " ]";
    }

}

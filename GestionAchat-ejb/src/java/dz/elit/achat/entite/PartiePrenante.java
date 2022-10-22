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
@Table(name = "partie_prenante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartiePrenante.findAll", query = "SELECT p FROM PartiePrenante p"),
    @NamedQuery(name = "PartiePrenante.findById", query = "SELECT p FROM PartiePrenante p WHERE p.id = :id"),
    @NamedQuery(name = "PartiePrenante.findByCode", query = "SELECT p FROM PartiePrenante p WHERE p.code = :code"),
    @NamedQuery(name = "PartiePrenante.findByLibelle", query = "SELECT p FROM PartiePrenante p WHERE p.libelle = :libelle")})
public class PartiePrenante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle")
    private String libelle;

    public PartiePrenante() {
    }

    public PartiePrenante(Long id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        if (!(object instanceof PartiePrenante)) {
            return false;
        }
        PartiePrenante other = (PartiePrenante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.PartiePrenante[ id=" + id + " ]";
    }

}

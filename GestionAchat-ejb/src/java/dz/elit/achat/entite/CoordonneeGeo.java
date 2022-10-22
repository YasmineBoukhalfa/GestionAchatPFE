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
@Table(name = "coordonnee_geo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordonneeGeo.findAll", query = "SELECT c FROM CoordonneeGeo c"),
    @NamedQuery(name = "CoordonneeGeo.findById", query = "SELECT c FROM CoordonneeGeo c WHERE c.id = :id"),
    @NamedQuery(name = "CoordonneeGeo.findByLongitude", query = "SELECT c FROM CoordonneeGeo c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "CoordonneeGeo.findByLatitude", query = "SELECT c FROM CoordonneeGeo c WHERE c.latitude = :latitude")})
public class CoordonneeGeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "longitude")
    private String longitude;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "latitude")
    private String latitude;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coordonneeGeoid")
    private PdlAe pdlAe;

    public CoordonneeGeo() {
    }

    public CoordonneeGeo(Long id, String longitude, String latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
        if (!(object instanceof CoordonneeGeo)) {
            return false;
        }
        CoordonneeGeo other = (CoordonneeGeo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.elit.achat.entite.CoordonneeGeo[ id=" + id + " ]";
    }

}

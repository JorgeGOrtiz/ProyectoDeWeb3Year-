/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ConsejoTratamiento.domain;

import cu.edu.unah.Proyectov1.Tratamientos.domain.Tratamientos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "consejo_tratamiento", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsejoTratamiento.findAll", query = "SELECT c FROM ConsejoTratamiento c"),
    @NamedQuery(name = "ConsejoTratamiento.findByTratamientosidTratamiento", query = "SELECT c FROM ConsejoTratamiento c WHERE c.consejoTratamientoPK.tratamientosidTratamiento = :tratamientosidTratamiento"),
    @NamedQuery(name = "ConsejoTratamiento.findByIdConsejosTratamientos", query = "SELECT c FROM ConsejoTratamiento c WHERE c.consejoTratamientoPK.idConsejosTratamientos = :idConsejosTratamientos"),
    @NamedQuery(name = "ConsejoTratamiento.findByConsejosProfecionalTratamientos", query = "SELECT c FROM ConsejoTratamiento c WHERE c.consejosProfecionalTratamientos = :consejosProfecionalTratamientos")})
public class ConsejoTratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsejoTratamientoPK consejoTratamientoPK;
    @Basic(optional = false)
    @Column(name = "consejos_profecional_tratamientos")
    private String consejosProfecionalTratamientos;
    
    @JoinColumn(name = "tratamientosid_tratamiento", referencedColumnName = "id_tratamiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientos tratamientos;

    public ConsejoTratamiento() {
    }

    public ConsejoTratamiento(ConsejoTratamientoPK consejoTratamientoPK) {
        this.consejoTratamientoPK = consejoTratamientoPK;
    }

    public ConsejoTratamiento(ConsejoTratamientoPK consejoTratamientoPK, String consejosProfecionalTratamientos) {
        this.consejoTratamientoPK = consejoTratamientoPK;
        this.consejosProfecionalTratamientos = consejosProfecionalTratamientos;
    }

    public ConsejoTratamiento(int tratamientosidTratamiento, int idConsejosTratamientos) {
        this.consejoTratamientoPK = new ConsejoTratamientoPK(tratamientosidTratamiento, idConsejosTratamientos);
    }

    public ConsejoTratamientoPK getConsejoTratamientoPK() {
        return consejoTratamientoPK;
    }

    public void setConsejoTratamientoPK(ConsejoTratamientoPK consejoTratamientoPK) {
        this.consejoTratamientoPK = consejoTratamientoPK;
    }

    public String getConsejosProfecionalTratamientos() {
        return consejosProfecionalTratamientos;
    }

    public void setConsejosProfecionalTratamientos(String consejosProfecionalTratamientos) {
        this.consejosProfecionalTratamientos = consejosProfecionalTratamientos;
    }

       public Tratamientos getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Tratamientos tratamientos) {
        this.tratamientos = tratamientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consejoTratamientoPK != null ? consejoTratamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejoTratamiento)) {
            return false;
        }
        ConsejoTratamiento other = (ConsejoTratamiento) object;
        if ((this.consejoTratamientoPK == null && other.consejoTratamientoPK != null) || (this.consejoTratamientoPK != null && !this.consejoTratamientoPK.equals(other.consejoTratamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultor.ConsejoTratamiento[ consejoTratamientoPK=" + consejoTratamientoPK + " ]";
    }
    
}

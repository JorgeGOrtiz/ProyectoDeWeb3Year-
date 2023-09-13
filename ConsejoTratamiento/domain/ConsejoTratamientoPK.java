/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ConsejoTratamiento.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Carrillo
 */
@Embeddable
public class ConsejoTratamientoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tratamientosid_tratamiento")
    private int tratamientosidTratamiento;
    @Basic(optional = false)
    @Column(name = "id_consejos_tratamientos")
    private int idConsejosTratamientos;

    public ConsejoTratamientoPK() {
    }

    public ConsejoTratamientoPK(int tratamientosidTratamiento, int idConsejosTratamientos) {
        this.tratamientosidTratamiento = tratamientosidTratamiento;
        this.idConsejosTratamientos = idConsejosTratamientos;
    }

    public int getTratamientosidTratamiento() {
        return tratamientosidTratamiento;
    }

    public void setTratamientosidTratamiento(int tratamientosidTratamiento) {
        this.tratamientosidTratamiento = tratamientosidTratamiento;
    }

    public int getIdConsejosTratamientos() {
        return idConsejosTratamientos;
    }

    public void setIdConsejosTratamientos(int idConsejosTratamientos) {
        this.idConsejosTratamientos = idConsejosTratamientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tratamientosidTratamiento;
        hash += (int) idConsejosTratamientos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejoTratamientoPK)) {
            return false;
        }
        ConsejoTratamientoPK other = (ConsejoTratamientoPK) object;
        if (this.tratamientosidTratamiento != other.tratamientosidTratamiento) {
            return false;
        }
        if (this.idConsejosTratamientos != other.idConsejosTratamientos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultor.ConsejoTratamientoPK[ tratamientosidTratamiento=" + tratamientosidTratamiento + ", idConsejosTratamientos=" + idConsejosTratamientos + " ]";
    }
    
}

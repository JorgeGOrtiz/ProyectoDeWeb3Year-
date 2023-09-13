/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.Diagnostico.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class DiagnosticoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_diagnostico")
    private int idDiagnostico;
    @Basic(optional = false)
    @Column(name = "enfermedadesid_enfermedades")
    private int enfermedadesidEnfermedades;

    public DiagnosticoPK() {
    }

    public DiagnosticoPK(int idDiagnostico, int enfermedadesidEnfermedades) {
        this.idDiagnostico = idDiagnostico;
        this.enfermedadesidEnfermedades = enfermedadesidEnfermedades;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getEnfermedadesidEnfermedades() {
        return enfermedadesidEnfermedades;
    }

    public void setEnfermedadesidEnfermedades(int enfermedadesidEnfermedades) {
        this.enfermedadesidEnfermedades = enfermedadesidEnfermedades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDiagnostico;
        hash += (int) enfermedadesidEnfermedades;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoPK)) {
            return false;
        }
        DiagnosticoPK other = (DiagnosticoPK) object;
        if (this.idDiagnostico != other.idDiagnostico) {
            return false;
        }
        if (this.enfermedadesidEnfermedades != other.enfermedadesidEnfermedades) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.DiagnosticoPK[ idDiagnostico=" + idDiagnostico + ", enfermedadesidEnfermedades=" + enfermedadesidEnfermedades + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.Diagnostico.domain;

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
import cu.edu.unah.Proyectov1.Enfermedades.domain.Enfermedades;
/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "diagnostico", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByIdDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByEnfermedadesidEnfermedades", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.enfermedadesidEnfermedades = :enfermedadesidEnfermedades"),
    @NamedQuery(name = "Diagnostico.findByDescripcion", query = "SELECT d FROM Diagnostico d WHERE d.descripcion = :descripcion")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoPK diagnosticoPK;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "enfermedadesid_enfermedades", referencedColumnName = "id_enfermedades", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Enfermedades enfermedades;
    

    public Diagnostico() {
    }

    public Diagnostico(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    public Diagnostico(DiagnosticoPK diagnosticoPK, String descripcion) {
        this.diagnosticoPK = diagnosticoPK;
        this.descripcion = descripcion;
    }

    public Diagnostico(int idDiagnostico, int enfermedadesidEnfermedades) {
        this.diagnosticoPK = new DiagnosticoPK(idDiagnostico, enfermedadesidEnfermedades);
    }

    public DiagnosticoPK getDiagnosticoPK() {
        return diagnosticoPK;
    }

    public void setDiagnosticoPK(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Enfermedades getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Enfermedades enfermedades) {
        this.enfermedades = enfermedades;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoPK != null ? diagnosticoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.diagnosticoPK == null && other.diagnosticoPK != null) || (this.diagnosticoPK != null && !this.diagnosticoPK.equals(other.diagnosticoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Diagnostico[ diagnosticoPK=" + diagnosticoPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ConsejosPreventivos.domain;

import cu.edu.unah.Proyectov1.Prevencion.domain.Prevencion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "consejos_preventivos", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsejosPreventivos.findAll", query = "SELECT c FROM ConsejosPreventivos c"),
    @NamedQuery(name = "ConsejosPreventivos.findByIdConsejosPreventivos", query = "SELECT c FROM ConsejosPreventivos c WHERE c.idConsejosPreventivos = :idConsejosPreventivos"),
    @NamedQuery(name = "ConsejosPreventivos.findByConsejosPreventivosProfecional", query = "SELECT c FROM ConsejosPreventivos c WHERE c.consejosPreventivosProfecional = :consejosPreventivosProfecional")})
public class ConsejosPreventivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consejos_preventivos")
    private Integer idConsejosPreventivos;
    @Basic(optional = false)
    @Column(name = "consejos_preventivos_profecional")
    private String consejosPreventivosProfecional;
    @JoinTable(name = "consejos_preventivos_prevencion", joinColumns = {
        @JoinColumn(name = "consejos_preventivosid_consejos_preventivos", referencedColumnName = "id_consejos_preventivos")}, inverseJoinColumns = {
        @JoinColumn(name = "prevencionid_prevencion", referencedColumnName = "id_prevencion")})
    @ManyToMany
    private List<Prevencion> prevencionList;
  
    public ConsejosPreventivos() {
    }

    public ConsejosPreventivos(Integer idConsejosPreventivos) {
        this.idConsejosPreventivos = idConsejosPreventivos;
    }

    public ConsejosPreventivos(Integer idConsejosPreventivos, String consejosPreventivosProfecional) {
        this.idConsejosPreventivos = idConsejosPreventivos;
        this.consejosPreventivosProfecional = consejosPreventivosProfecional;
    }

    public Integer getIdConsejosPreventivos() {
        return idConsejosPreventivos;
    }

    public void setIdConsejosPreventivos(Integer idConsejosPreventivos) {
        this.idConsejosPreventivos = idConsejosPreventivos;
    }

    public String getConsejosPreventivosProfecional() {
        return consejosPreventivosProfecional;
    }

    public void setConsejosPreventivosProfecional(String consejosPreventivosProfecional) {
        this.consejosPreventivosProfecional = consejosPreventivosProfecional;
    }

    @XmlTransient
    public List<Prevencion> getPrevencionList() {
        return prevencionList;
    }

    public void setPrevencionList(List<Prevencion> prevencionList) {
        this.prevencionList = prevencionList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsejosPreventivos != null ? idConsejosPreventivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejosPreventivos)) {
            return false;
        }
        ConsejosPreventivos other = (ConsejosPreventivos) object;
        if ((this.idConsejosPreventivos == null && other.idConsejosPreventivos != null) || (this.idConsejosPreventivos != null && !this.idConsejosPreventivos.equals(other.idConsejosPreventivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ConsejosPreventivos[ idConsejosPreventivos=" + idConsejosPreventivos + " ]";
    }
    
}

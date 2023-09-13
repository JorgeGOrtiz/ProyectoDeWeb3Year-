/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.Enfermedades.domain;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
import cu.edu.unah.Proyectov1.Prevencion.domain.Prevencion;
import cu.edu.unah.Proyectov1.Tratamientos.domain.Tratamientos;
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
@Table(name = "enfermedades", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedades.findAll", query = "SELECT e FROM Enfermedades e"),
    @NamedQuery(name = "Enfermedades.findByIdEnfermedades", query = "SELECT e FROM Enfermedades e WHERE e.idEnfermedades = :idEnfermedades"),
    @NamedQuery(name = "Enfermedades.findByTipoEnfermedades", query = "SELECT e FROM Enfermedades e WHERE e.tipoEnfermedades = :tipoEnfermedades"),
    @NamedQuery(name = "Enfermedades.findByNombreEnfermedades", query = "SELECT e FROM Enfermedades e WHERE e.nombreEnfermedades = :nombreEnfermedades"),
    @NamedQuery(name = "Enfermedades.findByAgenteEtiologico", query = "SELECT e FROM Enfermedades e WHERE e.agenteEtiologico = :agenteEtiologico"),
    @NamedQuery(name = "Enfermedades.findByPatogenia", query = "SELECT e FROM Enfermedades e WHERE e.patogenia = :patogenia")})
public class Enfermedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enfermedades")
    private Integer idEnfermedades;
    @Basic(optional = false)
    @Column(name = "tipo_enfermedades")
    private String tipoEnfermedades;
    @Basic(optional = false)
    @Column(name = "nombre_enfermedades")
    private String nombreEnfermedades;
    @Basic(optional = false)
    @Column(name = "agente_etiologico")
    private String agenteEtiologico;
    @Basic(optional = false)
    @Column(name = "patogenia")
    private String patogenia;
    @JoinTable(name = "enfermedades_prevencion", joinColumns = {
        @JoinColumn(name = "enfermedadesid_enfermedades", referencedColumnName = "id_enfermedades")}, inverseJoinColumns = {
        @JoinColumn(name = "prevencionid_prevencion", referencedColumnName = "id_prevencion")})
    @ManyToMany
    private List<Prevencion> prevencionList;
    @JoinTable(name = "enfermedades_tratamientos", joinColumns = {
        @JoinColumn(name = "enfermedadesid_enfermedades", referencedColumnName = "id_enfermedades")}, inverseJoinColumns = {
        @JoinColumn(name = "tratamientosid_tratamiento", referencedColumnName = "id_tratamiento")})
    @ManyToMany
    private List<Tratamientos> tratamientosList;
    @JoinTable(name = "animal_enfermedades", joinColumns = {
        @JoinColumn(name = "enfermedadesid_enfermedades", referencedColumnName = "id_enfermedades")}, inverseJoinColumns = {
        @JoinColumn(name = "animalid_animal", referencedColumnName = "id_animal"),
        @JoinColumn(name = "animalrazaid_raza", referencedColumnName = "razaid_raza"),
        @JoinColumn(name = "animalrazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal"),
        @JoinColumn(name = "animalrazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal")})
    @ManyToMany
    private List<Animal> animalList;
   

    public Enfermedades() {
    }

    public Enfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public Enfermedades(Integer idEnfermedades, String tipoEnfermedades, String nombreEnfermedades, String agenteEtiologico, String patogenia) {
        this.idEnfermedades = idEnfermedades;
        this.tipoEnfermedades = tipoEnfermedades;
        this.nombreEnfermedades = nombreEnfermedades;
        this.agenteEtiologico = agenteEtiologico;
        this.patogenia = patogenia;
    }

    public Integer getIdEnfermedades() {
        return idEnfermedades;
    }

    public void setIdEnfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public String getTipoEnfermedades() {
        return tipoEnfermedades;
    }

    public void setTipoEnfermedades(String tipoEnfermedades) {
        this.tipoEnfermedades = tipoEnfermedades;
    }

    public String getNombreEnfermedades() {
        return nombreEnfermedades;
    }

    public void setNombreEnfermedades(String nombreEnfermedades) {
        this.nombreEnfermedades = nombreEnfermedades;
    }

    public String getAgenteEtiologico() {
        return agenteEtiologico;
    }

    public void setAgenteEtiologico(String agenteEtiologico) {
        this.agenteEtiologico = agenteEtiologico;
    }

    public String getPatogenia() {
        return patogenia;
    }

    public void setPatogenia(String patogenia) {
        this.patogenia = patogenia;
    }

    @XmlTransient
    public List<Prevencion> getPrevencionList() {
        return prevencionList;
    }

    public void setPrevencionList(List<Prevencion> prevencionList) {
        this.prevencionList = prevencionList;
    }

    @XmlTransient
    public List<Tratamientos> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Tratamientos> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfermedades != null ? idEnfermedades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.idEnfermedades == null && other.idEnfermedades != null) || (this.idEnfermedades != null && !this.idEnfermedades.equals(other.idEnfermedades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Enfermedades[ idEnfermedades=" + idEnfermedades + " ]";
    }
    
}

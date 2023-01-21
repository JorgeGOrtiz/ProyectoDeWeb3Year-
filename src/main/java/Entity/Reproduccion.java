/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "reproduccion", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Reproduccion.findAll", query = "SELECT r FROM Reproduccion r"),
    @NamedQuery(name = "Reproduccion.findByIdReproduccion", query = "SELECT r FROM Reproduccion r WHERE r.reproduccionPK.idReproduccion = :idReproduccion"),
    @NamedQuery(name = "Reproduccion.findByEspecieanimalidEspecieAnimal", query = "SELECT r FROM Reproduccion r WHERE r.reproduccionPK.especieanimalidEspecieAnimal = :especieanimalidEspecieAnimal"),
    @NamedQuery(name = "Reproduccion.findByEspecieanimalgrupoanimalidGrupoAnimal", query = "SELECT r FROM Reproduccion r WHERE r.reproduccionPK.especieanimalgrupoanimalidGrupoAnimal = :especieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "Reproduccion.findByEtepaDeApareamiento", query = "SELECT r FROM Reproduccion r WHERE r.etepaDeApareamiento = :etepaDeApareamiento"),
    @NamedQuery(name = "Reproduccion.findByDuracionEtepaDeApareamiento", query = "SELECT r FROM Reproduccion r WHERE r.duracionEtepaDeApareamiento = :duracionEtepaDeApareamiento"),
    @NamedQuery(name = "Reproduccion.findByDuracionPeriodoDeGestaion", query = "SELECT r FROM Reproduccion r WHERE r.duracionPeriodoDeGestaion = :duracionPeriodoDeGestaion")})
public class Reproduccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReproduccionPK reproduccionPK;
    @Basic(optional = false)
    @Column(name = "etepa_de_apareamiento")
    private String etepaDeApareamiento;
    @Basic(optional = false)
    @Column(name = "duracion_etepa_de_apareamiento")
    private String duracionEtepaDeApareamiento;
    @Basic(optional = false)
    @Column(name = "duracion_periodo_de_gestaion")
    private String duracionPeriodoDeGestaion;
    @JoinColumns({
        @JoinColumn(name = "especieanimalid_especie_animal", referencedColumnName = "id_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "especieanimalgrupoanimalid_grupo_animal", referencedColumnName = "grupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Especieanimal especieanimal;

    public Reproduccion() {
    }

    public Reproduccion(ReproduccionPK reproduccionPK) {
        this.reproduccionPK = reproduccionPK;
    }

    public Reproduccion(ReproduccionPK reproduccionPK, String etepaDeApareamiento, String duracionEtepaDeApareamiento, String duracionPeriodoDeGestaion) {
        this.reproduccionPK = reproduccionPK;
        this.etepaDeApareamiento = etepaDeApareamiento;
        this.duracionEtepaDeApareamiento = duracionEtepaDeApareamiento;
        this.duracionPeriodoDeGestaion = duracionPeriodoDeGestaion;
    }

    public Reproduccion(int idReproduccion, int especieanimalidEspecieAnimal, int especieanimalgrupoanimalidGrupoAnimal) {
        this.reproduccionPK = new ReproduccionPK(idReproduccion, especieanimalidEspecieAnimal, especieanimalgrupoanimalidGrupoAnimal);
    }

    public ReproduccionPK getReproduccionPK() {
        return reproduccionPK;
    }

    public void setReproduccionPK(ReproduccionPK reproduccionPK) {
        this.reproduccionPK = reproduccionPK;
    }

    public String getEtepaDeApareamiento() {
        return etepaDeApareamiento;
    }

    public void setEtepaDeApareamiento(String etepaDeApareamiento) {
        this.etepaDeApareamiento = etepaDeApareamiento;
    }

    public String getDuracionEtepaDeApareamiento() {
        return duracionEtepaDeApareamiento;
    }

    public void setDuracionEtepaDeApareamiento(String duracionEtepaDeApareamiento) {
        this.duracionEtepaDeApareamiento = duracionEtepaDeApareamiento;
    }

    public String getDuracionPeriodoDeGestaion() {
        return duracionPeriodoDeGestaion;
    }

    public void setDuracionPeriodoDeGestaion(String duracionPeriodoDeGestaion) {
        this.duracionPeriodoDeGestaion = duracionPeriodoDeGestaion;
    }

    public Especieanimal getEspecieanimal() {
        return especieanimal;
    }

    public void setEspecieanimal(Especieanimal especieanimal) {
        this.especieanimal = especieanimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reproduccionPK != null ? reproduccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reproduccion)) {
            return false;
        }
        Reproduccion other = (Reproduccion) object;
        if ((this.reproduccionPK == null && other.reproduccionPK != null) || (this.reproduccionPK != null && !this.reproduccionPK.equals(other.reproduccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.Reproduccion[ reproduccionPK=" + reproduccionPK + " ]";
    }
    
}

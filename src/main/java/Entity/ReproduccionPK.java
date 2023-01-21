/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carrillo
 */
@Embeddable
public class ReproduccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_reproduccion")
    private int idReproduccion;
    @Basic(optional = false)
    @Column(name = "especieanimalid_especie_animal")
    private int especieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "especieanimalgrupoanimalid_grupo_animal")
    private int especieanimalgrupoanimalidGrupoAnimal;

    public ReproduccionPK() {
    }

    public ReproduccionPK(int idReproduccion, int especieanimalidEspecieAnimal, int especieanimalgrupoanimalidGrupoAnimal) {
        this.idReproduccion = idReproduccion;
        this.especieanimalidEspecieAnimal = especieanimalidEspecieAnimal;
        this.especieanimalgrupoanimalidGrupoAnimal = especieanimalgrupoanimalidGrupoAnimal;
    }

    public int getIdReproduccion() {
        return idReproduccion;
    }

    public void setIdReproduccion(int idReproduccion) {
        this.idReproduccion = idReproduccion;
    }

    public int getEspecieanimalidEspecieAnimal() {
        return especieanimalidEspecieAnimal;
    }

    public void setEspecieanimalidEspecieAnimal(int especieanimalidEspecieAnimal) {
        this.especieanimalidEspecieAnimal = especieanimalidEspecieAnimal;
    }

    public int getEspecieanimalgrupoanimalidGrupoAnimal() {
        return especieanimalgrupoanimalidGrupoAnimal;
    }

    public void setEspecieanimalgrupoanimalidGrupoAnimal(int especieanimalgrupoanimalidGrupoAnimal) {
        this.especieanimalgrupoanimalidGrupoAnimal = especieanimalgrupoanimalidGrupoAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReproduccion;
        hash += (int) especieanimalidEspecieAnimal;
        hash += (int) especieanimalgrupoanimalidGrupoAnimal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReproduccionPK)) {
            return false;
        }
        ReproduccionPK other = (ReproduccionPK) object;
        if (this.idReproduccion != other.idReproduccion) {
            return false;
        }
        if (this.especieanimalidEspecieAnimal != other.especieanimalidEspecieAnimal) {
            return false;
        }
        if (this.especieanimalgrupoanimalidGrupoAnimal != other.especieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.ReproduccionPK[ idReproduccion=" + idReproduccion + ", especieanimalidEspecieAnimal=" + especieanimalidEspecieAnimal + ", especieanimalgrupoanimalidGrupoAnimal=" + especieanimalgrupoanimalidGrupoAnimal + " ]";
    }
    
}

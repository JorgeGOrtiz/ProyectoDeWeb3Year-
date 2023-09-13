/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.EspecieAnimal.domian;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class EspecieanimalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_especie_animal")
    private int idEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "grupoanimalid_grupo_animal")
    private int grupoanimalidGrupoAnimal;

    public EspecieanimalPK() {
    }

    public EspecieanimalPK(int idEspecieAnimal, int grupoanimalidGrupoAnimal) {
        this.idEspecieAnimal = idEspecieAnimal;
        this.grupoanimalidGrupoAnimal = grupoanimalidGrupoAnimal;
    }

    public int getIdEspecieAnimal() {
        return idEspecieAnimal;
    }

    public void setIdEspecieAnimal(int idEspecieAnimal) {
        this.idEspecieAnimal = idEspecieAnimal;
    }

    public int getGrupoanimalidGrupoAnimal() {
        return grupoanimalidGrupoAnimal;
    }

    public void setGrupoanimalidGrupoAnimal(int grupoanimalidGrupoAnimal) {
        this.grupoanimalidGrupoAnimal = grupoanimalidGrupoAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEspecieAnimal;
        hash += (int) grupoanimalidGrupoAnimal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecieanimalPK)) {
            return false;
        }
        EspecieanimalPK other = (EspecieanimalPK) object;
        if (this.idEspecieAnimal != other.idEspecieAnimal) {
            return false;
        }
        if (this.grupoanimalidGrupoAnimal != other.grupoanimalidGrupoAnimal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.EspecieanimalPK[ idEspecieAnimal=" + idEspecieAnimal + ", grupoanimalidGrupoAnimal=" + grupoanimalidGrupoAnimal + " ]";
    }
    
}

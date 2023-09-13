/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.Animal.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class AnimalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_animal")
    private int idAnimal;
    @Basic(optional = false)
    @Column(name = "razaid_raza")
    private int razaidRaza;
    @Basic(optional = false)
    @Column(name = "razaespecieanimalid_especie_animal")
    private int razaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "razaespecieanimalgrupoanimalid_grupo_animal")
    private int razaespecieanimalgrupoanimalidGrupoAnimal;

    public AnimalPK() {
    }

    public AnimalPK(int idAnimal, int razaidRaza, int razaespecieanimalidEspecieAnimal, int razaespecieanimalgrupoanimalidGrupoAnimal) {
        this.idAnimal = idAnimal;
        this.razaidRaza = razaidRaza;
        this.razaespecieanimalidEspecieAnimal = razaespecieanimalidEspecieAnimal;
        this.razaespecieanimalgrupoanimalidGrupoAnimal = razaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getRazaidRaza() {
        return razaidRaza;
    }

    public void setRazaidRaza(int razaidRaza) {
        this.razaidRaza = razaidRaza;
    }

    public int getRazaespecieanimalidEspecieAnimal() {
        return razaespecieanimalidEspecieAnimal;
    }

    public void setRazaespecieanimalidEspecieAnimal(int razaespecieanimalidEspecieAnimal) {
        this.razaespecieanimalidEspecieAnimal = razaespecieanimalidEspecieAnimal;
    }

    public int getRazaespecieanimalgrupoanimalidGrupoAnimal() {
        return razaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public void setRazaespecieanimalgrupoanimalidGrupoAnimal(int razaespecieanimalgrupoanimalidGrupoAnimal) {
        this.razaespecieanimalgrupoanimalidGrupoAnimal = razaespecieanimalgrupoanimalidGrupoAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnimal;
        hash += (int) razaidRaza;
        hash += (int) razaespecieanimalidEspecieAnimal;
        hash += (int) razaespecieanimalgrupoanimalidGrupoAnimal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalPK)) {
            return false;
        }
        AnimalPK other = (AnimalPK) object;
        if (this.idAnimal != other.idAnimal) {
            return false;
        }
        if (this.razaidRaza != other.razaidRaza) {
            return false;
        }
        if (this.razaespecieanimalidEspecieAnimal != other.razaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.razaespecieanimalgrupoanimalidGrupoAnimal != other.razaespecieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.AnimalPK[ idAnimal=" + idAnimal + ", razaidRaza=" + razaidRaza + ", razaespecieanimalidEspecieAnimal=" + razaespecieanimalidEspecieAnimal + ", razaespecieanimalgrupoanimalidGrupoAnimal=" + razaespecieanimalgrupoanimalidGrupoAnimal + " ]";
    }
    
}

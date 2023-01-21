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
 * @author Ashi
 */
@Embeddable
public class EtapaCrianzaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "razaid_raza")
    private int razaidRaza;
    @Basic(optional = false)
    @Column(name = "razaespecieanimalid_especie_animal")
    private int razaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "razaespecieanimalgrupoanimalid_grupo_animal")
    private int razaespecieanimalgrupoanimalidGrupoAnimal;
    @Basic(optional = false)
    @Column(name = "id_etapa_crianza")
    private int idEtapaCrianza;

    public EtapaCrianzaPK() {
    }

    public EtapaCrianzaPK(int razaidRaza, int razaespecieanimalidEspecieAnimal, int razaespecieanimalgrupoanimalidGrupoAnimal, int idEtapaCrianza) {
        this.razaidRaza = razaidRaza;
        this.razaespecieanimalidEspecieAnimal = razaespecieanimalidEspecieAnimal;
        this.razaespecieanimalgrupoanimalidGrupoAnimal = razaespecieanimalgrupoanimalidGrupoAnimal;
        this.idEtapaCrianza = idEtapaCrianza;
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

    public int getIdEtapaCrianza() {
        return idEtapaCrianza;
    }

    public void setIdEtapaCrianza(int idEtapaCrianza) {
        this.idEtapaCrianza = idEtapaCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) razaidRaza;
        hash += (int) razaespecieanimalidEspecieAnimal;
        hash += (int) razaespecieanimalgrupoanimalidGrupoAnimal;
        hash += (int) idEtapaCrianza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaCrianzaPK)) {
            return false;
        }
        EtapaCrianzaPK other = (EtapaCrianzaPK) object;
        if (this.razaidRaza != other.razaidRaza) {
            return false;
        }
        if (this.razaespecieanimalidEspecieAnimal != other.razaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.razaespecieanimalgrupoanimalidGrupoAnimal != other.razaespecieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        if (this.idEtapaCrianza != other.idEtapaCrianza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.EtapaCrianzaPK[ razaidRaza=" + razaidRaza + ", razaespecieanimalidEspecieAnimal=" + razaespecieanimalidEspecieAnimal + ", razaespecieanimalgrupoanimalidGrupoAnimal=" + razaespecieanimalgrupoanimalidGrupoAnimal + ", idEtapaCrianza=" + idEtapaCrianza + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class ConsejoAlimentacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_alimentacion")
    private int idAlimentacion;
    @Basic(optional = false)
    @Column(name = "alimentacionetapa_crianzarazaid_raza")
    private int alimentacionetapaCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "alimentacionetapa_crianzarazaespecieanimalid_especie_animal")
    private int alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "alimentacionetapa_crianzarazaespecieanimalgrupoanimalid_grupo_a")
    private int alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA;
    @Basic(optional = false)
    @Column(name = "alimentacionetapa_crianzaid_etapa_crianza")
    private int alimentacionetapaCrianzaidEtapaCrianza;
    @Basic(optional = false)
    @Column(name = "alimentacionid_alimentacion")
    private int alimentacionidAlimentacion;

    public ConsejoAlimentacionPK() {
    }

    public ConsejoAlimentacionPK(int idAlimentacion, int alimentacionetapaCrianzarazaidRaza, int alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal, int alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA, int alimentacionetapaCrianzaidEtapaCrianza, int alimentacionidAlimentacion) {
        this.idAlimentacion = idAlimentacion;
        this.alimentacionetapaCrianzarazaidRaza = alimentacionetapaCrianzarazaidRaza;
        this.alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal = alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal;
        this.alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA = alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA;
        this.alimentacionetapaCrianzaidEtapaCrianza = alimentacionetapaCrianzaidEtapaCrianza;
        this.alimentacionidAlimentacion = alimentacionidAlimentacion;
    }

    public int getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(int idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    public int getAlimentacionetapaCrianzarazaidRaza() {
        return alimentacionetapaCrianzarazaidRaza;
    }

    public void setAlimentacionetapaCrianzarazaidRaza(int alimentacionetapaCrianzarazaidRaza) {
        this.alimentacionetapaCrianzarazaidRaza = alimentacionetapaCrianzarazaidRaza;
    }

    public int getAlimentacionetapaCrianzarazaespecieanimalidEspecieAnimal() {
        return alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public void setAlimentacionetapaCrianzarazaespecieanimalidEspecieAnimal(int alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal) {
        this.alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal = alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public int getAlimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA() {
        return alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA;
    }

    public void setAlimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA(int alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA) {
        this.alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA = alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA;
    }

    public int getAlimentacionetapaCrianzaidEtapaCrianza() {
        return alimentacionetapaCrianzaidEtapaCrianza;
    }

    public void setAlimentacionetapaCrianzaidEtapaCrianza(int alimentacionetapaCrianzaidEtapaCrianza) {
        this.alimentacionetapaCrianzaidEtapaCrianza = alimentacionetapaCrianzaidEtapaCrianza;
    }

    public int getAlimentacionidAlimentacion() {
        return alimentacionidAlimentacion;
    }

    public void setAlimentacionidAlimentacion(int alimentacionidAlimentacion) {
        this.alimentacionidAlimentacion = alimentacionidAlimentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlimentacion;
        hash += (int) alimentacionetapaCrianzarazaidRaza;
        hash += (int) alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal;
        hash += (int) alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA;
        hash += (int) alimentacionetapaCrianzaidEtapaCrianza;
        hash += (int) alimentacionidAlimentacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejoAlimentacionPK)) {
            return false;
        }
        ConsejoAlimentacionPK other = (ConsejoAlimentacionPK) object;
        if (this.idAlimentacion != other.idAlimentacion) {
            return false;
        }
        if (this.alimentacionetapaCrianzarazaidRaza != other.alimentacionetapaCrianzarazaidRaza) {
            return false;
        }
        if (this.alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal != other.alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA != other.alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA) {
            return false;
        }
        if (this.alimentacionetapaCrianzaidEtapaCrianza != other.alimentacionetapaCrianzaidEtapaCrianza) {
            return false;
        }
        if (this.alimentacionidAlimentacion != other.alimentacionidAlimentacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ConsejoAlimentacionPK[ idAlimentacion=" + idAlimentacion + ", alimentacionetapaCrianzarazaidRaza=" + alimentacionetapaCrianzarazaidRaza + ", alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal=" + alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal + ", alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA=" + alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA + ", alimentacionetapaCrianzaidEtapaCrianza=" + alimentacionetapaCrianzaidEtapaCrianza + ", alimentacionidAlimentacion=" + alimentacionidAlimentacion + " ]";
    }
    
}

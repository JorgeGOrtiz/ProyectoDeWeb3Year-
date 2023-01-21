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
public class MedicionYPesoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_medicion_y_peso")
    private int idMedicionYPeso;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaid_raza")
    private int etapaCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaespecieanimalid_especie_animal")
    private int etapaCrianzarazaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal")
    private int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    @Basic(optional = false)
    @Column(name = "etapa_crianzaid_etapa_crianza")
    private int etapaCrianzaidEtapaCrianza;

    public MedicionYPesoPK() {
    }

    public MedicionYPesoPK(int idMedicionYPeso, int etapaCrianzarazaidRaza, int etapaCrianzarazaespecieanimalidEspecieAnimal, int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzaidEtapaCrianza) {
        this.idMedicionYPeso = idMedicionYPeso;
        this.etapaCrianzarazaidRaza = etapaCrianzarazaidRaza;
        this.etapaCrianzarazaespecieanimalidEspecieAnimal = etapaCrianzarazaespecieanimalidEspecieAnimal;
        this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        this.etapaCrianzaidEtapaCrianza = etapaCrianzaidEtapaCrianza;
    }

    public int getIdMedicionYPeso() {
        return idMedicionYPeso;
    }

    public void setIdMedicionYPeso(int idMedicionYPeso) {
        this.idMedicionYPeso = idMedicionYPeso;
    }

    public int getEtapaCrianzarazaidRaza() {
        return etapaCrianzarazaidRaza;
    }

    public void setEtapaCrianzarazaidRaza(int etapaCrianzarazaidRaza) {
        this.etapaCrianzarazaidRaza = etapaCrianzarazaidRaza;
    }

    public int getEtapaCrianzarazaespecieanimalidEspecieAnimal() {
        return etapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public void setEtapaCrianzarazaespecieanimalidEspecieAnimal(int etapaCrianzarazaespecieanimalidEspecieAnimal) {
        this.etapaCrianzarazaespecieanimalidEspecieAnimal = etapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public int getEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal() {
        return etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public void setEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal(int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
        this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public int getEtapaCrianzaidEtapaCrianza() {
        return etapaCrianzaidEtapaCrianza;
    }

    public void setEtapaCrianzaidEtapaCrianza(int etapaCrianzaidEtapaCrianza) {
        this.etapaCrianzaidEtapaCrianza = etapaCrianzaidEtapaCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMedicionYPeso;
        hash += (int) etapaCrianzarazaidRaza;
        hash += (int) etapaCrianzarazaespecieanimalidEspecieAnimal;
        hash += (int) etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        hash += (int) etapaCrianzaidEtapaCrianza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicionYPesoPK)) {
            return false;
        }
        MedicionYPesoPK other = (MedicionYPesoPK) object;
        if (this.idMedicionYPeso != other.idMedicionYPeso) {
            return false;
        }
        if (this.etapaCrianzarazaidRaza != other.etapaCrianzarazaidRaza) {
            return false;
        }
        if (this.etapaCrianzarazaespecieanimalidEspecieAnimal != other.etapaCrianzarazaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal != other.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        if (this.etapaCrianzaidEtapaCrianza != other.etapaCrianzaidEtapaCrianza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.MedicionYPesoPK[ idMedicionYPeso=" + idMedicionYPeso + ", etapaCrianzarazaidRaza=" + etapaCrianzarazaidRaza + ", etapaCrianzarazaespecieanimalidEspecieAnimal=" + etapaCrianzarazaespecieanimalidEspecieAnimal + ", etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal=" + etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal + ", etapaCrianzaidEtapaCrianza=" + etapaCrianzaidEtapaCrianza + " ]";
    }
    
}

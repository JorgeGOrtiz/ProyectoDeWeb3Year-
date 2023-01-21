/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.*;
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
@Entity
@Table(name = "medicion_y_peso", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "MedicionYPeso.findAll", query = "SELECT m FROM MedicionYPeso m"),
    @NamedQuery(name = "MedicionYPeso.findByIdMedicionYPeso", query = "SELECT m FROM MedicionYPeso m WHERE m.medicionYPesoPK.idMedicionYPeso = :idMedicionYPeso"),
    @NamedQuery(name = "MedicionYPeso.findByRangoDePesoIdeal", query = "SELECT m FROM MedicionYPeso m WHERE m.rangoDePesoIdeal = :rangoDePesoIdeal"),
    @NamedQuery(name = "MedicionYPeso.findByRangoDeTamannoIdeal", query = "SELECT m FROM MedicionYPeso m WHERE m.rangoDeTamannoIdeal = :rangoDeTamannoIdeal"),
    @NamedQuery(name = "MedicionYPeso.findByEtapaCrianzarazaidRaza", query = "SELECT m FROM MedicionYPeso m WHERE m.medicionYPesoPK.etapaCrianzarazaidRaza = :etapaCrianzarazaidRaza"),
    @NamedQuery(name = "MedicionYPeso.findByEtapaCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT m FROM MedicionYPeso m WHERE m.medicionYPesoPK.etapaCrianzarazaespecieanimalidEspecieAnimal = :etapaCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "MedicionYPeso.findByEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT m FROM MedicionYPeso m WHERE m.medicionYPesoPK.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = :etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "MedicionYPeso.findByEtapaCrianzaidEtapaCrianza", query = "SELECT m FROM MedicionYPeso m WHERE m.medicionYPesoPK.etapaCrianzaidEtapaCrianza = :etapaCrianzaidEtapaCrianza")})
public class MedicionYPeso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicionYPesoPK medicionYPesoPK;
    @Basic(optional = false)
    @Column(name = "rango_de_peso_ideal")
    private String rangoDePesoIdeal;
    @Basic(optional = false)
    @Column(name = "rango_de_tamanno_ideal")
    private String rangoDeTamannoIdeal;
    
    @JoinColumns({
        @JoinColumn(name = "etapa_crianzarazaid_raza", referencedColumnName = "razaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzaid_etapa_crianza", referencedColumnName = "id_etapa_crianza", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EtapaCrianza etapaCrianza;

    public MedicionYPeso() {
    }

    public MedicionYPeso(MedicionYPesoPK medicionYPesoPK) {
        this.medicionYPesoPK = medicionYPesoPK;
    }

    public MedicionYPeso(MedicionYPesoPK medicionYPesoPK, String rangoDePesoIdeal, String rangoDeTamannoIdeal) {
        this.medicionYPesoPK = medicionYPesoPK;
        this.rangoDePesoIdeal = rangoDePesoIdeal;
        this.rangoDeTamannoIdeal = rangoDeTamannoIdeal;
    }

    public MedicionYPeso(int idMedicionYPeso, int etapaCrianzarazaidRaza, int etapaCrianzarazaespecieanimalidEspecieAnimal, int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzaidEtapaCrianza) {
        this.medicionYPesoPK = new MedicionYPesoPK(idMedicionYPeso, etapaCrianzarazaidRaza, etapaCrianzarazaespecieanimalidEspecieAnimal, etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, etapaCrianzaidEtapaCrianza);
    }

    public MedicionYPesoPK getMedicionYPesoPK() {
        return medicionYPesoPK;
    }

    public void setMedicionYPesoPK(MedicionYPesoPK medicionYPesoPK) {
        this.medicionYPesoPK = medicionYPesoPK;
    }

    public String getRangoDePesoIdeal() {
        return rangoDePesoIdeal;
    }

    public void setRangoDePesoIdeal(String rangoDePesoIdeal) {
        this.rangoDePesoIdeal = rangoDePesoIdeal;
    }

    public String getRangoDeTamannoIdeal() {
        return rangoDeTamannoIdeal;
    }

    public void setRangoDeTamannoIdeal(String rangoDeTamannoIdeal) {
        this.rangoDeTamannoIdeal = rangoDeTamannoIdeal;
    }

   

    public EtapaCrianza getEtapaCrianza() {
        return etapaCrianza;
    }

    public void setEtapaCrianza(EtapaCrianza etapaCrianza) {
        this.etapaCrianza = etapaCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicionYPesoPK != null ? medicionYPesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicionYPeso)) {
            return false;
        }
        MedicionYPeso other = (MedicionYPeso) object;
        if ((this.medicionYPesoPK == null && other.medicionYPesoPK != null) || (this.medicionYPesoPK != null && !this.medicionYPesoPK.equals(other.medicionYPesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.MedicionYPeso[ medicionYPesoPK=" + medicionYPesoPK + " ]";
    }
    
}

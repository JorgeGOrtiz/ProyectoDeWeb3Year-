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
@Table(name = "etapa_crianza", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "EtapaCrianza.findAll", query = "SELECT e FROM EtapaCrianza e"),
    @NamedQuery(name = "EtapaCrianza.findByRazaidRaza", query = "SELECT e FROM EtapaCrianza e WHERE e.etapaCrianzaPK.razaidRaza = :razaidRaza"),
    @NamedQuery(name = "EtapaCrianza.findByRazaespecieanimalidEspecieAnimal", query = "SELECT e FROM EtapaCrianza e WHERE e.etapaCrianzaPK.razaespecieanimalidEspecieAnimal = :razaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "EtapaCrianza.findByRazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT e FROM EtapaCrianza e WHERE e.etapaCrianzaPK.razaespecieanimalgrupoanimalidGrupoAnimal = :razaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "EtapaCrianza.findByIdEtapaCrianza", query = "SELECT e FROM EtapaCrianza e WHERE e.etapaCrianzaPK.idEtapaCrianza = :idEtapaCrianza"),
    @NamedQuery(name = "EtapaCrianza.findByNombreEtapaCrianza", query = "SELECT e FROM EtapaCrianza e WHERE e.nombreEtapaCrianza = :nombreEtapaCrianza")})
public class EtapaCrianza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EtapaCrianzaPK etapaCrianzaPK;
    @Basic(optional = false)
    @Column(name = "nombre_etapa_crianza")
    private String nombreEtapaCrianza;
    @JoinColumns({
        @JoinColumn(name = "razaid_raza", referencedColumnName = "id_raza", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalid_especie_animal", referencedColumnName = "especieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "especieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Raza raza;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaCrianza")
  //  private List<MedicionYPeso> medicionYPesoList;
   

    public EtapaCrianza() {
    }

    public EtapaCrianza(EtapaCrianzaPK etapaCrianzaPK) {
        this.etapaCrianzaPK = etapaCrianzaPK;
    }

    public EtapaCrianza(EtapaCrianzaPK etapaCrianzaPK, String nombreEtapaCrianza) {
        this.etapaCrianzaPK = etapaCrianzaPK;
        this.nombreEtapaCrianza = nombreEtapaCrianza;
    }

    public EtapaCrianza(int razaidRaza, int razaespecieanimalidEspecieAnimal, int razaespecieanimalgrupoanimalidGrupoAnimal, int idEtapaCrianza) {
        this.etapaCrianzaPK = new EtapaCrianzaPK(razaidRaza, razaespecieanimalidEspecieAnimal, razaespecieanimalgrupoanimalidGrupoAnimal, idEtapaCrianza);
    }

    public EtapaCrianzaPK getEtapaCrianzaPK() {
        return etapaCrianzaPK;
    }

    public void setEtapaCrianzaPK(EtapaCrianzaPK etapaCrianzaPK) {
        this.etapaCrianzaPK = etapaCrianzaPK;
    }

    public String getNombreEtapaCrianza() {
        return nombreEtapaCrianza;
    }

    public void setNombreEtapaCrianza(String nombreEtapaCrianza) {
        this.nombreEtapaCrianza = nombreEtapaCrianza;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

  //  @XmlTransient
    //public List<MedicionYPeso> getMedicionYPesoList() {
     //   return medicionYPesoList;
    //}

    //public void setMedicionYPesoList(List<MedicionYPeso> medicionYPesoList) {
     //   this.medicionYPesoList = medicionYPesoList;
   // }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etapaCrianzaPK != null ? etapaCrianzaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaCrianza)) {
            return false;
        }
        EtapaCrianza other = (EtapaCrianza) object;
        if ((this.etapaCrianzaPK == null && other.etapaCrianzaPK != null) || (this.etapaCrianzaPK != null && !this.etapaCrianzaPK.equals(other.etapaCrianzaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.EtapaCrianza[ etapaCrianzaPK=" + etapaCrianzaPK + " ]";
    }
    
}

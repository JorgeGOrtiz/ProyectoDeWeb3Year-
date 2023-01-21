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
@Table(name = "alimentacion", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Alimentacion.findAll", query = "SELECT a FROM Alimentacion a"),
    @NamedQuery(name = "Alimentacion.findByEtapaCrianzarazaidRaza", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPK.etapaCrianzarazaidRaza = :etapaCrianzarazaidRaza"),
    @NamedQuery(name = "Alimentacion.findByEtapaCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPK.etapaCrianzarazaespecieanimalidEspecieAnimal = :etapaCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "Alimentacion.findByEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPK.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = :etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "Alimentacion.findByEtapaCrianzaidEtapaCrianza", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPK.etapaCrianzaidEtapaCrianza = :etapaCrianzaidEtapaCrianza"),
    @NamedQuery(name = "Alimentacion.findByIdAlimentacion", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPK.idAlimentacion = :idAlimentacion"),
    @NamedQuery(name = "Alimentacion.findByNombreAlimentacion", query = "SELECT a FROM Alimentacion a WHERE a.nombreAlimentacion = :nombreAlimentacion"),
    @NamedQuery(name = "Alimentacion.findByAlimentacionPorEtapas", query = "SELECT a FROM Alimentacion a WHERE a.alimentacionPorEtapas = :alimentacionPorEtapas")})
public class Alimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlimentacionPK alimentacionPK;
    @Basic(optional = false)
    @Column(name = "nombre_alimentacion")
    private String nombreAlimentacion;
    @Column(name = "alimentacion_por_etapas")
    private String alimentacionPorEtapas;
    @JoinColumns({
        @JoinColumn(name = "etapa_crianzarazaid_raza", referencedColumnName = "razaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzaid_etapa_crianza", referencedColumnName = "id_etapa_crianza", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EtapaCrianza etapaCrianza;
    

    public Alimentacion() {
    }

    public Alimentacion(AlimentacionPK alimentacionPK) {
        this.alimentacionPK = alimentacionPK;
    }

    public Alimentacion(AlimentacionPK alimentacionPK, String nombreAlimentacion) {
        this.alimentacionPK = alimentacionPK;
        this.nombreAlimentacion = nombreAlimentacion;
    }

    public Alimentacion(int etapaCrianzarazaidRaza, int etapaCrianzarazaespecieanimalidEspecieAnimal, int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzaidEtapaCrianza, int idAlimentacion) {
        this.alimentacionPK = new AlimentacionPK(etapaCrianzarazaidRaza, etapaCrianzarazaespecieanimalidEspecieAnimal, etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, etapaCrianzaidEtapaCrianza, idAlimentacion);
    }

    public AlimentacionPK getAlimentacionPK() {
        return alimentacionPK;
    }

    public void setAlimentacionPK(AlimentacionPK alimentacionPK) {
        this.alimentacionPK = alimentacionPK;
    }

    public String getNombreAlimentacion() {
        return nombreAlimentacion;
    }

    public void setNombreAlimentacion(String nombreAlimentacion) {
        this.nombreAlimentacion = nombreAlimentacion;
    }

    public String getAlimentacionPorEtapas() {
        return alimentacionPorEtapas;
    }

    public void setAlimentacionPorEtapas(String alimentacionPorEtapas) {
        this.alimentacionPorEtapas = alimentacionPorEtapas;
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
        hash += (alimentacionPK != null ? alimentacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentacion)) {
            return false;
        }
        Alimentacion other = (Alimentacion) object;
        if ((this.alimentacionPK == null && other.alimentacionPK != null) || (this.alimentacionPK != null && !this.alimentacionPK.equals(other.alimentacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.Alimentacion[ alimentacionPK=" + alimentacionPK + " ]";
    }
    
}

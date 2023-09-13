/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain;
import cu.edu.unah.Proyectov1.Alimentacion.domain.Alimentacion;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "consejo_alimentacion", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsejoAlimentacion.findAll", query = "SELECT c FROM ConsejoAlimentacion c"),
    @NamedQuery(name = "ConsejoAlimentacion.findByIdAlimentacion", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.idAlimentacion = :idAlimentacion"),
    @NamedQuery(name = "ConsejoAlimentacion.findByConsejoAlimentacionProfesional", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionProfesional = :consejoAlimentacionProfesional"),
    @NamedQuery(name = "ConsejoAlimentacion.findByAlimentacionetapaCrianzarazaidRaza", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.alimentacionetapaCrianzarazaidRaza = :alimentacionetapaCrianzarazaidRaza"),
    @NamedQuery(name = "ConsejoAlimentacion.findByAlimentacionetapaCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal = :alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "ConsejoAlimentacion.findByAlimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA = :alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA"),
    @NamedQuery(name = "ConsejoAlimentacion.findByAlimentacionetapaCrianzaidEtapaCrianza", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.alimentacionetapaCrianzaidEtapaCrianza = :alimentacionetapaCrianzaidEtapaCrianza"),
    @NamedQuery(name = "ConsejoAlimentacion.findByAlimentacionidAlimentacion", query = "SELECT c FROM ConsejoAlimentacion c WHERE c.consejoAlimentacionPK.alimentacionidAlimentacion = :alimentacionidAlimentacion")})
public class ConsejoAlimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsejoAlimentacionPK consejoAlimentacionPK;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacion_profesional")
    private String consejoAlimentacionProfesional;
  
    @JoinColumns({
        @JoinColumn(name = "alimentacionetapa_crianzarazaid_raza", referencedColumnName = "etapa_crianzarazaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "alimentacionetapa_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "etapa_crianzarazaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "alimentacionetapa_crianzarazaespecieanimalgrupoanimalid_grupo_a", referencedColumnName = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false),
        @JoinColumn(name = "alimentacionetapa_crianzaid_etapa_crianza", referencedColumnName = "etapa_crianzaid_etapa_crianza", insertable = false, updatable = false),
        @JoinColumn(name = "alimentacionid_alimentacion", referencedColumnName = "id_alimentacion", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Alimentacion alimentacion;

    public ConsejoAlimentacion() {
    }

    public ConsejoAlimentacion(ConsejoAlimentacionPK consejoAlimentacionPK) {
        this.consejoAlimentacionPK = consejoAlimentacionPK;
    }

    public ConsejoAlimentacion(ConsejoAlimentacionPK consejoAlimentacionPK, String consejoAlimentacionProfesional) {
        this.consejoAlimentacionPK = consejoAlimentacionPK;
        this.consejoAlimentacionProfesional = consejoAlimentacionProfesional;
    }

    public ConsejoAlimentacion(int idAlimentacion, int alimentacionetapaCrianzarazaidRaza, int alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal, int alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA, int alimentacionetapaCrianzaidEtapaCrianza, int alimentacionidAlimentacion) {
        this.consejoAlimentacionPK = new ConsejoAlimentacionPK(idAlimentacion, alimentacionetapaCrianzarazaidRaza, alimentacionetapaCrianzarazaespecieanimalidEspecieAnimal, alimentacionetapaCrianzarazaespecieanimalgrupoanimalidGrupoA, alimentacionetapaCrianzaidEtapaCrianza, alimentacionidAlimentacion);
    }

    public ConsejoAlimentacionPK getConsejoAlimentacionPK() {
        return consejoAlimentacionPK;
    }

    public void setConsejoAlimentacionPK(ConsejoAlimentacionPK consejoAlimentacionPK) {
        this.consejoAlimentacionPK = consejoAlimentacionPK;
    }

    public String getConsejoAlimentacionProfesional() {
        return consejoAlimentacionProfesional;
    }

    public void setConsejoAlimentacionProfesional(String consejoAlimentacionProfesional) {
        this.consejoAlimentacionProfesional = consejoAlimentacionProfesional;
    }

    

    public Alimentacion getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(Alimentacion alimentacion) {
        this.alimentacion = alimentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consejoAlimentacionPK != null ? consejoAlimentacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejoAlimentacion)) {
            return false;
        }
        ConsejoAlimentacion other = (ConsejoAlimentacion) object;
        if ((this.consejoAlimentacionPK == null && other.consejoAlimentacionPK != null) || (this.consejoAlimentacionPK != null && !this.consejoAlimentacionPK.equals(other.consejoAlimentacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ConsejoAlimentacion[ consejoAlimentacionPK=" + consejoAlimentacionPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.domain;

import cu.edu.unah.Proyectov1.PracticaDeCrianza.domain.PracticaDeCrianza;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "consejos_practicas_crianza", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsejosPracticasCrianza.findAll", query = "SELECT c FROM ConsejosPracticasCrianza c"),
    @NamedQuery(name = "ConsejosPracticasCrianza.findByIdConsejoPracticaCrianza", query = "SELECT c FROM ConsejosPracticasCrianza c WHERE c.idConsejoPracticaCrianza = :idConsejoPracticaCrianza"),
    @NamedQuery(name = "ConsejosPracticasCrianza.findByConsejoPracticasCrianzaProfecional", query = "SELECT c FROM ConsejosPracticasCrianza c WHERE c.consejoPracticasCrianzaProfecional = :consejoPracticasCrianzaProfecional")})
public class ConsejosPracticasCrianza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consejo_practica_crianza")
    private Integer idConsejoPracticaCrianza;
    @Basic(optional = false)
    @Column(name = "consejo_practicas_crianza_profecional")
    private String consejoPracticasCrianzaProfecional;
    @ManyToMany(mappedBy = "consejosPracticasCrianzaList")
    private List<PracticaDeCrianza> practicaDeCrianzaList;
    

    public ConsejosPracticasCrianza() {
    }

    public ConsejosPracticasCrianza(Integer idConsejoPracticaCrianza) {
        this.idConsejoPracticaCrianza = idConsejoPracticaCrianza;
    }

    public ConsejosPracticasCrianza(Integer idConsejoPracticaCrianza, String consejoPracticasCrianzaProfecional) {
        this.idConsejoPracticaCrianza = idConsejoPracticaCrianza;
        this.consejoPracticasCrianzaProfecional = consejoPracticasCrianzaProfecional;
    }

    public Integer getIdConsejoPracticaCrianza() {
        return idConsejoPracticaCrianza;
    }

    public void setIdConsejoPracticaCrianza(Integer idConsejoPracticaCrianza) {
        this.idConsejoPracticaCrianza = idConsejoPracticaCrianza;
    }

    public String getConsejoPracticasCrianzaProfecional() {
        return consejoPracticasCrianzaProfecional;
    }

    public void setConsejoPracticasCrianzaProfecional(String consejoPracticasCrianzaProfecional) {
        this.consejoPracticasCrianzaProfecional = consejoPracticasCrianzaProfecional;
    }

    @XmlTransient
    public List<PracticaDeCrianza> getPracticaDeCrianzaList() {
        return practicaDeCrianzaList;
    }

    public void setPracticaDeCrianzaList(List<PracticaDeCrianza> practicaDeCrianzaList) {
        this.practicaDeCrianzaList = practicaDeCrianzaList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsejoPracticaCrianza != null ? idConsejoPracticaCrianza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsejosPracticasCrianza)) {
            return false;
        }
        ConsejosPracticasCrianza other = (ConsejosPracticasCrianza) object;
        if ((this.idConsejoPracticaCrianza == null && other.idConsejoPracticaCrianza != null) || (this.idConsejoPracticaCrianza != null && !this.idConsejoPracticaCrianza.equals(other.idConsejoPracticaCrianza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ConsejosPracticasCrianza[ idConsejoPracticaCrianza=" + idConsejoPracticaCrianza + " ]";
    }
    
}

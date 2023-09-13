/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain;

import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacion;
import java.io.Serializable;
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
@Table(name = "chat_consejo_alimentacion", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatConsejoAlimentacion.findAll", query = "SELECT c FROM ChatConsejoAlimentacion c"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByIdChatConsejoAlimentacion", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.idChatConsejoAlimentacion = :idChatConsejoAlimentacion"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoDeAlimentacion", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.consejoDeAlimentacion = :consejoDeAlimentacion"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionidAlimentacion", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionidAlimentacion = :consejoAlimentacionidAlimentacion"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionalimentacionetapaCrianzarazaidRaza", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionalimentacionetapaCrianzarazaidRaza = :consejoAlimentacionalimentacionetapaCrianzarazaidRaza"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimali", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali = :consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg = :consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza = :consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza"),
    @NamedQuery(name = "ChatConsejoAlimentacion.findByConsejoAlimentacionalimentacionidAlimentacion", query = "SELECT c FROM ChatConsejoAlimentacion c WHERE c.chatConsejoAlimentacionPK.consejoAlimentacionalimentacionidAlimentacion = :consejoAlimentacionalimentacionidAlimentacion")})
public class ChatConsejoAlimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatConsejoAlimentacionPK chatConsejoAlimentacionPK;
    @Column(name = "consejo_de_alimentacion")
    private String consejoDeAlimentacion;
    @JoinColumns({
        @JoinColumn(name = "consejo_alimentacionid_alimentacion", referencedColumnName = "id_alimentacion", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_alimentacionalimentacionetapa_crianzarazaid_raza", referencedColumnName = "alimentacionetapa_crianzarazaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_alimentacionalimentacionetapa_crianzarazaespecieanimali", referencedColumnName = "alimentacionetapa_crianzarazaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_alimentacionalimentacionetapa_crianzarazaespecieanimalg", referencedColumnName = "alimentacionetapa_crianzarazaespecieanimalgrupoanimalid_grupo_a", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_alimentacionalimentacionetapa_crianzaid_etapa_crianza", referencedColumnName = "alimentacionetapa_crianzaid_etapa_crianza", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_alimentacionalimentacionid_alimentacion", referencedColumnName = "alimentacionid_alimentacion", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ConsejoAlimentacion consejoAlimentacion;

    public ChatConsejoAlimentacion() {
    }

    public ChatConsejoAlimentacion(ChatConsejoAlimentacionPK chatConsejoAlimentacionPK) {
        this.chatConsejoAlimentacionPK = chatConsejoAlimentacionPK;
    }

    public ChatConsejoAlimentacion(int idChatConsejoAlimentacion, int consejoAlimentacionidAlimentacion, int consejoAlimentacionalimentacionetapaCrianzarazaidRaza, int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali, int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg, int consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza, int consejoAlimentacionalimentacionidAlimentacion) {
        this.chatConsejoAlimentacionPK = new ChatConsejoAlimentacionPK(idChatConsejoAlimentacion, consejoAlimentacionidAlimentacion, consejoAlimentacionalimentacionetapaCrianzarazaidRaza, consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali, consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg, consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza, consejoAlimentacionalimentacionidAlimentacion);
    }

    public ChatConsejoAlimentacionPK getChatConsejoAlimentacionPK() {
        return chatConsejoAlimentacionPK;
    }

    public void setChatConsejoAlimentacionPK(ChatConsejoAlimentacionPK chatConsejoAlimentacionPK) {
        this.chatConsejoAlimentacionPK = chatConsejoAlimentacionPK;
    }

    public String getConsejoDeAlimentacion() {
        return consejoDeAlimentacion;
    }

    public void setConsejoDeAlimentacion(String consejoDeAlimentacion) {
        this.consejoDeAlimentacion = consejoDeAlimentacion;
    }

    public ConsejoAlimentacion getConsejoAlimentacion() {
        return consejoAlimentacion;
    }

    public void setConsejoAlimentacion(ConsejoAlimentacion consejoAlimentacion) {
        this.consejoAlimentacion = consejoAlimentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatConsejoAlimentacionPK != null ? chatConsejoAlimentacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoAlimentacion)) {
            return false;
        }
        ChatConsejoAlimentacion other = (ChatConsejoAlimentacion) object;
        if ((this.chatConsejoAlimentacionPK == null && other.chatConsejoAlimentacionPK != null) || (this.chatConsejoAlimentacionPK != null && !this.chatConsejoAlimentacionPK.equals(other.chatConsejoAlimentacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoAlimentacion[ chatConsejoAlimentacionPK=" + chatConsejoAlimentacionPK + " ]";
    }
    
}

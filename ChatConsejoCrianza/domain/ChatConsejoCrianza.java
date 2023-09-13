/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain;

import cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.domain.ConsejosPracticasCrianza;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "chat_consejo_crianza", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatConsejoCrianza.findAll", query = "SELECT c FROM ChatConsejoCrianza c"),
    @NamedQuery(name = "ChatConsejoCrianza.findByConsejosPracticasCrianzaidConsejoPracticaCrianza", query = "SELECT c FROM ChatConsejoCrianza c WHERE c.chatConsejoCrianzaPK.consejosPracticasCrianzaidConsejoPracticaCrianza = :consejosPracticasCrianzaidConsejoPracticaCrianza"),
    @NamedQuery(name = "ChatConsejoCrianza.findByIdChatConsejo", query = "SELECT c FROM ChatConsejoCrianza c WHERE c.chatConsejoCrianzaPK.idChatConsejo = :idChatConsejo"),
    @NamedQuery(name = "ChatConsejoCrianza.findByConsejoCrianza", query = "SELECT c FROM ChatConsejoCrianza c WHERE c.consejoCrianza = :consejoCrianza")})
public class ChatConsejoCrianza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatConsejoCrianzaPK chatConsejoCrianzaPK;
    @Column(name = "consejo_crianza")
    private String consejoCrianza;
    @JoinColumn(name = "consejos_practicas_crianzaid_consejo_practica_crianza", referencedColumnName = "id_consejo_practica_crianza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConsejosPracticasCrianza consejosPracticasCrianza;

    public ChatConsejoCrianza() {
    }

    public ChatConsejoCrianza(ChatConsejoCrianzaPK chatConsejoCrianzaPK) {
        this.chatConsejoCrianzaPK = chatConsejoCrianzaPK;
    }

    public ChatConsejoCrianza(int consejosPracticasCrianzaidConsejoPracticaCrianza, int idChatConsejo) {
        this.chatConsejoCrianzaPK = new ChatConsejoCrianzaPK(consejosPracticasCrianzaidConsejoPracticaCrianza, idChatConsejo);
    }

    public ChatConsejoCrianzaPK getChatConsejoCrianzaPK() {
        return chatConsejoCrianzaPK;
    }

    public void setChatConsejoCrianzaPK(ChatConsejoCrianzaPK chatConsejoCrianzaPK) {
        this.chatConsejoCrianzaPK = chatConsejoCrianzaPK;
    }

    public String getConsejoCrianza() {
        return consejoCrianza;
    }

    public void setConsejoCrianza(String consejoCrianza) {
        this.consejoCrianza = consejoCrianza;
    }

    public ConsejosPracticasCrianza getConsejosPracticasCrianza() {
        return consejosPracticasCrianza;
    }

    public void setConsejosPracticasCrianza(ConsejosPracticasCrianza consejosPracticasCrianza) {
        this.consejosPracticasCrianza = consejosPracticasCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatConsejoCrianzaPK != null ? chatConsejoCrianzaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoCrianza)) {
            return false;
        }
        ChatConsejoCrianza other = (ChatConsejoCrianza) object;
        if ((this.chatConsejoCrianzaPK == null && other.chatConsejoCrianzaPK != null) || (this.chatConsejoCrianzaPK != null && !this.chatConsejoCrianzaPK.equals(other.chatConsejoCrianzaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoCrianza[ chatConsejoCrianzaPK=" + chatConsejoCrianzaPK + " ]";
    }
    
}

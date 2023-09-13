/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain;

import cu.edu.unah.Proyectov1.ConsejosPreventivos.domain.ConsejosPreventivos;
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
@Table(name = "chat_consejo_prevencion", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatConsejoPrevencion.findAll", query = "SELECT c FROM ChatConsejoPrevencion c"),
    @NamedQuery(name = "ChatConsejoPrevencion.findByConsejosPreventivosidConsejosPreventivos", query = "SELECT c FROM ChatConsejoPrevencion c WHERE c.chatConsejoPrevencionPK.consejosPreventivosidConsejosPreventivos = :consejosPreventivosidConsejosPreventivos"),
    @NamedQuery(name = "ChatConsejoPrevencion.findByIdChatConsejosPrevencion", query = "SELECT c FROM ChatConsejoPrevencion c WHERE c.chatConsejoPrevencionPK.idChatConsejosPrevencion = :idChatConsejosPrevencion"),
    @NamedQuery(name = "ChatConsejoPrevencion.findByConsejosPrevencion", query = "SELECT c FROM ChatConsejoPrevencion c WHERE c.consejosPrevencion = :consejosPrevencion")})
public class ChatConsejoPrevencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatConsejoPrevencionPK chatConsejoPrevencionPK;
    @Column(name = "consejos_prevencion")
    private String consejosPrevencion;
    @JoinColumn(name = "consejos_preventivosid_consejos_preventivos", referencedColumnName = "id_consejos_preventivos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ConsejosPreventivos consejosPreventivos;

    public ChatConsejoPrevencion() {
    }

    public ChatConsejoPrevencion(ChatConsejoPrevencionPK chatConsejoPrevencionPK) {
        this.chatConsejoPrevencionPK = chatConsejoPrevencionPK;
    }

    public ChatConsejoPrevencion(int consejosPreventivosidConsejosPreventivos, int idChatConsejosPrevencion) {
        this.chatConsejoPrevencionPK = new ChatConsejoPrevencionPK(consejosPreventivosidConsejosPreventivos, idChatConsejosPrevencion);
    }

    public ChatConsejoPrevencionPK getChatConsejoPrevencionPK() {
        return chatConsejoPrevencionPK;
    }

    public void setChatConsejoPrevencionPK(ChatConsejoPrevencionPK chatConsejoPrevencionPK) {
        this.chatConsejoPrevencionPK = chatConsejoPrevencionPK;
    }

    public String getConsejosPrevencion() {
        return consejosPrevencion;
    }

    public void setConsejosPrevencion(String consejosPrevencion) {
        this.consejosPrevencion = consejosPrevencion;
    }

    public ConsejosPreventivos getConsejosPreventivos() {
        return consejosPreventivos;
    }

    public void setConsejosPreventivos(ConsejosPreventivos consejosPreventivos) {
        this.consejosPreventivos = consejosPreventivos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatConsejoPrevencionPK != null ? chatConsejoPrevencionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoPrevencion)) {
            return false;
        }
        ChatConsejoPrevencion other = (ChatConsejoPrevencion) object;
        if ((this.chatConsejoPrevencionPK == null && other.chatConsejoPrevencionPK != null) || (this.chatConsejoPrevencionPK != null && !this.chatConsejoPrevencionPK.equals(other.chatConsejoPrevencionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoPrevencion[ chatConsejoPrevencionPK=" + chatConsejoPrevencionPK + " ]";
    }
    
}

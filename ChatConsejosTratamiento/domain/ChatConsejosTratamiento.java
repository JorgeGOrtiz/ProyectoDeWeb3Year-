/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain;

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
import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamiento;
/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "chat_consejos_tratamiento", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatConsejosTratamiento.findAll", query = "SELECT c FROM ChatConsejosTratamiento c"),
    @NamedQuery(name = "ChatConsejosTratamiento.findByConsejoTrataminetotratamientosidTratamiento", query = "SELECT c FROM ChatConsejosTratamiento c WHERE c.chatConsejosTratamientoPK.consejoTrataminetotratamientosidTratamiento = :consejoTrataminetotratamientosidTratamiento"),
    @NamedQuery(name = "ChatConsejosTratamiento.findByConsejoTrataminetoidConsejosTratamientos", query = "SELECT c FROM ChatConsejosTratamiento c WHERE c.chatConsejosTratamientoPK.consejoTrataminetoidConsejosTratamientos = :consejoTrataminetoidConsejosTratamientos"),
    @NamedQuery(name = "ChatConsejosTratamiento.findByIdChatConsejoTratamineto", query = "SELECT c FROM ChatConsejosTratamiento c WHERE c.chatConsejosTratamientoPK.idChatConsejoTratamineto = :idChatConsejoTratamineto"),
    @NamedQuery(name = "ChatConsejosTratamiento.findByConsejoTratamiento", query = "SELECT c FROM ChatConsejosTratamiento c WHERE c.consejoTratamiento = :consejoTratamiento")})
public class ChatConsejosTratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatConsejosTratamientoPK chatConsejosTratamientoPK;
    @Column(name = "consejo_tratamiento")
    private String consejoTratamiento;
    @JoinColumns({
        @JoinColumn(name = "consejo_trataminetotratamientosid_tratamiento", referencedColumnName = "tratamientosid_tratamiento", insertable = false, updatable = false),
        @JoinColumn(name = "consejo_trataminetoid_consejos_tratamientos", referencedColumnName = "id_consejos_tratamientos", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ConsejoTratamiento consejoTratamiento1;

    public ChatConsejosTratamiento() {
    }

    public ChatConsejosTratamiento(ChatConsejosTratamientoPK chatConsejosTratamientoPK) {
        this.chatConsejosTratamientoPK = chatConsejosTratamientoPK;
    }

    public ChatConsejosTratamiento(int consejoTrataminetotratamientosidTratamiento, int consejoTrataminetoidConsejosTratamientos, int idChatConsejoTratamineto) {
        this.chatConsejosTratamientoPK = new ChatConsejosTratamientoPK(consejoTrataminetotratamientosidTratamiento, consejoTrataminetoidConsejosTratamientos, idChatConsejoTratamineto);
    }

    public ChatConsejosTratamientoPK getChatConsejosTratamientoPK() {
        return chatConsejosTratamientoPK;
    }

    public void setChatConsejosTratamientoPK(ChatConsejosTratamientoPK chatConsejosTratamientoPK) {
        this.chatConsejosTratamientoPK = chatConsejosTratamientoPK;
    }

    public String getConsejoTratamiento() {
        return consejoTratamiento;
    }

    public void setConsejoTratamiento(String consejoTratamiento) {
        this.consejoTratamiento = consejoTratamiento;
    }

    public ConsejoTratamiento getConsejoTratamiento1() {
        return consejoTratamiento1;
    }

    public void setConsejoTratamiento1(ConsejoTratamiento consejoTratamiento1) {
        this.consejoTratamiento1 = consejoTratamiento1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatConsejosTratamientoPK != null ? chatConsejosTratamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejosTratamiento)) {
            return false;
        }
        ChatConsejosTratamiento other = (ChatConsejosTratamiento) object;
        if ((this.chatConsejosTratamientoPK == null && other.chatConsejosTratamientoPK != null) || (this.chatConsejosTratamientoPK != null && !this.chatConsejosTratamientoPK.equals(other.chatConsejosTratamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultor.ChatConsejosTratamiento[ chatConsejosTratamientoPK=" + chatConsejosTratamientoPK + " ]";
    }
    
}

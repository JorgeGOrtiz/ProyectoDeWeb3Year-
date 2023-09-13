/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class ChatConsejoPrevencionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "consejos_preventivosid_consejos_preventivos")
    private int consejosPreventivosidConsejosPreventivos;
    @Basic(optional = false)
    @Column(name = "id_chat_consejos_prevencion")
    private int idChatConsejosPrevencion;

    public ChatConsejoPrevencionPK() {
    }

    public ChatConsejoPrevencionPK(int consejosPreventivosidConsejosPreventivos, int idChatConsejosPrevencion) {
        this.consejosPreventivosidConsejosPreventivos = consejosPreventivosidConsejosPreventivos;
        this.idChatConsejosPrevencion = idChatConsejosPrevencion;
    }

    public int getConsejosPreventivosidConsejosPreventivos() {
        return consejosPreventivosidConsejosPreventivos;
    }

    public void setConsejosPreventivosidConsejosPreventivos(int consejosPreventivosidConsejosPreventivos) {
        this.consejosPreventivosidConsejosPreventivos = consejosPreventivosidConsejosPreventivos;
    }

    public int getIdChatConsejosPrevencion() {
        return idChatConsejosPrevencion;
    }

    public void setIdChatConsejosPrevencion(int idChatConsejosPrevencion) {
        this.idChatConsejosPrevencion = idChatConsejosPrevencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consejosPreventivosidConsejosPreventivos;
        hash += (int) idChatConsejosPrevencion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoPrevencionPK)) {
            return false;
        }
        ChatConsejoPrevencionPK other = (ChatConsejoPrevencionPK) object;
        if (this.consejosPreventivosidConsejosPreventivos != other.consejosPreventivosidConsejosPreventivos) {
            return false;
        }
        if (this.idChatConsejosPrevencion != other.idChatConsejosPrevencion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoPrevencionPK[ consejosPreventivosidConsejosPreventivos=" + consejosPreventivosidConsejosPreventivos + ", idChatConsejosPrevencion=" + idChatConsejosPrevencion + " ]";
    }
    
}

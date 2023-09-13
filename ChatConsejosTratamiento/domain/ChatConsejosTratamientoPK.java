/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Carrillo
 */
@Embeddable
public class ChatConsejosTratamientoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "consejo_trataminetotratamientosid_tratamiento")
    private int consejoTrataminetotratamientosidTratamiento;
    @Basic(optional = false)
    @Column(name = "consejo_trataminetoid_consejos_tratamientos")
    private int consejoTrataminetoidConsejosTratamientos;
    @Basic(optional = false)
    @Column(name = "id_chat_consejo_tratamineto")
    private int idChatConsejoTratamineto;

    public ChatConsejosTratamientoPK() {
    }

    public ChatConsejosTratamientoPK(int consejoTrataminetotratamientosidTratamiento, int consejoTrataminetoidConsejosTratamientos, int idChatConsejoTratamineto) {
        this.consejoTrataminetotratamientosidTratamiento = consejoTrataminetotratamientosidTratamiento;
        this.consejoTrataminetoidConsejosTratamientos = consejoTrataminetoidConsejosTratamientos;
        this.idChatConsejoTratamineto = idChatConsejoTratamineto;
    }

    public int getConsejoTrataminetotratamientosidTratamiento() {
        return consejoTrataminetotratamientosidTratamiento;
    }

    public void setConsejoTrataminetotratamientosidTratamiento(int consejoTrataminetotratamientosidTratamiento) {
        this.consejoTrataminetotratamientosidTratamiento = consejoTrataminetotratamientosidTratamiento;
    }

    public int getConsejoTrataminetoidConsejosTratamientos() {
        return consejoTrataminetoidConsejosTratamientos;
    }

    public void setConsejoTrataminetoidConsejosTratamientos(int consejoTrataminetoidConsejosTratamientos) {
        this.consejoTrataminetoidConsejosTratamientos = consejoTrataminetoidConsejosTratamientos;
    }

    public int getIdChatConsejoTratamineto() {
        return idChatConsejoTratamineto;
    }

    public void setIdChatConsejoTratamineto(int idChatConsejoTratamineto) {
        this.idChatConsejoTratamineto = idChatConsejoTratamineto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consejoTrataminetotratamientosidTratamiento;
        hash += (int) consejoTrataminetoidConsejosTratamientos;
        hash += (int) idChatConsejoTratamineto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejosTratamientoPK)) {
            return false;
        }
        ChatConsejosTratamientoPK other = (ChatConsejosTratamientoPK) object;
        if (this.consejoTrataminetotratamientosidTratamiento != other.consejoTrataminetotratamientosidTratamiento) {
            return false;
        }
        if (this.consejoTrataminetoidConsejosTratamientos != other.consejoTrataminetoidConsejosTratamientos) {
            return false;
        }
        if (this.idChatConsejoTratamineto != other.idChatConsejoTratamineto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "consultor.ChatConsejosTratamientoPK[ consejoTrataminetotratamientosidTratamiento=" + consejoTrataminetotratamientosidTratamiento + ", consejoTrataminetoidConsejosTratamientos=" + consejoTrataminetoidConsejosTratamientos + ", idChatConsejoTratamineto=" + idChatConsejoTratamineto + " ]";
    }
    
}

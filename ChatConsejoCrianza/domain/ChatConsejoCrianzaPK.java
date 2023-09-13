/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class ChatConsejoCrianzaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "consejos_practicas_crianzaid_consejo_practica_crianza")
    private int consejosPracticasCrianzaidConsejoPracticaCrianza;
    @Basic(optional = false)
    @Column(name = "id_chat_consejo")
    private int idChatConsejo;

    public ChatConsejoCrianzaPK() {
    }

    public ChatConsejoCrianzaPK(int consejosPracticasCrianzaidConsejoPracticaCrianza, int idChatConsejo) {
        this.consejosPracticasCrianzaidConsejoPracticaCrianza = consejosPracticasCrianzaidConsejoPracticaCrianza;
        this.idChatConsejo = idChatConsejo;
    }

    public int getConsejosPracticasCrianzaidConsejoPracticaCrianza() {
        return consejosPracticasCrianzaidConsejoPracticaCrianza;
    }

    public void setConsejosPracticasCrianzaidConsejoPracticaCrianza(int consejosPracticasCrianzaidConsejoPracticaCrianza) {
        this.consejosPracticasCrianzaidConsejoPracticaCrianza = consejosPracticasCrianzaidConsejoPracticaCrianza;
    }

    public int getIdChatConsejo() {
        return idChatConsejo;
    }

    public void setIdChatConsejo(int idChatConsejo) {
        this.idChatConsejo = idChatConsejo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consejosPracticasCrianzaidConsejoPracticaCrianza;
        hash += (int) idChatConsejo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoCrianzaPK)) {
            return false;
        }
        ChatConsejoCrianzaPK other = (ChatConsejoCrianzaPK) object;
        if (this.consejosPracticasCrianzaidConsejoPracticaCrianza != other.consejosPracticasCrianzaidConsejoPracticaCrianza) {
            return false;
        }
        if (this.idChatConsejo != other.idChatConsejo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoCrianzaPK[ consejosPracticasCrianzaidConsejoPracticaCrianza=" + consejosPracticasCrianzaidConsejoPracticaCrianza + ", idChatConsejo=" + idChatConsejo + " ]";
    }
    
}

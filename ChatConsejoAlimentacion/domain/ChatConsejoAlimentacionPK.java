/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class ChatConsejoAlimentacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_chat_consejo_alimentacion")
    private int idChatConsejoAlimentacion;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionid_alimentacion")
    private int consejoAlimentacionidAlimentacion;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionalimentacionetapa_crianzarazaid_raza")
    private int consejoAlimentacionalimentacionetapaCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionalimentacionetapa_crianzarazaespecieanimali")
    private int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionalimentacionetapa_crianzarazaespecieanimalg")
    private int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionalimentacionetapa_crianzaid_etapa_crianza")
    private int consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza;
    @Basic(optional = false)
    @Column(name = "consejo_alimentacionalimentacionid_alimentacion")
    private int consejoAlimentacionalimentacionidAlimentacion;

    public ChatConsejoAlimentacionPK() {
    }

    public ChatConsejoAlimentacionPK(int idChatConsejoAlimentacion, int consejoAlimentacionidAlimentacion, int consejoAlimentacionalimentacionetapaCrianzarazaidRaza, int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali, int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg, int consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza, int consejoAlimentacionalimentacionidAlimentacion) {
        this.idChatConsejoAlimentacion = idChatConsejoAlimentacion;
        this.consejoAlimentacionidAlimentacion = consejoAlimentacionidAlimentacion;
        this.consejoAlimentacionalimentacionetapaCrianzarazaidRaza = consejoAlimentacionalimentacionetapaCrianzarazaidRaza;
        this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali = consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali;
        this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg = consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg;
        this.consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza = consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza;
        this.consejoAlimentacionalimentacionidAlimentacion = consejoAlimentacionalimentacionidAlimentacion;
    }

    public int getIdChatConsejoAlimentacion() {
        return idChatConsejoAlimentacion;
    }

    public void setIdChatConsejoAlimentacion(int idChatConsejoAlimentacion) {
        this.idChatConsejoAlimentacion = idChatConsejoAlimentacion;
    }

    public int getConsejoAlimentacionidAlimentacion() {
        return consejoAlimentacionidAlimentacion;
    }

    public void setConsejoAlimentacionidAlimentacion(int consejoAlimentacionidAlimentacion) {
        this.consejoAlimentacionidAlimentacion = consejoAlimentacionidAlimentacion;
    }

    public int getConsejoAlimentacionalimentacionetapaCrianzarazaidRaza() {
        return consejoAlimentacionalimentacionetapaCrianzarazaidRaza;
    }

    public void setConsejoAlimentacionalimentacionetapaCrianzarazaidRaza(int consejoAlimentacionalimentacionetapaCrianzarazaidRaza) {
        this.consejoAlimentacionalimentacionetapaCrianzarazaidRaza = consejoAlimentacionalimentacionetapaCrianzarazaidRaza;
    }

    public int getConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimali() {
        return consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali;
    }

    public void setConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimali(int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali) {
        this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali = consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali;
    }

    public int getConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg() {
        return consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg;
    }

    public void setConsejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg(int consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg) {
        this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg = consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg;
    }

    public int getConsejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza() {
        return consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza;
    }

    public void setConsejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza(int consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza) {
        this.consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza = consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza;
    }

    public int getConsejoAlimentacionalimentacionidAlimentacion() {
        return consejoAlimentacionalimentacionidAlimentacion;
    }

    public void setConsejoAlimentacionalimentacionidAlimentacion(int consejoAlimentacionalimentacionidAlimentacion) {
        this.consejoAlimentacionalimentacionidAlimentacion = consejoAlimentacionalimentacionidAlimentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idChatConsejoAlimentacion;
        hash += (int) consejoAlimentacionidAlimentacion;
        hash += (int) consejoAlimentacionalimentacionetapaCrianzarazaidRaza;
        hash += (int) consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali;
        hash += (int) consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg;
        hash += (int) consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza;
        hash += (int) consejoAlimentacionalimentacionidAlimentacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatConsejoAlimentacionPK)) {
            return false;
        }
        ChatConsejoAlimentacionPK other = (ChatConsejoAlimentacionPK) object;
        if (this.idChatConsejoAlimentacion != other.idChatConsejoAlimentacion) {
            return false;
        }
        if (this.consejoAlimentacionidAlimentacion != other.consejoAlimentacionidAlimentacion) {
            return false;
        }
        if (this.consejoAlimentacionalimentacionetapaCrianzarazaidRaza != other.consejoAlimentacionalimentacionetapaCrianzarazaidRaza) {
            return false;
        }
        if (this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali != other.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali) {
            return false;
        }
        if (this.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg != other.consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg) {
            return false;
        }
        if (this.consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza != other.consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza) {
            return false;
        }
        if (this.consejoAlimentacionalimentacionidAlimentacion != other.consejoAlimentacionalimentacionidAlimentacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.ChatConsejoAlimentacionPK[ idChatConsejoAlimentacion=" + idChatConsejoAlimentacion + ", consejoAlimentacionidAlimentacion=" + consejoAlimentacionidAlimentacion + ", consejoAlimentacionalimentacionetapaCrianzarazaidRaza=" + consejoAlimentacionalimentacionetapaCrianzarazaidRaza + ", consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali=" + consejoAlimentacionalimentacionetapaCrianzarazaespecieanimali + ", consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg=" + consejoAlimentacionalimentacionetapaCrianzarazaespecieanimalg + ", consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza=" + consejoAlimentacionalimentacionetapaCrianzaidEtapaCrianza + ", consejoAlimentacionalimentacionidAlimentacion=" + consejoAlimentacionalimentacionidAlimentacion + " ]";
    }
    
}

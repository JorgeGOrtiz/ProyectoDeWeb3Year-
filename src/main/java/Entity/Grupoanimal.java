/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "grupoanimal", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Grupoanimal.findAll", query = "SELECT g FROM Grupoanimal g"),
    @NamedQuery(name = "Grupoanimal.findByIdGrupoAnimal", query = "SELECT g FROM Grupoanimal g WHERE g.idGrupoAnimal = :idGrupoAnimal"),
    @NamedQuery(name = "Grupoanimal.findByNombregrupoanimal", query = "SELECT g FROM Grupoanimal g WHERE g.nombregrupoanimal = :nombregrupoanimal")})
public class Grupoanimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_animal")
    private Integer idGrupoAnimal;
    @Basic(optional = false)
    @Column(name = "nombregrupoanimal")
    private String nombregrupoanimal;
    

    public Grupoanimal() {
    }

    public Grupoanimal(Integer idGrupoAnimal) {
        this.idGrupoAnimal = idGrupoAnimal;
    }

    public Grupoanimal(Integer idGrupoAnimal, String nombregrupoanimal) {
        this.idGrupoAnimal = idGrupoAnimal;
        this.nombregrupoanimal = nombregrupoanimal;
    }

    public Integer getIdGrupoAnimal() {
        return idGrupoAnimal;
    }

    public void setIdGrupoAnimal(Integer idGrupoAnimal) {
        this.idGrupoAnimal = idGrupoAnimal;
    }

    public String getNombregrupoanimal() {
        return nombregrupoanimal;
    }

    public void setNombregrupoanimal(String nombregrupoanimal) {
        this.nombregrupoanimal = nombregrupoanimal;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoAnimal != null ? idGrupoAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoanimal)) {
            return false;
        }
        Grupoanimal other = (Grupoanimal) object;
        if ((this.idGrupoAnimal == null && other.idGrupoAnimal != null) || (this.idGrupoAnimal != null && !this.idGrupoAnimal.equals(other.idGrupoAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.Grupoanimal[ idGrupoAnimal=" + idGrupoAnimal + " ]";
    }
    
}

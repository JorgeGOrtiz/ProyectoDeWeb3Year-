/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;


import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "animal", catalog = "BD_Usuarios", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByIdAnimal", query = "SELECT a FROM Animal a WHERE a.animalPK.idAnimal = :idAnimal"),
    @NamedQuery(name = "Animal.findByRazaidRaza", query = "SELECT a FROM Animal a WHERE a.animalPK.razaidRaza = :razaidRaza"),
    @NamedQuery(name = "Animal.findByRazaespecieanimalidEspecieAnimal", query = "SELECT a FROM Animal a WHERE a.animalPK.razaespecieanimalidEspecieAnimal = :razaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "Animal.findByRazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT a FROM Animal a WHERE a.animalPK.razaespecieanimalgrupoanimalidGrupoAnimal = :razaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "Animal.findByNombreAnimal", query = "SELECT a FROM Animal a WHERE a.nombreAnimal = :nombreAnimal"),
    @NamedQuery(name = "Animal.findByFechaNacimiento", query = "SELECT a FROM Animal a WHERE a.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Animal.findBySexo", query = "SELECT a FROM Animal a WHERE a.sexo = :sexo")})
public class Animal {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimalPK animalPK;
    @Basic(optional = false)
    @Column(name = "nombre_animal")
    private String nombreAnimal;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    
    @JoinColumns({
        @JoinColumn(name = "razaid_raza", referencedColumnName = "id_raza", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalid_especie_animal", referencedColumnName = "especieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "especieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Raza raza;

    public Animal() {
    }

    public Animal(AnimalPK animalPK) {
        this.animalPK = animalPK;
    }

    public Animal(AnimalPK animalPK, String nombreAnimal, Date fechaNacimiento, String sexo) {
        this.animalPK = animalPK;
        this.nombreAnimal = nombreAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Animal(int idAnimal, int razaidRaza, int razaespecieanimalidEspecieAnimal, int razaespecieanimalgrupoanimalidGrupoAnimal) {
        this.animalPK = new AnimalPK(idAnimal, razaidRaza, razaespecieanimalidEspecieAnimal, razaespecieanimalgrupoanimalidGrupoAnimal);
    }

    public AnimalPK getAnimalPK() {
        return animalPK;
    }

    public void setAnimalPK(AnimalPK animalPK) {
        this.animalPK = animalPK;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

  

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalPK != null ? animalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.animalPK == null && other.animalPK != null) || (this.animalPK != null && !this.animalPK.equals(other.animalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD_Usuarios.Animal[ animalPK=" + animalPK + " ]";
    }
    
}

package Entity;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "cliente")

@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
        @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
        @NamedQuery(name = "Cliente.findByContrasenna", query = "SELECT c FROM Cliente c WHERE c.contrasenna = :contrasenna"),
        @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
        @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
        @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "contrasenna")
    private String contrasenna;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    /**@OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private List<Prestamo> prestamoList;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
     private List<Cuenta> cuentaList;

     **/
    public Cliente() {
    }


    public Cliente(String email) {
        this.email = email;
    }
    public Cliente(String email,String contrasenna,String nombre,String direccion,int telefono){
        this.email=email;
        this.contrasenna=contrasenna;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    /**
     @XmlTransient
     public List<Prestamo> getPrestamoList() {
     return prestamoList;
     }

     **/
    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}

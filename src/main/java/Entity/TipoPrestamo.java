package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tipo_prestamo")

@NamedQueries({
        @NamedQuery(name = "TipoPrestamo.findAll", query = "SELECT t FROM TipoPrestamo t"),
        @NamedQuery(name = "TipoPrestamo.findByIdTipoPrestamo", query = "SELECT t FROM TipoPrestamo t WHERE t.idTipoPrestamo = :idTipoPrestamo"),
        @NamedQuery(name = "TipoPrestamo.findByNombre", query = "SELECT t FROM TipoPrestamo t WHERE t.nombre = :nombre"),
        @NamedQuery(name = "TipoPrestamo.findByInteres", query = "SELECT t FROM TipoPrestamo t WHERE t.interes = :interes"),
        @NamedQuery(name = "TipoPrestamo.findByVentajas", query = "SELECT t FROM TipoPrestamo t WHERE t.ventajas = :ventajas")})
public class TipoPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_prestamo")
    private Integer idTipoPrestamo;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interes")
    private Float interes;
    @Column(name = "ventajas")
    private String ventajas;
    /** @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPrestamo")
    private List<Prestamo> prestamoList;
     **/
    public TipoPrestamo() {
    }

    public TipoPrestamo(Integer idTipoPrestamo) {
        this.idTipoPrestamo = idTipoPrestamo;
    }

    public Integer getIdTipoPrestamo() {
        return idTipoPrestamo;
    }

    public void setIdTipoPrestamo(Integer idTipoPrestamo) {
        this.idTipoPrestamo = idTipoPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public String getVentajas() {
        return ventajas;
    }

    public void setVentajas(String ventajas) {
        this.ventajas = ventajas;
    }

    /** @XmlTransient
    public List<Prestamo> getPrestamoList() {
    return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
    this.prestamoList = prestamoList;
    }
     **/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPrestamo != null ? idTipoPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrestamo)) {
            return false;
        }
        TipoPrestamo other = (TipoPrestamo) object;
        if ((this.idTipoPrestamo == null && other.idTipoPrestamo != null) || (this.idTipoPrestamo != null && !this.idTipoPrestamo.equals(other.idTipoPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.TipoPrestamo[ idTipoPrestamo=" + idTipoPrestamo + " ]";
    }


}

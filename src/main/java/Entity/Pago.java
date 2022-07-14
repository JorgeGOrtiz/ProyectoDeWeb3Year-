package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import javax.persistence.NamedQueries;

@Entity
@Table(name = "pago")

@NamedQueries({
        @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
        @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago"),
        @NamedQuery(name = "Pago.findByFecha", query = "SELECT p FROM Pago p WHERE p.fecha = :fecha"),
        @NamedQuery(name = "Pago.findByMonto", query = "SELECT p FROM Pago p WHERE p.monto = :monto")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "monto")
    private Integer monto;
    @JoinColumn(name = "prestamoid_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne(optional = false)
    private Prestamo prestamoidPrestamo;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Prestamo getPrestamoidPrestamo() {
        return prestamoidPrestamo;
    }

    public void setPrestamoidPrestamo(Prestamo prestamoidPrestamo) {
        this.prestamoidPrestamo = prestamoidPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.Pago[ idPago=" + idPago + " ]";
    }
}

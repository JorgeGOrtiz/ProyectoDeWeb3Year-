package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "prestamo")

@NamedQueries({
        @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
        @NamedQuery(name = "Prestamo.findByIdPrestamo", query = "SELECT p FROM Prestamo p WHERE p.idPrestamo = :idPrestamo"),
        @NamedQuery(name = "Prestamo.findByCuotaMinima", query = "SELECT p FROM Prestamo p WHERE p.cuotaMinima = :cuotaMinima"),
        @NamedQuery(name = "Prestamo.findByFecha", query = "SELECT p FROM Prestamo p WHERE p.fecha = :fecha"),
        @NamedQuery(name = "Prestamo.findByImporte", query = "SELECT p FROM Prestamo p WHERE p.importe = :importe")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cuota_minima")
    private Float cuotaMinima;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "importe")
    private Float importe;
    @Column(name = "estado")
    private String estado;
    /** @ManyToMany(mappedBy = "prestamoList")
    private List<Transaccion> transaccionList;**/
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Cliente email;
    @JoinColumn(name = "id_tipo_prestamo", referencedColumnName = "id_tipo_prestamo")
    @ManyToOne(optional = false)
    private TipoPrestamo idTipoPrestamo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamoidPrestamo")
//    private List<Pago> pagoList;

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Float getCuotaMinima() {
        return cuotaMinima;
    }

    public void setCuotaMinima(Float cuotaMinima) {
        this.cuotaMinima = cuotaMinima;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** @XmlTransient
    public List<Transaccion> getTransaccionList() {
    return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
    this.transaccionList = transaccionList;
    }
     **/
    public Cliente getEmail() {
        return email;
    }

    public void setEmail(Cliente email) {
        this.email = email;
    }

    public TipoPrestamo getIdTipoPrestamo() {
        return idTipoPrestamo;
    }

    public void setIdTipoPrestamo(TipoPrestamo idTipoPrestamo) {
        this.idTipoPrestamo = idTipoPrestamo;
    }
    /** @XmlTransient
    public List<Pago> getPagoList() {
    return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
    this.pagoList = pagoList;
    }
     **/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.Prestamo[ idPrestamo=" + idPrestamo + " ]";
    }


}

package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name = "transaccion")

@NamedQueries({
        @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
        @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.idTransaccion = :idTransaccion"),
        @NamedQuery(name = "Transaccion.findByFecha", query = "SELECT t FROM Transaccion t WHERE t.fecha = :fecha"),
        @NamedQuery(name = "Transaccion.findByMontoTransaccion", query = "SELECT t FROM Transaccion t WHERE t.montoTransaccion = :montoTransaccion"),
        @NamedQuery(name = "Transaccion.findByCuentaidCuenta", query = "SELECT t FROM Transaccion t, TransaccionCuenta tc WHERE t.idTransaccion = tc.transaccionCuentaPK.transaccionidTransaccion AND tc.transaccionCuentaPK.cuentaidCuenta = :idCuenta")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "monto_transaccion")
    private Integer montoTransaccion;
//    @JoinTable(name = "transaccion_prestamo", joinColumns = {
//        @JoinColumn(name = "transaccionid_transaccion", referencedColumnName = "id_transaccion")}, inverseJoinColumns = {
//        @JoinColumn(name = "prestamoid_prestamo", referencedColumnName = "id_prestamo")})
//    @ManyToMany
//    private List<Prestamo> prestamoList;
//    @JoinTable(name = "transaccion_cuenta", joinColumns = {
//        @JoinColumn(name = "transaccionid_transaccion", referencedColumnName = "id_transaccion")}, inverseJoinColumns = {
//        @JoinColumn(name = "cuentaid_cuenta", referencedColumnName = "id_cuenta")})
//    @ManyToMany
//    private List<Cuenta> cuentaList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransaccion")
//    private List<Operacion> operacionList;

    public Transaccion() {
    }
    public Transaccion(int idTransaccion,Date fecha,int montoTransaccion){
        this.idTransaccion=idTransaccion;
        this.fecha=fecha;
        this.montoTransaccion=montoTransaccion;
    }
    public Transaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(Integer montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

//    @XmlTransient
//    public List<Prestamo> getPrestamoList() {
//        return prestamoList;
//    }
//
//    public void setPrestamoList(List<Prestamo> prestamoList) {
//        this.prestamoList = prestamoList;
//    }
//
//    @XmlTransient
//    public List<Cuenta> getCuentaList() {
//        return cuentaList;
//    }
//
//    public void setCuentaList(List<Cuenta> cuentaList) {
//        this.cuentaList = cuentaList;
//    }
//
//    @XmlTransient
//    public List<Operacion> getOperacionList() {
//        return operacionList;
//    }
//
//    public void setOperacionList(List<Operacion> operacionList) {
//        this.operacionList = operacionList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransaccion=" + idTransaccion +
                ", fecha=" + fecha +
                ", montoTransaccion=" + montoTransaccion +
                '}';
    }
}

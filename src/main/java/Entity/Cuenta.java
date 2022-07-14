package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "cuenta")
@NamedQueries({
        @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
        @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
        @NamedQuery(name = "Cuenta.findByFecha", query = "SELECT c FROM Cuenta c WHERE c.fecha = :fecha"),
        @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo"),
        @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private String idCuenta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "saldo")
    private float saldo;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    //    @ManyToMany(mappedBy = "cuentaList")
//    private List<Transaccion> transaccionList;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Cliente email;
    @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta")
    @ManyToOne(optional = false)
    private TipoCuenta idTipoCuenta;

    public Cuenta() {
    }

    public Cuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(String idCuenta, Date fecha, float saldo, String estado) {
        this.idCuenta = idCuenta;
        this.fecha = fecha;
        this.saldo = saldo;
        this.estado = estado;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//    @XmlTransient
//    public List<Transaccion> getTransaccionList() {
//        return transaccionList;
//    }
//
//    public void setTransaccionList(List<Transaccion> transaccionList) {
//        this.transaccionList = transaccionList;
//    }

    public Cliente getEmail() {
        return email;
    }

    public void setEmail(Cliente email) {
        this.email = email;
    }

    public TipoCuenta getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(TipoCuenta idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication107.Cuenta[ idCuenta=" + idCuenta + " ]";
    }

}

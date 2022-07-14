package Entity;

import java.io.Serializable;
import javax.persistence.*;
import Entity.Users;


@Entity
@Table(name = "transaccion_cuenta")

@NamedQueries({
        @NamedQuery(name = "TransaccionCuenta.findAll", query = "SELECT t FROM TransaccionCuenta t"),
        @NamedQuery(name = "TransaccionCuenta.findByCuentaIdCuenta", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.cuentaidCuenta = :idcuenta"),
        @NamedQuery(name = "TransaccionCuenta.findByTransaccionIdTransaccion", query = "SELECT t FROM TransaccionCuenta t WHERE t.transaccionCuentaPK.transaccionidTransaccion= :idtransaccion")})
public class TransaccionCuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TransaccionCuentaPK transaccionCuentaPK;
    @JoinColumn(name = "cuentaid_cuenta", referencedColumnName = "id_cuenta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "transaccionid_transaccion", referencedColumnName = "id_transaccion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users transaccion;

    public TransaccionCuenta() {
    }

    public TransaccionCuenta(TransaccionCuentaPK transaccionCuentaPK) {
        this.transaccionCuentaPK = transaccionCuentaPK;
    }

    public TransaccionCuenta(String cuentaidCuenta, int transaccionidTransaccion) {
        this.transaccionCuentaPK = new TransaccionCuentaPK(cuentaidCuenta, transaccionidTransaccion);
    }

    public TransaccionCuentaPK getTransaccionCuentaPK() {
        return transaccionCuentaPK;
    }

    public void setTransaccionCuentaPK(TransaccionCuentaPK transaccionCuentaPK) {
        this.transaccionCuentaPK = transaccionCuentaPK;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Users getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Users transaccion) {
        this.transaccion = transaccion;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionCuentaPK != null ? transaccionCuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionCuenta)) {
            return false;
        }
        TransaccionCuenta other = (TransaccionCuenta) object;
        if ((this.transaccionCuentaPK == null && other.transaccionCuentaPK != null) || (this.transaccionCuentaPK != null && !this.transaccionCuentaPK.equals(other.transaccionCuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication107.TransaccionCuenta[ transaccionCuentaPK=" + transaccionCuentaPK + " ]";
    }

}

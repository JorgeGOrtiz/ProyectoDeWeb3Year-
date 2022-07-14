package Entity;

import java.io.Serializable;
import javax.persistence.*;
@Embeddable
public class TransaccionCuentaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "cuentaid_cuenta")
    private String cuentaidCuenta;
    @Basic(optional = false)
    @Column(name = "transaccionid_transaccion")
    private int transaccionidTransaccion;


    public TransaccionCuentaPK() {
    }

    public TransaccionCuentaPK(String cuentaidCuenta, int transaccionidTransaccion) {
        this.cuentaidCuenta = cuentaidCuenta;
        this.transaccionidTransaccion = transaccionidTransaccion;
    }

    public String getCuentaidCuenta() {
        return cuentaidCuenta;
    }

    public void setCuentaidCuenta(String cuentaidCuenta) {
        this.cuentaidCuenta = cuentaidCuenta;
    }

    public int getTransaccionidTransaccion() {
        return transaccionidTransaccion;
    }

    public void setTransaccionidTransaccion(int transaccionidTransaccion) {
        this.transaccionidTransaccion = transaccionidTransaccion;

    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaidCuenta != null ? cuentaidCuenta.hashCode() : 0);
        hash += (int) transaccionidTransaccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionCuentaPK)) {
            return false;
        }
        TransaccionCuentaPK other = (TransaccionCuentaPK) object;
        if ((this.cuentaidCuenta == null && other.cuentaidCuenta != null) || (this.cuentaidCuenta != null && !this.cuentaidCuenta.equals(other.cuentaidCuenta))) {
            return false;
        }
        if (this.transaccionidTransaccion != other.transaccionidTransaccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "javaapplication107.TransaccionCuentaPK[ cuentaidCuenta=" + cuentaidCuenta + ", transaccionidTransaccion=" + transaccionidTransaccion + " ]";
    }
}

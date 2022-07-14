package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tipoCuenta")

@NamedQueries({
        @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
        @NamedQuery(name = "TipoCuenta.findByIdTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.idTipoCuenta = :idTipoCuenta"),
        @NamedQuery(name = "TipoCuenta.findByNombre", query = "SELECT t FROM TipoCuenta t WHERE t.nombre = :nombre"),
        @NamedQuery(name = "TipoCuenta.findByInteres", query = "SELECT t FROM TipoCuenta t WHERE t.interes = :interes"),
        @NamedQuery(name = "TipoCuenta.findByFondoMinimo", query = "SELECT t FROM TipoCuenta t WHERE t.fondoMinimo = :fondoMinimo")})
public class TipoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cuenta")
    private Integer idTipoCuenta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "interes")
    private Integer interes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fondo_minimo")
    private Float fondoMinimo;
    /** @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCuenta")
    private List<Cuenta> cuentaList;
     **/
    public TipoCuenta(){}
    public TipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public TipoCuenta(Integer idTipoCuenta, String nombre, Integer interes, Float fondoMinimo) {
        this.idTipoCuenta = idTipoCuenta;
        this.nombre = nombre;
        this.interes = interes;
        this.fondoMinimo = fondoMinimo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public Float getFondoMinimo() {
        return fondoMinimo;
    }

    public void setFondoMinimo(Float fondoMinimo) {
        this.fondoMinimo = fondoMinimo;
    }

    /**@XmlTransient
    public List<Cuenta> getCuentaList() {
    return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
    this.cuentaList = cuentaList;
    }
     **/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuenta != null ? idTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.idTipoCuenta == null && other.idTipoCuenta != null) || (this.idTipoCuenta != null && !this.idTipoCuenta.equals(other.idTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCuenta{" +
                "idTipoCuenta=" + idTipoCuenta +
                ", nombre='" + nombre + '\'' +
                ", interes=" + interes +
                ", fondoMinimo=" + fondoMinimo +
                '}';
    }
}

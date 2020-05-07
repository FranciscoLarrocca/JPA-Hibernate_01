package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Francisco Larrocca
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "id_venta")
    private int idVenta;

    @Column(name = "monto")
    private int monto;

    @Column(name = "fecha")
    private LocalDate fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Empleado")
    private Empleado empleado;

    public Venta() {
    }

    public Venta(int idVenta, int monto, LocalDate fechaVenta, Empleado empleado) {
        this.idVenta = idVenta;
        this.monto = monto;
        this.fechaVenta = fechaVenta;
        this.empleado = empleado;
        empleado.agregarVenta(this);
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        empleado.agregarVenta(this);
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", monto=" + monto + ", fechaVenta=" + fechaVenta + ", " + empleado + '}';
    }

}

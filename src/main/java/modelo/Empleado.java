package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Francisco Larrocca
 */
@Entity //Se declara la clase Empleado como entidad
@Table(name = "empleado") //Se le dice al proveedor JPA que este bean (Empleado) se corresponda a un tabla de BD
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //Se define el identificador de la entidad
    @Column(name = "id_Empleado")
    private int idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Venta> ventas = new ArrayList<Venta>();

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        direccion.setEmpleado(this);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void agregarVenta(Venta v) {
        ventas.add(v);
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

}

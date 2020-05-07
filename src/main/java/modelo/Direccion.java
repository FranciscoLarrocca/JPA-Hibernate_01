
package modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Franciso Larrocca
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "id_direccion")
    private int idDireccion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "pais")
    private String pais;

    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY) //Se indica que la entidad direccion es hija de la entidad Empleado, por medio del atributo direccion, establecido en Empleado
    private Empleado empleado;

    public Direccion() {
    }

    public Direccion(int idDireccion, String direccion, String localidad, String provincia, String pais) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + ", pais=" + pais + ", Empleado=" + empleado.getIdEmpleado() + '}';
    }

}

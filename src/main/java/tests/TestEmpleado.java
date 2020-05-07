package tests;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Direccion;
import modelo.Empleado;
import modelo.Venta;

/**
 *
 * @author Francisco Larrocca
 */
public class TestEmpleado {

    //1-. @PersistenceContext(unitName = "JPA_Hibernate-PU") -> De esta forma se puede implementar la interfaz EntityManger, en Java EE
    private static EntityManager em; //Gestor que nos deja manipular los elementos de la base de datos (realizar operaciones CRUD, transacciones, etc).

    //Idem 1-.
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        //Creamos el gestor de persistencia em.
        emf = Persistence.createEntityManagerFactory("JPA-Hibernate-PU");
        em = emf.createEntityManager();

        Empleado e1 = new Empleado(10, "Juan", "Perez", LocalDate.of(1978, 6, 6));
        e1.setDireccion(new Direccion(1, "Calle Falsa 123", "La Plata", "Buenos Aires", "Argentina"));

        Empleado e2 = new Empleado(11, "Marcelo", "Suarez", LocalDate.of(1977, 8, 4));
        e2.setDireccion(new Direccion(2, "Calle Falsa 321", "Olavarria", "Buenos Aires", "Argentina"));

        Venta v1 = new Venta(1, 200, LocalDate.of(2020, Month.MARCH, 3), e1);
        Venta v2 = new Venta(2, 300, LocalDate.of(2020, Month.MARCH, 4), e1);
        Venta v3 = new Venta(3, 350, LocalDate.of(2020, Month.MARCH, 6), e2);

        em.getTransaction().begin();

        //Persistir las entidades Empleado
        em.persist(e1);
        em.persist(e2);

        //Persistir las entidades Venta
        em.persist(v1);
        em.persist(v2);
        em.persist(v3);

        em.getTransaction().commit();

        imprimirTablaEmpleados();

        imprimirVentas(10);
        imprimirVentas(11);

        em.close();
    }

    private static void imprimirTablaEmpleados() {
        //Listar empleados:
        List<Empleado> empleados = (List<Empleado>) em.createQuery("FROM Empleado").getResultList();

        System.out.println("En la BD hay: " + empleados.size() + " empleados");

        for (Empleado e : empleados) {
            System.out.println(e);
        }

        System.out.println("- Fin empleados -");
    }

    private static void imprimirVentas(int id_empleado) {
        //Listar ventas del empleado emp:
        Empleado e = em.find(Empleado.class, id_empleado);

        List<Venta> ventas = e.getVentas();

        System.out.println("El empleado con id: " + e.getIdEmpleado() + ", tiene un total de: " + ventas.size() + " ventas");

        for (Venta v : ventas) {
            System.out.println(v);
        }

        System.out.println("- Fin ventas del empleado: " + e.getNombre() + " " + e.getApellido());
    }
}

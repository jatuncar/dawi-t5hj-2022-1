package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// -- actualizar un usuario

		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();

		// ....acciones
		// update set .....
		Usuario u = new Usuario(55, "Juan", "Pérez", "jjper@mail.com", "555", "2000/12/11", 2, 1);
		em.merge(u); // si existe el código -> actualiza / sino existe -> lo crea

		em.getTransaction().commit();
		em.close();

	}
}

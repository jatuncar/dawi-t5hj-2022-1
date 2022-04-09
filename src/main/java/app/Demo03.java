package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// eliminar un usuario

		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();

		// ....acciones
		// forma 1. delete ... where codigo  -> borrado físico
		// forma 2. update estado  where codigo... --> borrado lógico (cambiar estado)
		Usuario u = new Usuario();
		u.setCodigo(55);

		em.remove(u); // !!! se necesita pasar un objeto --> buscar y devolver..

		em.getTransaction().commit();
		em.close();

	}
}

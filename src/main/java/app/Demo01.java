package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// -- registrar un nuevo usuario
		
		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// manejador de entidad
		EntityManager em = fabrica.createEntityManager();
		
		// empezar los procesos --> registro,actualización,eliminación
		em.getTransaction().begin();
		
		// ....acciones
		// insert into .....
		Usuario u = new Usuario(13, "Zoila", "Baca", "zoila@mail.com", "1234",
					"2000/12/01", 1, 1);
		em.persist(u);
		
		// confirmación de procesos
		em.getTransaction().commit();
		
		// cerrar manejador
		em.close();
	}
	
}

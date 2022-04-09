package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// listado de todos los usuarios

		// fabrica de acceso de datos --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// ....acciones
		// select * from tb_usuarios 
		TypedQuery<Usuario> consulta = em.createQuery("select x from Usuario x",Usuario.class);
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		//List<Usuario> lstUsuarios = em.createQuery("select x from Usuario x",Usuario.class).getResultList();
		
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}

		em.close();

	}
}

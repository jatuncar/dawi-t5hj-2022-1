package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Usuario;

public class Login {

	public static void main(String[] args) {
		String usuario, clave;
		
		usuario = "u001@gmail.com"; // JOptionPane.showInputDialog("Ingrese usuario :");
		clave = "10001"; // JOptionPane.showInputDialog("Ingrese clave :");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Usuario> consulta = 
		em.createQuery("select u from Usuario u where u.usuario = :xusr and u.clave = :xcla", Usuario.class);
		consulta.setParameter("xusr", usuario);
		consulta.setParameter("xcla", clave);
		
		Usuario u = consulta.getSingleResult();
		System.out.println(u);
		
		em.close();
		
		
	}
	
}

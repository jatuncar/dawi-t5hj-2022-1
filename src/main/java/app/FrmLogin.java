package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setBounds(324, 29, 89, 23);
		contentPane.add(btnIngresar);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);

		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);

	}

	private JTextField txtClave;

	void ingresar() {
		String usuario, clave;

		usuario = txtUsuario.getText(); 
		clave = txtClave.getText(); 

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Usuario> consulta = em
				.createQuery("select u from Usuario u where u.usuario = :xusr and u.clave = :xcla", Usuario.class);
		consulta.setParameter("xusr", usuario);
		consulta.setParameter("xcla", clave);

		Usuario u = null;
		try {
			u = consulta.getSingleResult();
		} catch (Exception e) {
			System.out.println("Usuario no existe...");
		}
		System.out.println(u);

		em.close();
	}
}

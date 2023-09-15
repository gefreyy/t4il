package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Producto;
import model.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JButton btnIngresar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(113, 23, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setBounds(113, 54, 86, 20);
		contentPane.add(txtContra);
		txtContra.setColumns(10);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(10, 57, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar();
			}
		});
		btnIngresar.setBounds(335, 22, 89, 23);
		contentPane.add(btnIngresar);
	}
	
	void Ingresar() {
		// 1. Obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. Crear un manejador de las entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where idtipo = ? --> Lista
		int xtipo = 1;
		String sql = "select u from Usuario where u.idtipo = :xtipo";
		List<Usuario> lstUsuarios = em.createQuery(sql, Usuario.class).setParameter("xtipo", xtipo).getResultList();
		
		//añaña
		Usuario us = new Usuario();
		us.setNom_usua(txtUsuario.getText());
		us.setCla_usua(txtContra.getText());
		
		// Mostrar el contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo....: " + u.getCod_usua());
			System.out.println("Nombre....: " + u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("Tipo....: " + u.getIdtipo());
			System.out.println("----------------------------");
		}
		em.close();	
	}
}

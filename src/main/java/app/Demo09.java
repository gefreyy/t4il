package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

//GUI

public class Demo09 {
	// Realizar el listado de usuarios segun un criterio
	
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		
		// 1. Obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. Crear un manejador de las entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where idtipo = ? --> Lista
		int xtipo = 1;
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
			
			// Mostrar el contenido del usuario (ya no es de tipo lista)
			JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNom_usua());
			
			//Abrir la ventana principal después de loguearse
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			
			// dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Usuario o clave incorrecto");
		}
		
		em.close();
	}
	
}

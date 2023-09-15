package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo05 {
	// Realizar el registro de un nuevo Usuario usando valores fijos
	
	public static void main(String[] args) {
		// 1. Obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. Crear un manejador de las entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		String sql = "select u from Usuario";
		List<Usuario> lstUsuarios = em.createQuery(sql, Usuario.class).getResultList();
		
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

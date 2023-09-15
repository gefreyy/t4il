package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo01 {
	// Realizar el registro de un nuevo Usuario usando valores fijos
	
	public static void main(String[] args) {
		// 1. Obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. Crear un manejador de las entidades
		EntityManager em = fabrica.createEntityManager();
		
		// Procesos
		Usuario u = new Usuario();
		u.setCod_usua(123);
		u.setNom_usua("Jose");
		u.setApe_usua("Perez");
		u.setUsr_usua("jperez");
		u.setCla_usua("1111");
		u.setFna_usua("2005/08/27");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		// Si el proceso es eliminar/actualizar/registrar necesitan transacciones
		em.getTransaction().begin();
		em.persist(u);
		
		// Update tb_xxx set campo=?.... where ....
		em.merge(u);
		
		// Delete from tb_xxx where...
		em.remove(u);
		
		// Select * from tb_xxx where id=?
		Usuario x = em.find(Usuario.class, 1);
		
		em.getTransaction().commit();
		
		System.out.println("Registro OK");
		
		em.close();	
	}
	
}

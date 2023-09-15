package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

//GUI

public class Demo06 {
	// Listado de TODOS los usuarios
	
	public static void main(String[] args) {
		// 1. Obtener la conexión -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		//2. Crear un manejador de las entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		String sql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(sql, Producto.class).getResultList();
		
		// Mostrar el contenido del listado
		for (Producto p : lstProductos) {
			System.out.println("Codigo....: " + p.getId_prod());
			System.out.println("Descripcion....: " + p.getDes_prod());
			System.out.println("Categoría....: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor....: " + p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------------");
		}
		em.close();
	}
	
}

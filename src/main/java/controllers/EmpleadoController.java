package controllers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Empleado;

public class EmpleadoController {
	//CREAR USUARIO
		public String createEmpleado(String nombre, String apellido, int edad,String sexo,Double salario) {
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
	            Empleado empelado = new Empleado(nombre, apellido,edad,sexo,salario);
	            
	            session.beginTransaction();
	            session.save(empelado);
	            session.getTransaction().commit();
	            sessionFactory.close();
	            return "Empleado creado";
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        } 
			return "Error al crear el Empleado";
		}
		//ELIMINAR EMPLEADO
		public String deleteEmpleado(int IdEmpleado) { 
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			try {
				session.beginTransaction();
				Empleado empelado = session.get(Empleado.class, IdEmpleado);
				session.delete(empelado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Empleado eliminado correctamente";
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return "Error al eliminar Empleado";
		}
		//ACTUALIZAR EMPLEADO
		public String updateEmpleado(int IdEmpleado,String nombre,String apellido) { 
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			try {
				session.beginTransaction();
				Empleado empelado = session.get(Empleado.class, IdEmpleado);
				empelado.setNombre(nombre);
				empelado.setApellido(apellido);
				session.update(empelado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Empleado actualizado correctamente";
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return "Error al actualizar Empleado";
		}
		//BUSCAR EMPLEADO
		public Empleado readerEmpleado(int IdEmpleado) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			try {
				session.beginTransaction();
				Empleado empelado = session.get(Empleado.class, IdEmpleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return empelado;
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

}

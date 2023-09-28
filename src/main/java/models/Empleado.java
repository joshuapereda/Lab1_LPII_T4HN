package models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")

public class Empleado {
	@Id
	@Column(name = "IdEmpleado")
	private int IdEmpleado;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "salario")
	private double salario;
	
	public Empleado(String nombre, String apellido, int edad,String sexo, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad=edad;
		this.sexo=sexo;
		this.salario=salario;
		
	}

	public int getIdEmpleado() {
		return IdEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Empleado [idempleado=" + IdEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
		+ edad +",sexo="+sexo+",salario="+salario+"]";
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

}

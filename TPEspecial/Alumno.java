package TPEspecial;

import java.util.ArrayList;

public class Alumno extends ElementoUniversidad {

	private String apellido;
	private int dni;
	private int edad;
	private ArrayList<String> intereses; 
	public Alumno(String nombre, String apellido, int dni, int edad) {
		super(nombre);
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.intereses = new ArrayList<>();
	}
	
	public String getApellido() {
		return apellido;
	}
	public int getDni() {
		return dni;
	}
	public int getEdad() {
		return edad;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void addInteres(String interes) {
		if(!intereses.contains(interes)) {
			intereses.add(interes);
		}
	}

	public boolean equals(Object o) {
		try {
			Alumno otro = (Alumno)o;
			return this.getDni() == otro.getDni();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + this.getNombre() + ", apellido=" + apellido + "]\n";
	}
	@Override
	public int getCantidadAlumnos() {
		return 1;
	}

	
}

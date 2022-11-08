package TPEspecial;

import java.util.ArrayList;

public class Alumno implements Comparable<Alumno>{
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private ArrayList<String> intereses; //se puede usar aca el arra?? o usar la lista??
	public Alumno(String nombre, String apellido, int dni, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.intereses = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
			return this.getApellido().equals(otro.getApellido()) &&
					this.getNombre().equals(otro.getNombre()) &&
					this.getDni() == otro.getDni();
		}
		catch(Exception e) {
			return false;
		}
	}
	@Override
	public int compareTo(Alumno o) {
		
		return this.getEdad() - o.getEdad();
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad + "]";
	}
	
}

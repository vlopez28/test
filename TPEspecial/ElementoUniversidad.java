package TPEspecial;

public abstract class ElementoUniversidad {
	private String nombre;
	
	public ElementoUniversidad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public abstract int getCantidadAlumnos();


	@Override
	public String toString() {
		return "Grupo: [nombre=" + nombre ;
	}
	
}

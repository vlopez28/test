package TPEspecial;

import java.util.ArrayList;

public class Grupo extends ElementoUniversidad{ 
	
	private ArrayList<ElementoUniversidad> elem;
	
	public Grupo(String nombre) {
		super(nombre);
		this.elem = new ArrayList<ElementoUniversidad>();
	}
	
	public void addElem(ElementoUniversidad elem) {
		if(elem != null && !this.elem.contains(elem))
			this.elem.add(elem);
	}
	
	@Override 
	public int getCantidadAlumnos() {
		int res = 0;
		for(ElementoUniversidad e: elem) { 
			res+= e.getCantidadAlumnos();
		}
		return res;
	}

	public boolean equals(Object o) {
		try {
			Grupo otro = (Grupo)o;
			return this.getNombre().toLowerCase().equals(otro.getNombre().toLowerCase()) &&
				   this.getCantidadAlumnos() == otro.getCantidadAlumnos();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		for(ElementoUniversidad e: elem) { 
			res+= "\n"+e.toString();
		}
		return res + "]";
	}
	
}

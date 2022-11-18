package TPEspecial;

import java.util.Comparator;

public class ComparadorCantAlumnos implements Comparator<ElementoUniversidad>{

	@Override
	public int compare(ElementoUniversidad o1, ElementoUniversidad o2) {
		
		return o2.getCantidadAlumnos() - o1.getCantidadAlumnos(); //de mayor a menor
	}

}

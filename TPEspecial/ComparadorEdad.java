package TPEspecial;

import java.util.Comparator;

public class ComparadorEdad implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		return o1.getEdad() - o2.getEdad();
	}

}

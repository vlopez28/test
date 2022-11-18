package TPEspecial;

import java.util.Comparator;

public class ComparadorNotGenerico<T> implements Comparator<T>{
	
	private Comparator<T> comun;
	
	public ComparadorNotGenerico(Comparator<T> comun) {
		this.comun = comun;
	}


	@Override
	public int compare(T o1, T o2) {
		
		return (-1)*comun.compare(o1, o2);
	}

}

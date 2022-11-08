package TPEspecial;

import java.util.Comparator;

public class ComparadorIntDescendente implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o2 - o1;
	}

}
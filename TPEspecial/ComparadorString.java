package TPEspecial;

import java.util.Comparator;

class ComparadorString implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return o1.compareTo(o2);
	}

}

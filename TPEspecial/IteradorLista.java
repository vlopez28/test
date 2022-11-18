package TPEspecial;

import java.util.Iterator;


public class IteradorLista<T> implements Iterator<T>{
		
	Nodo<T> actual;
	
	public IteradorLista(Nodo<T> primero) {
		actual = primero;
	}

	@Override
	public boolean hasNext() {
		return this.actual != null;
			
	}

	@Override
	public T next() {
		T valor = actual.getValor(); 
		actual = actual.obtenerSiguiente();
		return valor;
	}
}



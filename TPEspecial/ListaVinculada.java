package TPEspecial;

import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T>{
	private Nodo<T> primero; 
	private int tamanio;
	private Comparator<T> criterio;
	
	public ListaVinculada (Comparator<T> c) {
		this.criterio = c;
		primero = null;
		tamanio = 0;
	}
	public ListaVinculada(Comparator<T> c, Nodo<T> n) {
		this.criterio = c;
		this.primero = n;
		this.tamanio = 1;
	}
	private Nodo<T> getPrimero() {
		return primero;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setComparador(Comparator<T> c) {
		this.criterio = c;
		this.reordenarLista();
	}
	
	private void reordenarLista() {
	     Nodo<T> aux = primero;
	     tamanio = 0;
	     primero = null;
	     while (aux!= null) {
	    	this.insertar(aux.getValor());
	    	aux = aux.obtenerSiguiente();
	    }
	} 
	
	public void insertar(T valor) {
		Nodo<T> nuevo = new Nodo<T>(valor);
		if(primero == null) {
			primero = nuevo;
		} else {
			Nodo<T> actual = primero;
			boolean encontro = false; 
			int res = criterio.compare(actual.getValor(), nuevo.getValor());
			if(res >= 1) {
				nuevo.enlazarSiguiente(actual);
				primero = nuevo;
			} else {
				while(actual.obtenerSiguiente() != null && !encontro) {
					res = criterio.compare(actual.obtenerSiguiente().getValor(), nuevo.getValor());
					if(res >= 1) {
						Nodo<T> temp = actual.obtenerSiguiente();
						actual.enlazarSiguiente(nuevo);
						nuevo.enlazarSiguiente(temp);
						encontro = true;
					} else {
						actual = actual.obtenerSiguiente();
					}
				}
				if(!encontro) {
					actual.enlazarSiguiente(nuevo);
				}
			}
		}
		tamanio++;
	}
	
	
	public void eliminarEnPosicion(int pos) { 
		Nodo<T> actual = primero;
		int contador  = 1;
		if(pos == 0) {
			actual = actual.obtenerSiguiente();
			primero = actual;
			tamanio--;
			return;
		}
		while(contador < pos && actual != null) {
			actual = actual.obtenerSiguiente();
			contador++;
		}
		if(contador == pos) { 
			actual.enlazarSiguiente(actual.obtenerSiguiente().obtenerSiguiente());
			tamanio--;
		} 
	}
	
	public void eliminarTodasOcurrencias(T elem) {
		Nodo<T> actual = primero;
		Nodo<T> anterior = primero;
		while(!actual.getValor().equals(elem)) {
			anterior = actual;
			actual = actual.obtenerSiguiente();
		}
		while(actual.getValor().equals(elem)) {
			actual = actual.obtenerSiguiente();
		}
		if(primero.getValor().equals(elem)) { 
			primero = actual;
		} else {
			anterior.enlazarSiguiente(actual);
		}
	}
	
	
	public int obtenerPosElem(T elem) {
		int posicion = 0;
		if(primero == null) {
			return -1; 
		}
		Nodo<T> temp = primero;
		while(posicion < getTamanio() && temp != null) {
			if(temp.getValor().equals(elem)) {
				return posicion;
			} else {
				temp = temp.obtenerSiguiente();
				posicion++;
			}
		} 
		return -1;
	}
	
	
	@Override
	public Iterator<T> iterator() {	
		return new IteradorLista<T>(primero);
	}

	public String toString() {
		int contador = 1;
		String res = "{ tamanio: "+getTamanio();
		
		for(T e: this) { 
			res+= "\n Elemento num: "+contador+ "\n"+e.toString();
			contador ++;
		}
		return res + "}";
	}
	
}

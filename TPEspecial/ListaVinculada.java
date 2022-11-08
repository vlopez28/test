package TPEspecial;

import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada  implements Iterable<Comparable>{
	protected Nodo primero; // estaria bien poner protected para acceder desde clase iterador
	protected int tamanio;///tiene que tener un atributo tamanio?
	protected Comparator criterio;
	
	public ListaVinculada(Comparator c) {
		this.criterio = c;
		primero = null;
		tamanio = 0;
	}
	public ListaVinculada(Comparator c, Nodo n) {
		this.criterio = c;
		this.primero = n;
		this.tamanio = 1;
	}
	public void setComparador(Comparator c) {
		this.criterio = c;
		this.reordenarLista(c);//esta bien ponerlo aca?
	}
	
	public Nodo getPrimero() {
		return primero;
	}
	public int verTamanio() {
		return tamanio;
	}
	//es necesario este metodo?
	public boolean estaVaciaLista() {
		if(primero == null)
			return true;
		return false;
	}
	
	public String imprimirLista() {
		Nodo actual = primero;
		String resultado = "[";
		if(this.estaVaciaLista()) {
			return "[]";
		}
		do {
			resultado += actual.getValor()+", ";
			actual = actual.obtenerSiguiente();
		} while(actual != null);
		
		return resultado + "]";
	}
	
	public Comparable obtenerObjeto(int pos) {
		int contador = 0;
		if(this.estaVaciaLista()) {
			return null; //esta bien retornar null? si no hya obejcto que retorno??
		}
		Nodo temp = primero;
		while(contador < pos && temp != null) {
			temp = temp.obtenerSiguiente();
			contador++;
		} 
		if(temp == null) {
			return null; // no hay objeto en esa posicion
		}
		return temp.getValor();
	}
	
	
	public void insertar(Comparable comp) {
		Nodo nuevo = new Nodo(comp);
		if(primero == null) {
			primero = nuevo;
		} else {
			Nodo actual = primero;
			boolean encontro = false; ////1 3 .. 8 9 .. quiero insertar 5
			int res = criterio.compare(actual.getValor(), nuevo.getValor());
			if(res >= 1) {//el actual es mayor ... caso en que sea 0
				nuevo.enlazarSiguiente(actual);
				primero = nuevo;
			} else {
				while(actual.obtenerSiguiente() != null && !encontro) {
					res = criterio.compare(actual.obtenerSiguiente().getValor(), nuevo.getValor());
					if(res >= 1) {
						Nodo temp = actual.obtenerSiguiente();
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
	//validar metodo eliminar
	public String eliminarEnPosicion(int pos) { //1 5 10 11 21...tamanio 5.. elimianr pos 0
		if(pos >= tamanio) { // esto esta bien ?
			return "no existe pos"; // que retorna si la pos es mayor al tamanio y no se puede borrar?
		}
		else {
			Nodo actual = primero;
			int contador  = 1;
			while(contador < pos && actual != null) {
				actual = actual.obtenerSiguiente();
				contador++;
			}
			if(contador == pos) { //sale xq encontro pos
				actual.enlazarSiguiente(actual.obtenerSiguiente().obtenerSiguiente());
				System.out.println("elimino: ");
			}
			else if(pos == 0) { //sale porque pos es cero
				actual = actual.obtenerSiguiente();
				primero = actual;
			}
		}
		tamanio--;
		
		return "eliminado con exito";
	}
	//no retorna nada si no hay pos no elimina y no hace nada no retorna nada
	public void eliminarEnPosicionMejorado(int pos) { //VALIDAR
		Nodo actual = primero;
		int contador  = 1;
		if(pos == 0) {
			System.out.println("hola");
			actual = actual.obtenerSiguiente();
			primero = actual;
			return;
		}
		while(contador < pos && actual != null) {
			actual = actual.obtenerSiguiente();
			contador++;
		}
		if(contador == pos) { //sale xq encontro pos, si el contado es igual a pos significa que no es null
			actual.enlazarSiguiente(actual.obtenerSiguiente().obtenerSiguiente());
		} 
		tamanio--;
	}
	
	public void eliminarTodasOcurrencias(Comparable elem) {
		Nodo actual = primero;
		while(actual != null) {		
			if(actual.getValor().equals(elem)) {//si es un int esto funciona???
				int posABorrar = this.obtenerPosElem(actual.getValor()); // busco pos xq al borrar cambia
				actual = actual.obtenerSiguiente();
				this.eliminarEnPosicionMejorado(posABorrar);
			} else {
				actual = actual.obtenerSiguiente();
			}
		}
	}
	
	public int obtenerPosElem(Comparable elem) {
		int posicion = 0;
		if(primero == null) {
			return -1; //esta bien retornar null?
		}
		Nodo temp = primero;
		while(posicion < tamanio && temp != null) {
			if(temp.getValor().equals(elem)) {
				return posicion;
			} else {
				temp = temp.obtenerSiguiente();
				posicion++;
			}
		} 
		return -1;
	}
	
	public void reordenarLista(Comparator c) {
		ListaVinculada reordenada = new ListaVinculada(c);
		for (Comparable elem:this) {
			reordenada.insertar(elem);
		}
		primero = reordenada.getPrimero();
	}
	
	@Override
	public Iterator<Comparable> iterator() {	
		return new IteradorComparable();
	}
	//--------------------------------------------//
	private class IteradorComparable implements Iterator<Comparable>{
		
		Nodo actual;
		int pos;
		
		public IteradorComparable() {
			actual = primero;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			if(pos < tamanio)//esta bien usar el tamanio
				return true;
			return false;
		}

		@Override
		public Comparable next() {
			pos++;
			Comparable aux = obtenerObjeto(pos-1); 
			actual = actual.obtenerSiguiente();
			return aux;
		}
	}
}

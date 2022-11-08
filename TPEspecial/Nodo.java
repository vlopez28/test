package TPEspecial;

public class Nodo {
	private Comparable valor; // en vez de object iria comparable??XQ me hace el warning?
	private Nodo siguiente;
	
	public Nodo(Comparable valor) {
		this.valor = valor;
		this.siguiente = null;
	}
	
	public Nodo obtenerSiguiente() {
		return siguiente;
	}
	
	public Comparable getValor() {
		return valor;
	}
	
	public void setValor(Comparable dato) {
		this.valor = dato;
	}

	public void enlazarSiguiente(Nodo sig) {
		siguiente = sig;
	}

	
}

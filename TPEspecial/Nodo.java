package TPEspecial;

public class Nodo<T> {
	private T valor;
	private Nodo<T> siguiente;
	
	public Nodo(T valor) {
		this.valor = valor;
		this.siguiente = null;
	}
	
	public Nodo<T> obtenerSiguiente() {
		return siguiente;
	}
	
	public T getValor() {
		return valor;
	}
	
	public void setValor(T dato) {
		this.valor = dato;
	}

	public void enlazarSiguiente(Nodo<T> sig) {
		siguiente = sig;
	}

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

	
}

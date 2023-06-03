package co.edu.unbosque.model;

public class Nodo {
	
	private int dato;
	private String operador;
	private Nodo izquierda;
	private Nodo derecha;

	public Nodo(int dato, String operador) {
		this.dato = dato;
		this.operador = operador;
		this.izquierda = null;
		this.derecha = null;
	}

	public Nodo(Object info) {
		// TODO Auto-generated constructor stub
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Nodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}

	public Nodo getDerecha() {
		return derecha;
	}

	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
}
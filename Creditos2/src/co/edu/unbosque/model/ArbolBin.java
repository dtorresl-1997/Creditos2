package co.edu.unbosque.model;

import java.util.Stack;

public class ArbolBin {

	public Nodo raiz;

	public ArbolBin() {
		this.raiz = null;
	}

	public boolean vacio() {
		return raiz == null;
	}

	public void adicionar(Nodo nodo) {
		if (vacio()) {
			this.raiz = nodo;
		} else {
			this.adicionar(this.raiz, nodo);
		}
	}

	private void adicionar(Nodo padre, Nodo nodo) {
		if (nodo.getDato() > padre.getDato()) {
			if (padre.getDerecha() == null) {
				padre.setDerecha(nodo);
			} else {
				this.adicionar(padre.getDerecha(), nodo);
			}
		} else {
			if (padre.getIzquierda() == null) {
				padre.setIzquierda(nodo);
			} else {
				this.adicionar(padre.getIzquierda(), nodo);
			}
		}
	}
	
	public void mostrarArbolInOrden(Nodo nodo) {
	    if (nodo == null) {
	        System.out.println("El árbol está vacío");
	        return;
	    }
	    StringBuilder sb = new StringBuilder();
	    Stack<Nodo> stack = new Stack<>();
	    Nodo actual = nodo;
	    while (actual != null || !stack.isEmpty()) {
	        while (actual != null) {
	            stack.push(actual);
	            actual = actual.getIzquierda();
	        }
	        actual = stack.pop();
	        sb.append(actual.getDato()).append(" ");
	        actual = actual.getDerecha();
	    }
	    System.out.println(sb.toString());
	}

}
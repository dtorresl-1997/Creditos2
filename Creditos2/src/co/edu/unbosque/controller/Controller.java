package co.edu.unbosque.controller;

import java.util.InputMismatchException;

import co.edu.unbosque.model.ArbolBin;
import co.edu.unbosque.model.Nodo;
import co.edu.unbosque.view.View;


public class Controller {

	public View view;
	public ArbolBin arbol;
	
	private Nodo premisaIngresos;
	private Nodo premisaMonto;
	private Nodo premisaRiesgo;
	
	private int monto=0;
	


	public Controller() {

		view = new View();
		arbol = new ArbolBin();
		
		funcionar();
	}

	public void funcionar() {

		String option = null;

		String menu = "****************************************************************************************\n"
					+ "***  SISTEMA EXPERTO PARA OTORGAMIENTO DE CRÉDITOS FINANCIEROS  ***\n"
					+ "****************************************************************************************\n" 
					+ "Operaciones:\n"
					+ "    a. Definir arbol de desicion.\n" 
					+ "    b. Aplicar arbol de decision.\n" 
					+ "    c. Salir.\n"
					+ "\n"
					+ "Opracion a realizar: " + "\n";

		do {
			option = view.leerDatoString(menu);
			switch (option) {
			case "a":
				definirArbol();
				break;
			case "b":
				if(arbol.vacio()) {
					view.mostrarInformacion("El arbol no esta definido");
				}
				else {
		
					decision();
				}
				break;
			case "c":
				view.mostrarInformacion("Hasta Pronto");
				System.exit(0);
				break;
			default:
				view.mostrarInformacion("Error: Opcioninvalida.");
				break;

			}

		} while (!option.equals("c"));

	}
	
	public void definirArbol() {
		view.mostrarInformacion("Inserción de las condiciones para entregar o no el monto");
		definirEdad();
		definirIngresos();
		definirMonto();
		definirRiesgo();
		
	}
	
	public void decision() {
		
		decisionEdad();
		decisionIngresos();
		decisionMonto();
		decisionRiesgo();
		
		view.mostrarInformacion("Su valor: " + monto+ " Fue aprobado con Exito");
		
	}
	
	
	public void definirEdad() {   
		    try {
		        int edad = view.leerDatoEntero("Se iniciará con la edad\n\n" + "Ingrese la edad a usar como base: ");
		        String seleccion = view.leerDatoString("A continuación, ingrese el operador lógico a usar:\n"
		                + "a) Mayor que: >\n" + "b) Menor que: <\n" + "c) Mayor o igual que: >=\n"
		                + "d) Menor o igual que: <=\n" + "e) Diferente de: !=\n");

		        String operadorLogicoEdad = "";
		        switch (seleccion) {
		            case "a":
		                operadorLogicoEdad = ">";
		                break;
		            case "b":
		                operadorLogicoEdad = "<";
		                break;
		            case "c":
		                operadorLogicoEdad = ">=";
		                break;
		            case "d":
		                operadorLogicoEdad = "<=";
		                break;
		            case "e":
		                operadorLogicoEdad = "!=";
		                break;
		            default:
		                view.mostrarInformacion("Ingrese un carácter válido");
		                return;
		        }

		        Nodo premisaEdad = new Nodo(edad,operadorLogicoEdad);

		        String seleccion2 = view.leerDatoString("Ahora se debe definir qué hacer en caso de que no se cumpla la condición establecida \n\n"
		                + "Para la edad:\n" + "a) Cerrar el programa\n" + "b) Continuar \n");

		        switch (seleccion2) {
		            case "a":
		                Nodo decisionCerrar = new Nodo(11, "Cerrar");
		                premisaEdad.setDerecha(decisionCerrar);
		                break;
		            case "b":
		                Nodo decisionReiniciar = new Nodo(11, "Continuar");
		                premisaEdad.setDerecha(decisionReiniciar);
		                break;
		            default:
		                view.mostrarInformacion("Ingrese un carácter válido");
		                return;
		        }

		        arbol.adicionar(premisaEdad);

		        view.mostrarInformacion("Premisa añadida con éxito");
		        view.mostrarInformacion("La premisa quedó definida de la siguiente manera: edad " + operadorLogicoEdad + " " + edad);
		    } catch (InputMismatchException e) {
		        view.mostrarInformacion("Error en la inserción, inténtelo de nuevo");
		        view.mostrarInformacion("\n\n");
		    }
		}
	public void definirIngresos(){ 

    try {
        int ingresos = view.leerDatoEntero("Definicion de la premisa con los ingresos del usuario\n\n" 
        							+ "Ingrese los ingresos a usar como base: ");
        String seleccion = view.leerDatoString("A continuación, ingrese el operador lógico a usar:\n"
                							+ "a) Mayor que: >\n" 
                							+ "b) Menor que: <\n" 
                							+ "c) Mayor o igual que: >=\n"
                							+ "d) Menor o igual que: <=\n" 
                							+ "e) Diferente de: !=\n");

        String operadorLogicoIngresos = "";
        switch (seleccion) {
            case "a":
            	operadorLogicoIngresos = ">";
                break;
            case "b":
            	operadorLogicoIngresos = "<";
                break;
            case "c":
            	operadorLogicoIngresos = ">=";
                break;
            case "d":
            	operadorLogicoIngresos = "<=";
                break;
            case "e":
            	operadorLogicoIngresos = "!=";
                break;
            default:
                view.mostrarInformacion("Ingrese un carácter válido");
                return;
        }

        premisaIngresos = new Nodo(ingresos, operadorLogicoIngresos);
        

        String seleccion2 = view.leerDatoString("Ahora se debe definir qué hacer en caso de que no se cumpla la condición establecida \n\n"
                + "Para los ingresos:\n" + "a) Cerrar el programa\n" + "b) Continuar \n");

        switch (seleccion2) {
            case "a":
                Nodo decisionCerrar = new Nodo(11, "Cerrar");
                premisaIngresos.setDerecha(decisionCerrar);
                break;
            case "b":
                Nodo decisionReiniciar = new Nodo(11, "Continuar");
                premisaIngresos.setDerecha(decisionReiniciar);
                break;
            default:
                view.mostrarInformacion("Ingrese un carácter válido");
                return;
        }

        arbol.adicionar(premisaIngresos);

        view.mostrarInformacion("Premisa añadida con éxito");
        view.mostrarInformacion("La premisa quedó definida de la siguiente manera: ingresos " + operadorLogicoIngresos + " " + ingresos);
    } catch (InputMismatchException e) {
        view.mostrarInformacion("Error en la inserción, inténtelo de nuevo");
        view.mostrarInformacion("\n\n");
    }
		
	}
	public void definirMonto() {
		
		
		try {
	        int monto = view.leerDatoEntero("Definicion de la premisa con el monto que pidio el usuario\n\n" 
	        							+ "ingrese el monto a usar como base: ");
	        this.monto=monto;
	        String seleccion = view.leerDatoString("A continuación, ingrese el operador lógico a usar:\n"
	                							+ "a) Mayor que: >\n" 
	                							+ "b) Menor que: <\n" 
	                							+ "c) Mayor o igual que: >=\n"
	                							+ "d) Menor o igual que: <=\n" 
	                							+ "e) Diferente de: !=\n");

	        String operadorLogicoMonto = "";
	        switch (seleccion) {
	            case "a":
	            	operadorLogicoMonto = ">";
	                break;
	            case "b":
	            	operadorLogicoMonto = "<";
	                break;
	            case "c":
	            	operadorLogicoMonto = ">=";
	                break;
	            case "d":
	            	operadorLogicoMonto = "<=";
	                break;
	            case "e":
	            	operadorLogicoMonto = "!=";
	                break;
	            default:
	                view.mostrarInformacion("Ingrese un carácter válido");
	                return;
	        }

	        premisaMonto = new Nodo(monto, operadorLogicoMonto);
	        

	        String seleccion2 = view.leerDatoString("Ahora se debe definir qué hacer en caso de que no se cumpla la condición establecida \n\n"
	                + "Para el monto:\n" + "a) Cerrar el programa\n" + "b) Continuar \n");

	        switch (seleccion2) {
	            case "a":
	                Nodo decisionCerrar = new Nodo(11, "Cerrar");
	                premisaMonto.setDerecha(decisionCerrar);
	                break;
	            case "b":
	                Nodo decisionReiniciar = new Nodo(11, "Continuar");
	                premisaMonto.setDerecha(decisionReiniciar);
	                break;
	            default:
	                view.mostrarInformacion("Ingrese un carácter válido");
	                return; 
	        }

	        arbol.adicionar(premisaMonto);

	        view.mostrarInformacion("Premisa añadida con éxito");
	        view.mostrarInformacion("La premisa quedó definida de la siguiente manera: ingresos " + operadorLogicoMonto + " " + monto);
	    } catch (InputMismatchException e) {
	        view.mostrarInformacion("Error en la inserción, inténtelo de nuevo");
	        view.mostrarInformacion("\n\n");
	    }
		
	}
	public void definirRiesgo() {
		try {
	        int riesgo = view.leerDatoEntero("Definicion de la premisa con el puntaje de riesgo del usuario\n\n" 
	        							+ "ingrese el puntaje a usar como base: ");
	        String seleccion = view.leerDatoString("A continuación, ingrese el operador lógico a usar:\n"
	                							+ "a) Mayor que: >\n" 
	                							+ "b) Menor que: <\n" 
	                							+ "c) Mayor o igual que: >=\n"
	                							+ "d) Menor o igual que: <=\n" 
	                							+ "e) Diferente de: !=\n");

	        String operadorLogicoRiesgo = "";
	        switch (seleccion) {
	            case "a":
	            	operadorLogicoRiesgo = ">";
	                break;
	            case "b":
	            	operadorLogicoRiesgo = "<";
	                break;
	            case "c":
	            	operadorLogicoRiesgo = ">=";
	                break;
	            case "d":
	            	operadorLogicoRiesgo = "<=";
	                break;
	            case "e":
	            	operadorLogicoRiesgo = "!=";
	                break;
	            default:
	                view.mostrarInformacion("Ingrese un carácter válido");
	                return;
	        }

	        premisaRiesgo= new Nodo(riesgo, operadorLogicoRiesgo);
	        

	        String seleccion2 = view.leerDatoString("Ahora se debe definir qué hacer en caso de que no se cumpla la condición establecida \n\n"
	                + "Para el riesgo:\n" + "a) Cerrar el programa\n" + "b) Continuar \n");

	        switch (seleccion2) {
	            case "a":
	                Nodo decisionCerrar = new Nodo(11, "Cerrar");
	                premisaMonto.setDerecha(decisionCerrar);
	                break;
	            case "b":
	                Nodo decisionReiniciar = new Nodo(11, "Continuar");
	                premisaMonto.setDerecha(decisionReiniciar);
	                break;
	            default:
	                view.mostrarInformacion("Ingrese un carácter válido");
	                return; 
	        }

	        arbol.adicionar(premisaMonto);

	        view.mostrarInformacion("Premisa añadida con éxito");
	        view.mostrarInformacion("La premisa quedó definida de la siguiente manera: riesgo " + operadorLogicoRiesgo + " " + riesgo);
	    } catch (InputMismatchException e) {
	        view.mostrarInformacion("Error en la inserción, inténtelo de nuevo");
	        view.mostrarInformacion("\n\n");
	    }
	}
		
	public void decisionEdad() {
	    int edad = view.leerDatoEntero("Ingrese la edad del cliente: ");

	    if (!compararEdad(edad, arbol.raiz)) {
	        view.mostrarInformacion("El cliente no cumple con la edad requerida y no es elegible para el crédito.");
	        System.exit(0);
	    
	    } else {
	        view.mostrarInformacion("El cliente cumple con la edad requerida y es elegible para el crédito.");
	          }
	}
	public boolean compararEdad(int edad, Nodo nodo) {
	    if (nodo != null) {
	        String operador = nodo.getOperador();
	        int dato = nodo.getDato();
	        
	       if (operador.equals(">")) {
	            return edad > dato;
	        } else if (operador.equals("<")) {
	            return edad < dato;
	        } else if (operador.equals(">=")) {
	            return edad >= dato;
	        } else if (operador.equals("<=")) {
	            return edad <= dato;
	        } else if (operador.equals("!=")) {
	            return edad != dato;
	        } else {
	          
	            return false;
	        }
	    }
	    return false;
	}
	
	public void decisionIngresos() {
	    int ingresos = view.leerDatoEntero("Ingrese los ingresos del cliente: ");

	    if (!compararIngresos(ingresos, premisaIngresos)) {
	        view.mostrarInformacion("El cliente no cumple con los ingresos requeridos y no es elegible para el crédito.");
	        System.exit(0);
	       
	    } else {
	        view.mostrarInformacion("El cliente cumple con los ingresos requeridos y es elegible para el crédito.");
	       
	    }
	}
	public boolean compararIngresos(int ingresos, Nodo nodo) {
	    if (nodo != null) {
	        String operador = nodo.getOperador();
	        int dato = nodo.getDato();
	        
	        if (operador.equals(">")) {
	            return ingresos > dato;
	        } else if (operador.equals("<")) {
	            return ingresos < dato;
	        } else if (operador.equals(">=")) {
	            return ingresos >= dato;
	        } else if (operador.equals("<=")) {
	            return ingresos <= dato;
	        } else if (operador.equals("!=")) {
	            return ingresos != dato;
	        } else {
	            
	            return false;
	        }
	    }
	    return false;
	}

	public void decisionMonto() {
	    int monto = view.leerDatoEntero("Ingrese el monto del cliente: ");

	    if (!compararMonto(monto, premisaMonto)) {
	        view.mostrarInformacion("El cliente no cumple con el monto requerido y no es elegible para el crédito.");
	        System.exit(0);
	    } else {
	        view.mostrarInformacion("El cliente cumple con el monto requerido y es elegible para el crédito.");
	      
	    }
	}
	public boolean compararMonto(int monto, Nodo nodo) {
	    if (nodo != null) {
	        String operador = nodo.getOperador();
	        int dato = nodo.getDato();
	        
	        if (operador.equals(">")) {
	            return monto > dato;
	        } else if (operador.equals("<")) {
	            return monto < dato;
	        } else if (operador.equals(">=")) {
	            return monto >= dato;
	        } else if (operador.equals("<=")) {
	            return monto <= dato;
	        } else if (operador.equals("!=")) {
	            return monto != dato;
	        } else {
	           
	            return false;
	        }
	    }
	    return false;
	}
	
	public void decisionRiesgo() {
	    int riesgo = view.leerDatoEntero("Ingrese puntaje de riesgo del cliente: ");

	    if (!compararMonto(riesgo, premisaRiesgo)) {
	        view.mostrarInformacion("El cliente no cumple con puntaje de riesgo requerido y no es elegible para el crédito.");
	        System.exit(0);
	       
	    } else {
	        view.mostrarInformacion("El cliente cumple con puntaje de riesgo requerido y es elegible para el crédito.");
	       
	    }
	}
	public boolean compararRiesgo(int riesgo, Nodo nodo) {
	    if (nodo != null) {
	        String operador = nodo.getOperador();
	        int dato = nodo.getDato();
	        
	        if (operador.equals(">")) {
	            return riesgo > dato;
	        } else if (operador.equals("<")) {
	            return riesgo < dato;
	        } else if (operador.equals(">=")) {
	            return riesgo >= dato;
	        } else if (operador.equals("<=")) {
	            return riesgo <= dato;
	        } else if (operador.equals("!=")) {
	            return riesgo != dato;
	        } else {
	          
	            return false;
	        }
	    }
	    return false;
	}
	
	
}



package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	public String leerDatoString(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

 public int leerDatoEntero(String mensaje) {
        int dato = 0;
        boolean salida = true;
        do {
            try {
                dato = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                salida = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresó un dato no válido... :(");
                dato = 0;
            }
        } while (!salida);
		return dato;
          }

public void mostrarInformacion(String mensaje) {
	JOptionPane.showMessageDialog(null, mensaje);
}

}

package edu.udc.lapii.swing.bases;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ejemplo2_Componentes extends JFrame {
	
	public Ejemplo2_Componentes() {
		
		this.setTitle("Ejemplo con ventana y componentes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);
		
		/* Los layouts sirven para manejar la distribución 
		 * de los componentes dentro del contenendor*/
		this.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Ingrese un valor:");
		this.add(label);
		
		JTextField text = new JTextField(15);
		this.add(text);
				
		JButton buttonFactorial =  new JButton("Calcular factorial");
		this.add(buttonFactorial);

		JButton buttonSumatoria =  new JButton("Calcular sumatoria");
		this.add(buttonSumatoria);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ejemplo2_Componentes();
	}
	
}

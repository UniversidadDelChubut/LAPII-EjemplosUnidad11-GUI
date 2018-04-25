package edu.udc.lapii.swing.bases;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ejemplo3_ManejoEventos extends JFrame {

	private JTextField text;

	public Ejemplo3_ManejoEventos() {
		this.setTitle("Ejemplo con ventana y componentes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);

		this.setLayout(new FlowLayout());

		JLabel label = new JLabel("Ingrese un valor:");
		this.add(label);

		text = new JTextField(15);
		this.add(text);

		JButton buttonFactorial = new JButton("Calcular factorial");
		this.add(buttonFactorial);

		JButton buttonSigno = new JButton("Calcular signo");
		this.add(buttonSigno);

		buttonFactorial.addActionListener(new FactorialListener(text));

		buttonSigno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int valor = Integer
							.parseInt(Ejemplo3_ManejoEventos.this.text
									.getText());

					JOptionPane.showMessageDialog(null, "El valor " + valor
							+ " es " + (valor < 0 ? "negativo" : "positivo"), // Mensaje
							"Cálculo de factorial", // Título
							JOptionPane.ERROR_MESSAGE); // Tipo de mensaje

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero", // Mensaje
							"Cálculo de factorial", // Título
							JOptionPane.ERROR_MESSAGE); // Tipo de mensaje
				}

			}
		});

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Ejemplo3_ManejoEventos();
	}

	static int calcularFactorial(int numero) {
		int factorial = 1;
		for (int i = 1; i <= numero; i++)
			factorial *= i;
		return factorial;
	}

}

class FactorialListener implements ActionListener {

	private JTextField text;

	public FactorialListener(JTextField text) {
		this.text = text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			int valor = Integer.parseInt(text.getText());

			if (valor < 0) {
				JOptionPane.showMessageDialog(null,
						"Ingrese un numero positivo", // Mensaje
						"Cálculo de factorial", // Título
						JOptionPane.ERROR_MESSAGE); // Tipo de mensaje

			} else {

				JOptionPane.showMessageDialog(
						null,
						"El factorial de "+ valor+ " es "
						+ Ejemplo3_ManejoEventos.calcularFactorial(valor), // Mensaje
						"Cálculo de factorial", // Título
						JOptionPane.ERROR_MESSAGE); // Tipo de mensaje
			}

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Ingrese un numero", // Mensaje
					"Cálculo de factorial", // Título
					JOptionPane.ERROR_MESSAGE); // Tipo de mensaje
		}

	}

}

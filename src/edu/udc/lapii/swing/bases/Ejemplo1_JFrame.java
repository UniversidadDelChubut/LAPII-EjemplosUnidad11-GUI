package edu.udc.lapii.swing.bases;

import javax.swing.JFrame;

public class Ejemplo1_JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mi primera ventana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);
	}
}

package edu.udc.lapii.swing.miprimerventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiQueridoJFrame extends JFrame implements ActionListener {
	
	private JPanel contenedor;
	private int red = 25;
	
	public MiQueridoJFrame () {
		this.contenedor =  new JPanel();
		JButton boton = new JButton("Cambiar el color de fondo!!!");
		boton.addActionListener(this);
		this.contenedor.add(boton);
		
		boton = new JButton("Soy el segundo boton");
		boton.addActionListener(new BotonDosListener());
		this.contenedor.add(boton);
		
		boton = new JButton("Soy el tercer boton");
		boton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						contenedor.setBackground(Color.YELLOW);
					}
				}
		);
		this.contenedor.add(boton);
		
		this.setContentPane(this.contenedor);
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.contenedor.setBackground(new Color(this.red, 120, 120) );
		this.red = this.red + 50;
		if (this.red + 50 > 255 ){
			((JButton)e.getSource()).setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		new MiQueridoJFrame();
	}
	
	private class BotonDosListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			contenedor.setBackground(Color.WHITE);
		}
	}

}

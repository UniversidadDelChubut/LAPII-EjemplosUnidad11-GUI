package testcadetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PantallaPrincipal extends JFrame implements ActionListener {

	
	public PantallaPrincipal() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Cursos"); 
		JMenuItem itemEditarCUrso = new JMenuItem("Editar Curso");
		menuBar.add(menu);
		menu.add(itemEditarCUrso);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		menu.add(itemSalir);
		
		itemEditarCUrso.addActionListener(this);
		itemEditarCUrso.setActionCommand("editar_curso");
		
		itemSalir.addActionListener(this);
		itemSalir.setActionCommand("salir");
		
		this.setJMenuBar(menuBar);
		this.setTitle("Escuela de Cadetes");
		this.setBounds(50, 50, 200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("salir")) {
			System.exit(0);
		}
		if (e.getActionCommand().equals("editar_curso")) {
			this.setEnabled(false);
			new SeleccionarCurso(this);
		}
	}
	
	public static void main(String[] args) {
		new PantallaPrincipal();
	}
}

package edu.udc.lapii.mvc.tateti.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.udc.lapii.mvc.tateti.core.Tateti;
import edu.udc.lapii.mvc.tateti.core.TatetiController;
import edu.udc.lapii.mvc.tateti.core.TatetiListener;
import edu.udc.lapii.mvc.tateti.core.TatetiVista;

@SuppressWarnings("serial")
public class TatetiFrame extends JFrame implements TatetiListener, TatetiVista {
	
	private TatetiController controller;
		
	private TatetiPanel tatetiPanel;
	
	private Tateti tateti;
	
	public TatetiFrame(Tateti tateti) {
		this.setTitle("TaTeTi!");
		this.tateti = tateti;
		this.tateti.addTatetiListener(this);
		tatetiPanel = new TatetiPanel(tateti, this);
		this.getContentPane().add(tatetiPanel);
		this.setSize(300, 300);
	}
	
	@Override
	public void lanzar() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	@Override
	public void setController(TatetiController controller) {
		this.controller = controller;
	}
	
	public void actualizar() {
		tatetiPanel.actualizar();
	}
	
	
	
	/* Incio controller */
	void lanzarAccion(int fila, int columna) {
		this.controller.lanzarAccion(fila, columna);
	}
	
	@Override
	public void jugadaRealizada() {
		this.tatetiPanel.actualizar();				
	}

	@Override
	public void finalizaJuego() {

		JOptionPane.showMessageDialog(null, 
				// Mensaje
				"Game Over!!!\n" + 
						(tateti.getGanador() == Tateti.VACIO ? "EMPATE" : "GANA " + tateti.getGanador()),
				"Fin del juego", // Título
				JOptionPane.INFORMATION_MESSAGE); // Tipo de mensaje
		
	}
	
	/* fin contoller*/
	
	
}

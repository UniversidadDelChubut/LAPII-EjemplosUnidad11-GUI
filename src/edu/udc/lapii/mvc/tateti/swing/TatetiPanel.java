package edu.udc.lapii.mvc.tateti.swing;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.udc.lapii.mvc.tateti.core.Tateti;

@SuppressWarnings("serial")
public class TatetiPanel extends JPanel {
	
	private JButton [] buttons = new JButton[9];
	
	private Tateti tateti;
	
	public TatetiPanel(Tateti tateti, final TatetiFrame frame) {
		
		this.tateti = tateti;
		
		
		this.setLayout(new GridLayout(3, 3));
		for (int i = 0 ; i < 9 ; i ++) {
			buttons[i] = new JButton("Boton " + i) ;
			buttons[i].setActionCommand(i + "");
			this.add(buttons[i]);
			
			buttons[i].addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ae) {
							int valor = Integer.parseInt(ae.getActionCommand());
							frame.lanzarAccion(valor / 3, valor % 3);
							//lanzarAccion(valor / 3, valor % 3);
						}
					});
					
		}
		actualizar();
		
	}
	
	
	private void mostrarBoton (JButton button, char jugador) {
		
		
		
		
		ImageIcon image = null;
		java.net.URL imgURL = TatetiPanel.class.getResource( 
				jugador == 'O' ? 
						"images/circulo.png":
						"images/cruz.png");
		
		
		
        if (imgURL != null) {
            image = new ImageIcon(imgURL);
        }
        
        if (jugador == Tateti.VACIO)
        	button.setText("");
        else if (image == null) 
        	button.setText(jugador+"");
        else
        	button.setIcon( image );
	}
	
	public void actualizar() {
		char[][] tablero = this.tateti.getTablero();
		for (int i = 0; i < tablero.length ; i ++ ) {
			for (int j = 0; j < tablero.length ; j ++ ) {
				this.mostrarBoton(this.buttons[i*3+j] , tablero[i][j]);
			}
		}
		this.repaint();
	}

}

package testcadetes;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.peer.FramePeer;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class SeleccionarCurso  extends JFrame implements WindowListener {
	
	private JFrame parent;
	
	public SeleccionarCurso(JFrame parent) {
		this.parent = parent;
		this.setSize(300,300);
		this.addWindowListener(this);
		this.setTitle("SeleccionarCurso");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.parent.setEnabled(true);
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

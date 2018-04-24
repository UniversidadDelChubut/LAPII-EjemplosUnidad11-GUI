package edu.udc.lapii.gui.tateti;

import edu.udc.lapii.gui.tateti.core.TatetiController;
import edu.udc.lapii.gui.tateti.gui.TatetiFrame;

public class JUugarTatetiGUI {
	
	public static void main(String[] args) {
		TaTeTi model = new TaTeTi();
		new TatetiController(model, new TatetiFrame(model));
	}

}

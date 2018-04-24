package edu.udc.lapii.mvc.tateti;

import edu.udc.lapii.mvc.tateti.core.Tateti;
import edu.udc.lapii.mvc.tateti.core.TatetiController;
import edu.udc.lapii.mvc.tateti.swing.TatetiFrame;

public class JugarTatetiSwing {
	
	public static void main(String[] args) {
		Tateti model = new Tateti();
		new TatetiController(model, new TatetiFrame(model));
	}

}

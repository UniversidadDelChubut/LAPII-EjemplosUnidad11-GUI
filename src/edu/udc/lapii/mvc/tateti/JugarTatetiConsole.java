package edu.udc.lapii.mvc.tateti;

import edu.udc.lapii.mvc.tateti.console.TatetiConsole;
import edu.udc.lapii.mvc.tateti.core.Tateti;
import edu.udc.lapii.mvc.tateti.core.TatetiController;




public class JugarTatetiConsole {
	public static void main(String[] args) {
		Tateti model = new Tateti();
		new TatetiController(model, new TatetiConsole(model));
	}

}

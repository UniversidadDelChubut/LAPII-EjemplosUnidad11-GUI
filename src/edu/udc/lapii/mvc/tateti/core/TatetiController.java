package edu.udc.lapii.mvc.tateti.core;

public class TatetiController {
	
	public TatetiVista vista;
	public Tateti modelo;
	
	public TatetiController(TaTeTi modelo, TatetiVista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setController(this);
		this.vista.lanzar();
		
	}
	
	public void lanzarAccion(int fila, int columna) {

		if (modelo.getTurno() == TaTeTi.EQUIS)
			modelo.jugarX(fila, columna);
		else
			modelo.jugarY(fila, columna);
		vista.actualizare();
	}
	
}

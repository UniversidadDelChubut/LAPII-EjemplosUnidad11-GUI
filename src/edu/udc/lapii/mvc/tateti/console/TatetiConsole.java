package edu.udc.lapii.mvc.tateti.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.udc.lapii.gui.tateti.TaTeTi;
import edu.udc.lapii.gui.tateti.core.TatetiController;
import edu.udc.lapii.gui.tateti.core.TatetiListener;
import edu.udc.lapii.gui.tateti.core.TatetiVista;

public class TatetiConsole implements TatetiVista, TatetiListener {

	TaTeTi tateti;
	TatetiController controller;

	public TatetiConsole(TaTeTi tateti) {
		this.tateti = tateti;
	}

	@Override
	public void actualizare() {
		imprimir();
	}

	@Override
	public void setController(TatetiController controller) {
		this.controller = controller;
	}

	@Override
	public void lanzar() {
		imprimir();
	}

	@Override
	public void finalizaJuego() {
		imprimir();
	}

	@Override
	public void jugadaRealizada() {
		imprimir();
	}

	private void imprimir() {
		char[][] t = tateti.getTablero();

		String s = "" + "\n" + '|' + t[0][0] + '|' + t[0][1] + '|' + t[0][2]
				+ '|' + '\n' + '|' + t[1][0] + '|' + t[1][1] + '|' + t[1][2]
				+ '|' + '\n' + '|' + t[2][0] + '|' + t[2][1] + '|' + t[2][2]
				+ '|' + '\n';
		System.out.println(s);

		if (!tateti.finalizoJuego()) {

			while (!tateti.finalizoJuego()) {
				char jugador = tateti.getTurno();
				

				int valor = 0;
				boolean entradaValida = false;
				while (!entradaValida) {
					try {
						System.out.print("Juega " + jugador + " [1-9]:");
						Scanner entrada = new Scanner(System.in);
						valor = entrada.nextInt();
						if (valor < 1 || valor > 9) {
							System.out.println("Error ingreso no valido");
							entradaValida = false;
						} else {
							entradaValida = true;
						}
					} catch (InputMismatchException ex) {
						System.out.println("Error ingreso no valido");
						entradaValida = false;
					}
				}
				controller.lanzarAccion((valor - 1) / 3, (valor - 1) % 3);
			}
		} else {
			System.out.println(tateti.getGanador() == TaTeTi.VACIO ? "EMPATE"
					: "GANA " + tateti.getGanador());
			System.out.println("Game Over!!!");
		}
	}

}

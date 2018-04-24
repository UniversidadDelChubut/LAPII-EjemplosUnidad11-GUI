package edu.udc.lapii.gui.tateti;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.udc.lapii.gui.tateti.gui.TatetiFrame;

public class JugarTaTeTi {

	private TaTeTi tateti = new TaTeTi();

	public JugarTaTeTi() {
		
		TatetiFrame tf = new TatetiFrame(tateti);
		
		tf.actualizare();
		
		while (!tateti.finalizoJuego()) {
			char jugador = tateti.getTurno();
			imprimir();

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

			if (tateti.getTurno() == TaTeTi.EQUIS)
				tateti.jugarX((valor - 1) / 3, (valor - 1) % 3);
			else
				tateti.jugarY((valor - 1) / 3, (valor - 1) % 3);
			
			tf.actualizare();

		}

		imprimir();

		System.out.println(tateti.getGanador() == TaTeTi.VACIO ? "EMPATE" : "GANA "
				+ tateti.getGanador());

		System.out.println("Game Over!!!");
	}

	private void imprimir() {
		char[][] t = tateti.getTablero();

		String s = ""
				+ "\n" + '|' + t[0][0] + '|' + t[0][1] + '|' + t[0][2] + '|'
				+ '\n' + '|' + t[1][0] + '|' + t[1][1] + '|' + t[1][2] + '|'
				+ '\n' + '|' + t[2][0] + '|' + t[2][1] + '|' + t[2][2] + '|'
				+ '\n';
		System.out.println(s);
		

	}

	public static void main(String[] args) {
		new JugarTaTeTi();
	}

}

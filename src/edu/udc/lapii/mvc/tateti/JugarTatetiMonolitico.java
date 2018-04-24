package edu.udc.lapii.mvc.tateti;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JugarTatetiMonolitico {

	public JugarTatetiMonolitico() {

		while (!(hayTateti() || tableroCompleto())) {
			char jugador = getTurno();
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

			jugar(getTurno(), (valor - 1) / 3, (valor - 1) % 3);

		}

		imprimir();

		System.out.println(getGanador() == VACIO ? "EMPATE" : "GANA " + getGanador());

		System.out.println("Game Over!!!");
	}

	private void imprimir() {

		String s = "" + "\n" + '|' + tablero[0][0] + '|' + tablero[0][1] + '|' + tablero[0][2] + '|' + '\n' + '|'
				+ tablero[1][0] + '|' + tablero[1][1] + '|' + tablero[1][2] + '|' + '\n' + '|' + tablero[2][0] + '|'
				+ tablero[2][1] + '|' + tablero[2][2] + '|' + '\n';
		System.out.println(s);

	}

	public static void main(String[] args) {
		new JugarTatetiMonolitico();
	}

	public static final char EQUIS = 'X';
	public static final char CIRCULO = 'O';
	public static final char VACIO = ' ';

	private char[][] tablero = { { VACIO, VACIO, VACIO }, { VACIO, VACIO, VACIO }, { VACIO, VACIO, VACIO } };

	private char turno = EQUIS;

	private char getTurno() {
		if (hayTateti() || tableroCompleto())
			return VACIO;
		return turno;
	}

	private char getGanador() {
		if (!(hayTateti() || tableroCompleto()))
			return VACIO;
		if (!hayTateti())
			return VACIO;
		return turno == EQUIS ? CIRCULO : EQUIS;
	}

	// Mejorar
	private void jugar(char jugador, int fil, int col) {
		if (hayTateti())
			return;
		if (fil < 0 || fil >= tablero.length)
			return;
		if (col < 0 || col >= tablero.length)
			return;
		if (this.tablero[fil][col] != VACIO)
			return;
		this.tablero[fil][col] = jugador;
		this.turno = jugador == EQUIS ? CIRCULO : EQUIS;

	}

	private boolean tableroCompleto() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == VACIO)
					return false;
			}
		}
		return true;
	}

	private boolean hayTateti() {
		for (int i = 0; i < tablero.length; i++) {
			if (this.tablero[i][0] != VACIO && this.tablero[i][0] == this.tablero[i][1]
					&& this.tablero[i][1] == this.tablero[i][2])
				return true;
		}

		for (int i = 0; i < tablero.length; i++) {
			if (this.tablero[0][i] != VACIO && this.tablero[0][i] == this.tablero[1][i]
					&& this.tablero[1][i] == this.tablero[2][i])
				return true;
		}

		if (this.tablero[0][0] != VACIO && this.tablero[0][0] == this.tablero[1][1]
				&& this.tablero[1][1] == this.tablero[2][2])
			return true;

		if (this.tablero[0][2] != VACIO && this.tablero[0][2] == this.tablero[1][1]
				&& this.tablero[1][1] == this.tablero[2][0])
			return true;

		return false;
	}

}

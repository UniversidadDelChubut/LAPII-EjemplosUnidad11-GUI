package edu.udc.lapii.mvc.tateti.core;

import java.util.LinkedList;
import java.util.List;

import edu.udc.lapii.mvc.tateti.core.TatetiListener;

public class Tateti {

	public static final char EQUIS = 'X';
	public static final char CIRCULO = 'O';
	public static final char VACIO = ' ';

	private char[][] tablero = { 
			{ TaTeTi.VACIO, TaTeTi.VACIO, TaTeTi.VACIO}, 
			{ TaTeTi.VACIO, TaTeTi.VACIO, TaTeTi.VACIO}, 
			{ TaTeTi.VACIO, TaTeTi.VACIO, TaTeTi.VACIO} 
			};

	private char turno = TaTeTi.EQUIS;

	/**
	 * Crea un partida de ta te ti.
	 */
	public TaTeTi() {
		
	}

	/**
	 * 
	 * @return
	 */
	public synchronized char getTurno() {
		if (finalizoJuego())
			return TaTeTi.VACIO;
		return turno;
	}

	public char getGanador() {
		if (!finalizoJuego())
			return TaTeTi.VACIO;
		if (!hayTaTeTi())
			return TaTeTi.VACIO;
		return turno == TaTeTi.EQUIS ? TaTeTi.CIRCULO : TaTeTi.EQUIS;
	}

	public synchronized void jugarX(int fil, int col) {
		jugar(TaTeTi.EQUIS, fil, col);
	}

	public synchronized void jugarY(int fil, int col) {
		jugar(TaTeTi.CIRCULO, fil, col);
	}

	// Mejorar
	private void jugar(char jugador, int fil, int col) {
		if (hayTaTeTi())
			return;
		if (fil < 0 || fil >= tablero.length)
			return;
		if (col < 0 || col >= tablero.length)
			return;
		if (this.tablero[fil][col] != TaTeTi.VACIO)
			return;
		this.tablero[fil][col] = jugador;
		this.turno = jugador == TaTeTi.EQUIS ? TaTeTi.CIRCULO : TaTeTi.EQUIS;
		
		this.informarJugadaRealizada();
		
		if (this.finalizoJuego()){
			this.informarFinJuego();
		}
		
	}

	public synchronized boolean finalizoJuego() {
		return hayTaTeTi() || tableroCompleto();
	}

	public synchronized boolean tableroCompleto() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == TaTeTi.VACIO)
					return false;
			}
		}
		return true;
	}

	public synchronized boolean hayTaTeTi() {
		for (int i = 0; i < tablero.length; i++) {
			if (this.tablero[i][0] != TaTeTi.VACIO	
					&& this.tablero[i][0] == this.tablero[i][1]
					&& this.tablero[i][1] == this.tablero[i][2])
				return true;
		}

		for (int i = 0; i < tablero.length; i++) {
			if (this.tablero[0][i] != TaTeTi.VACIO
					&& this.tablero[0][i] == this.tablero[1][i]
					&& this.tablero[1][i] == this.tablero[2][i])
				return true;
		}

		if (this.tablero[0][0] != TaTeTi.VACIO
				&& this.tablero[0][0] == this.tablero[1][1]
				&& this.tablero[1][1] == this.tablero[2][2])
			return true;

		if (this.tablero[0][2] != TaTeTi.VACIO
				&& this.tablero[0][2] == this.tablero[1][1]
				&& this.tablero[1][1] == this.tablero[2][0])
			return true;

		return false;
	}

	public synchronized char[][] getTablero() {

		char[][] tableroCopia = new char[tablero.length][tablero.length];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tableroCopia[i][j] = tablero[i][j];
			}
		}
		return tableroCopia;
		
	}
	
	

	private List<TatetiListener> listeners = new LinkedList<>(); 
	
	public void addTatetiListener(TatetiListener l) {
		this.listeners.add(l);
	}
	
	
	
	private void informarFinJuego() {
		for (TatetiListener l: this.listeners) {
			l.finalizaJuego();
		}
	}

	private void informarJugadaRealizada() {
		for (TatetiListener l: this.listeners) {
			l.jugadaRealizada();
		}
	}
	
	
};

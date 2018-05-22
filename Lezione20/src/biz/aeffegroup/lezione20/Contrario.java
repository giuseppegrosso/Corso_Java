package biz.aeffegroup.lezione20;

/*
 * Esercizio 3.1: Scrivere un programma Contrario che chiede all’utente di inserire una stringa e la
 * stampa al contrario. 
 * Per esempio, se si immette la stringa "Viva Java", il programma stampa "avaJ aviV"
 */
public class Contrario {

	public String inverti(String ingresso) {
		String out = "";
		for (int i = 0; i < ingresso.length(); i++) {
			out += ingresso.substring(ingresso.length() - i - 1, ingresso.length() - i);
		}

		return out;
	}

	public static void main(String[] args) {
		// istanza della classe contrario.
	}
}

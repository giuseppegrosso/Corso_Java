package biz.aeffegroup.lezione20;

// Esercizio 1.1: Convertire in formato decimale i seguenti numeri binari senza segno
//00010101
//11001010
//10010110
public class BinarioDecimale {

	public BinarioDecimale() {

	}

	public long calcolaDecimale(String numero) {
		long calcolo = 0L;
		for (int i = 0; i < numero.length(); i++) {
			// da finire.
		}

		return calcolo;

	}

	public static void main(String[] args) {
		BinarioDecimale b = new BinarioDecimale();

		System.out.println(b.calcolaDecimale("00010101"));

	}

}

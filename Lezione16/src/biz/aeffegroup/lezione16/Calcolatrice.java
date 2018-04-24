package biz.aeffegroup.lezione16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calcolatrice {
	public static void main(String[] args) {
		try {
			String temp = null;
			boolean basta = false;
			int tempint = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (basta == false) {
				System.out.println("Ciao! Scrivi 1 per somma,  2 per sottrazione, 3 per moltiplicazione, ");
				System.out.println("4 per divisione, 7 se vuoi uscire!");
				temp = br.readLine();
				tempint = Integer.parseInt(temp);
				switch (tempint) {
				case 1:
					Somma sum = new Somma();
					sum.inserisci(8.0, 4.0);
					sum.calcola();
					sum.visualizza();
					break;
//				case 2:
//					Sottrazione sott = new Sottrazione();
//					sott.Inserisci();
//					sott.Calcola();
//					sott.Visualizza();
//					break;
//				case 3:
//					Moltiplicazione molt = new Moltiplicazione();
//					molt.Inserisci();
//					molt.Calcola();
//					molt.Visualizza();
//					break;
//				case 4:
//					Divisione divi = new Divisione();
//					divi.Inserisci();
//					divi.Calcola();
//					divi.Visualizza();
//					break;
				case 7:
					basta = true;
					break;
				default:
					System.out.println("Il numero  inserito non corrisponde ad alcuna operazione");
					break;
				}
			}
			System.out.println("Elaborazione teminata! Ciao!");
		} catch (IOException ex) {
		}
	}
}

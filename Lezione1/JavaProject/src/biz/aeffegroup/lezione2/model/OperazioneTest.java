package biz.aeffegroup.lezione2.model;

import java.util.Scanner;

public class OperazioneTest
{

	// Definisci una interfaccia 'operazione' e le sue classi derivate( sottrazione
	// divisione, moltiplicazione, somma) in modo che da ciascuna sia possibile
	// eseguire la corrispondente operazione aritmetica (di addizione, divisione,
	// moltiplicazione) istanziando un oggetto di classe 'operazione' e due
	// operandi. Realizzare anche, una classe astratta che implementi le
	// funzionalità comuni come la stampa a video del risultato.

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Inizio TEST " + OperazioneTest.class.getName());
		// recupero da input (tastiera)
		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci il primo valore (a) ");
		int v1 = input.nextInt();

		System.out.println("Inserisci il secondo valore (b) ");
		int v2 = input.nextInt();

		// attenzione tramite il polimorfismo posso attribuire il valore
		// della classe di implementazione all'interfaccia.
		IOperazione s = new Somma();
		s.risultato(v1, v2);

		// attenzione tramite il polimorfismo posso attribuire il valore
		// della classe di implementazione all'interfaccia.
		IOperazione sottrazione = new Sottrazione();
		sottrazione.risultato(v1, v2);

		// attenzione tramite il polimorfismo posso attribuire il valore
		// della classe di implementazione all'interfaccia.
		IOperazione m = new Moltiplicazione();
		m.risultato(v1, v2);

		// attenzione tramite il polimorfismo posso attribuire il valore
		// della classe di implementazione all'interfaccia.
		IOperazione d = new Divisione();
		d.risultato(v1, v2);

		System.out.println("Fine TEST " + OperazioneTest.class.getName());
	}

}

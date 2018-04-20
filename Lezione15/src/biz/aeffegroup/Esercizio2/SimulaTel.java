package biz.aeffegroup.Esercizio2;


/**
 * 
 * 
 * E' necessario scrivere una applicazione che simula il funzionamento di un frammento del sistema informativo di un operatore di telefonia cellulare.
Si devono quindi rappresentare i dati relativi ad una carta SIM ed in particolare:
- il numero di telefono
- il credito disponibile in euro
- la lista delle telefonate effettuate
Per ciascuna telefonata deve essere rappresentata la durata in minuti
La classe SIM dovrà fornire le seguenti funzionalità:
- un costruttore parametrizzato che crea una SIM con numero di telefono, un credito e la lista delle
   telefonate vuota
- un metodo per l'inserimento di una telefonata con i dati forniti dall'utente.
- una funzione per il calcolo dei minuti totali di conversazione.
- una funzione per il calcolo delle telefonate effettuate verso un certo numero
- una procedura per la stampa dei dati della SIM e l'elenco delle telefonate. 
 * 
 * @author g.grosso
 *
 */
public class SimulaTel
{
	public static void main(String args[])
	{
		String st = "000";
		Sim s = new Sim("3291148752185", 20, 5);
		s.ins("000", 3);
		s.ins("789", 5);
		System.out.println(s);
		System.out.println("totale chiamate in min:" + s.cal());
		s.ins("000", 7);
		s.ins("456", 4);
		System.out.println(s);
		System.out.println("chiamate verso:" + st + ":" + s.conta(st));
		s.ins("000", 7);
		s.ins("789", 4);
		System.out.println(s);
		System.out.println("chiamate verso:" + st + ":" + s.conta(st));
	}
}

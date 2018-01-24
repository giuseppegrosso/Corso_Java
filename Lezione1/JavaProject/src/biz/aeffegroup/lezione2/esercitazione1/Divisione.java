package biz.aeffegroup.lezione2.esercitazione1;

/**
 * Classe per la Divisione dei numeri
 * 
 * @author g.grosso
 *
 *         Attenzione in questo esempio non sfrutto il costruttore ma è il
 *         metodo stesso che ha i parametri per effettuare il risultato
 *         dell'operazione.
 */
public class Divisione extends Stampa implements IOperazione
{
	// attenzione la definizione può essere:
	// 1. private (visibile solo internamente all'oggetto)
	// 2. protected (visibile all'oggetto e ai suoi eredi (ovvero le classi che
	// estendono questo oggetto: Moltiplicazione)
	// 3. public (visibile da tutti all'interno dell'istanza dell'oggetto)
	protected double n;

	/**
	 * override del metodo (implementazione)
	 */
	public void risultato(int dividendo, int divisore)
	{
		n = (divisore / divisore);
		print("risultato moltiplicazione:", n);
	}
}
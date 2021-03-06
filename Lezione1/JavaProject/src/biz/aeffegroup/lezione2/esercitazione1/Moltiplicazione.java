package biz.aeffegroup.lezione2.esercitazione1;

/**
 * Classe per la Moltiplicazione dei numeri
 * 
 * @author g.grosso
 *
 *         Attenzione in questo esempio non sfrutto il costruttore ma � il
 *         metodo stesso che ha i parametri per effettuare il risultato
 *         dell'operazione.
 */
public class Moltiplicazione extends Stampa implements IOperazione
{
	// attenzione la definizione pu� essere:
	// 1. private (visibile solo internamente all'oggetto)
	// 2. protected (visibile all'oggetto e ai suoi eredi (ovvero le classi che
	// estendono questo oggetto: Moltiplicazione)
	// 3. public (visibile da tutti all'interno dell'istanza dell'oggetto)
	protected int n;

	/**
	 * override del metodo (implementazione)
	 */
	public void risultato(int fattore1, int fattore2)
	{
		n = (fattore1 * fattore2);
		print("risultato moltiplicazione:", n);
	}
}
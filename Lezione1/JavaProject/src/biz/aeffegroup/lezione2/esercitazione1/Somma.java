package biz.aeffegroup.lezione2.esercitazione1;

/**
 * Classe per la somma dei numeri
 * 
 * @author g.grosso
 *
 *         Attenzione in questo esempio non sfrutto il costruttore ma è il
 *         metodo stesso che ha i parametri per effettuare il risultato
 *         dell'operazione.
 */
public class Somma extends Stampa implements IOperazione
{
	// attenzione la definizione può essere:
	// 1. private (visibile solo internamente all'oggetto)
	// 2. protected (visibile all'oggetto e ai suoi eredi (ovvero le classi che
	// estendono questo oggetto: Somma)
	// 3. public (visibile da tutti all'interno dell'istanza dell'oggetto)
	protected int n;

	/**
	 * override del metodo (implementazione)
	 */
	public void risultato(int operando1, int operando2)
	{
		n = (operando1 + operando2);
		print("risultato somma:", n);
	}
}
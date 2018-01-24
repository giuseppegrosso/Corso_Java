package biz.aeffegroup.lezione2.esercitazione1;

/**
 * Esercitazione lezione 2
 * 
 * @author g.grosso
 *
 *
 *         Definizione di una interfaccia comune per effettuare il ritorno di
 *         una operazione.
 */

public interface IOperazione
{
	/**
	 * metodo per la restituzione del risultato dell'operazione: nota accetta i
	 * parametri a e b per evitare di passarli nel costruttore di ogni classe
	 * implementativa.
	 * 
	 * @param a
	 * @param b
	 */
	void risultato(int a, int b);
}

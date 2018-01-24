package biz.aeffegroup.lezione2.esercitazione1;

/**
 * classe astratta per l'utility di stampa di messaggio e di intero del numero.
 * 
 * @author g.grosso
 *
 */
public abstract class Stampa
{
	/**
	 * metodo per la stampa del numero
	 * 
	 * @param num
	 */
	public void print(int num)
	{
		// nota tutta l'implementazione è concentrata in un metodo.
		print("", num);
	}

	/**
	 * overloading del metodo di print con passaggio di un ulteriore parametro
	 * 
	 * @param messaggio
	 * @param num
	 */
	public void print(String messaggio, Number num)
	{
		// stampa a video del messaggio e del valore del numero
		System.out.println(messaggio.concat(" ").concat("" + num));
	}
}

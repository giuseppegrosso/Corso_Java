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
		// nota tutta l'implementazione � concentrata in un metodo.
		print("", num);
	}

	public void print(String message)
	{
		print(message, 0);
	}

	/**
	 * overloading del metodo di print con passaggio di un ulteriore parametro
	 * 
	 * @param messaggio
	 * @param num
	 */
	public void print(String messaggio, Number num)
	{
		if (num == null || num.intValue() == 0)
			System.out.println(messaggio);
		else
			// stampa a video del messaggio e del valore del numero
			System.out.println(messaggio.concat(" ").concat("" + num));
	}
}

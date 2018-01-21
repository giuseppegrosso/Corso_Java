package biz.aeffegroup.test;

/**
 * classe di test prima invocazione.
 * 
 * @author g.grosso
 *
 */
public class MyClassTest
{

	public static String MIA_STRINGA = "Ciao a tutti %s";
	public static void main(String[] args)
	{
		String variabile = "quanti";
		System.out.println(String.format(MIA_STRINGA, variabile));

	}

}

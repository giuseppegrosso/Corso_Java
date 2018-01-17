package biz.aeffegroup.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * calcolo del rettangolo tramite lettura valori da standard input.
 * 
 * Esempio di main che prende i dati da standard input e calcola area e
 * perimetro.
 * 
 * @author g.grosso
 *
 */
public class RettangoloMain
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		InputStreamReader myInput = new InputStreamReader(System.in);
		
		BufferedReader stdin = new BufferedReader(myInput);

		int base = 0, altezza = 0, area = 0, perimetro = 0;

		System.out.print("Base = ");
		System.out.flush();
		while (base == 0)
		{
			try
			{
				base = Integer.parseInt(stdin.readLine());
			} catch (NumberFormatException e)
			{
				System.out.println(
						"Errore hai passato un valore alfabetico invece che numerico: "
								+ e.getMessage());
				e.printStackTrace();
			}

		}

		System.out.print("Altezza = ");
		System.out.flush();
		altezza = Integer.parseInt(stdin.readLine());

		area = base * altezza;
		perimetro = (base + altezza) * 2;

		System.out.println("Area = " + area);
		System.out.println(
				String.format("Perimetro = %s, Area = %s", perimetro, area));

	}
}

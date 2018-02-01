package biz.aeffegroup.lezione4.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * applicazione pratica, leggo un file ed effettuo la somma dei numeri
 * contenuti.
 * 
 * @author g.grosso
 *
 */
public class SommaInteriWithException
{

	// programma che legge numeri da file,
	// uno per riga, e ne stampa la somma

	public static void main(String[] args)
	{

		System.out.print("Nome file input (con suffisso): ");
		Scanner input = new Scanner(System.in);
		String inputFileName = input.nextLine();

		String line = null;

		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new FileReader(inputFileName));

			line = in.readLine();
			int somma = 0;

			while (line != null)
			{
				// se non e' possibile convertire la stringa line in
				// intero viene lanciata un'eccezione
				// NumberFormatException (catturata sotto con catch
				// apposito)
				int numero = Integer.parseInt(line);

				somma += numero;
				line = in.readLine();
			}
			System.out.println(" la somma e'  " + somma);

		} catch (FileNotFoundException e)
		{
			System.out.println(inputFileName + " FileNotFound");
		} catch (NumberFormatException e)
		{
			System.out.println(" linea non corretta: -> " + line + " <-");
		} catch (IOException e)
		{
			System.out.println(" IOException  " + e);
		} finally
		{
			if (in != null)
				try
				{
					in.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		System.out.println(" fine esecuzione ");
	}
}

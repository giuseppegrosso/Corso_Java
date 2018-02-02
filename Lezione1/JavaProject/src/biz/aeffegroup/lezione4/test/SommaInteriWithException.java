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
		int somma = 0;
		try
		{
			in = new BufferedReader(new FileReader(inputFileName));

			line = in.readLine();

			while (line != null)
			{
				// se non e' possibile convertire la stringa line in
				// intero viene lanciata un'eccezione
				// NumberFormatException (catturata sotto con catch
				// apposito)
				int numero = 0;
				try
				{
					numero = Integer.parseInt(line);
				} catch (NumberFormatException e)
				{
					System.out.println(" linea non corretta: -> " + line + " <-");
					System.out.println("comunque proseguo.");
				}

				somma += numero;
				line = in.readLine();
			}

		} catch (FileNotFoundException e)
		{
			System.out.println(inputFileName + " FileNotFound");
		} catch (IOException e)
		{
			System.out.println(" IOException  " + e);
		} finally
		{
			System.out.println(" la somma e'  " + somma);
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

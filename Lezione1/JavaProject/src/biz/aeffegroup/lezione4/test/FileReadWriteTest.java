package biz.aeffegroup.lezione4.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * combinazione di lettura del file e scrittura su altro file.
 * 
 * 
 * @author g.grosso
 *
 */
public class FileReadWriteTest
{

	public static void main(String[] args)
	{
		System.out.print("Nome file input (con suffisso): ");
		Scanner input = new Scanner(System.in);
		String nomeInput = input.nextLine();

		System.out.print("Nome file output (senza suffisso): ");
		String nomeOutput = input.nextLine();

		System.out.println("* Lettura e scrittura file");
		System.out.println("***********************");

		FileReader filein = null;
		// apre il file in scrittura
		FileWriter fileout = null;
		try
		{
			// apre il file in lettura
			filein = new FileReader(nomeInput);
			// apre il file in scrittura
			fileout = new FileWriter(nomeOutput + ".txt");

			int next;
			do
			{
				next = filein.read(); // legge il prossimo carattere

				if (next != -1)
				{ // se non e' finito il file
					char nextc = (char) next;
					System.out.print(nextc); // stampa il carattere
					// scrittura carattere
					fileout.write(nextc);
				}

			} while (next != -1);

			//
		} 
		catch (IOException e)
		{
			System.out.println(e);
		} 
		finally
		{
			// attenzione in caso di errore sono sicuro che i file siano chiusi i file di ingresso e uscita.
			try
			{
				filein.close(); // chiude il file di input
				fileout.close(); // chiude il file di output
			} catch (IOException e)
			{
				e.printStackTrace();
			} // chiude il file di output e input
		}
		System.out.println("***********************");
		System.out.println("Fine lettura e scrittura file \nBye bye!");
		input.close();
	}

}

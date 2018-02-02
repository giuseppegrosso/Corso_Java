package biz.aeffegroup.lezione4.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test di lettura di un file presente su filesystem e scrittura del suo
 * contenuto a console.
 * 
 * es. prova.xml
 * 
 * 
 * @author g.grosso
 *
 */
public class FileReadTest
{
	public static void main(String[] args)
	{
		System.out.print("Nome file (con suffisso): ");
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();
		System.out.println("* Lettura file");
		System.out.println("***********************");
		FileReader filein = null;
		try
		{
			// apre il file in lettura
			filein = new FileReader(nome);

			int next;
			do
			{
				next = filein.read(); // legge il prossimo carattere

				if (next != -1)
				{ // se non e' finito il file
					char nextc = (char) next;
					System.out.print(nextc); // stampa il carattere
				}

			} while (next != -1);

			filein.close(); // chiude il file

		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		} finally
		{
			// questo pezzo viene sempre fatto.
			System.out.println("questa viene sempre chiamata.");
			if (filein != null)
				try
				{
					filein.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		System.out.println("***********************");
		System.out.println("Fine lettura file \nBye bye!");
		input.close();
	}
}
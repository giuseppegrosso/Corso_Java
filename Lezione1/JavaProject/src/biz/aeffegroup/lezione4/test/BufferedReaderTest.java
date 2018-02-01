package biz.aeffegroup.lezione4.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedReaderTest
{
	public static void main(String[] args) throws IOException
	{

		System.out.print("Nome file output (con suffisso): ");
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();

		// incapsula in BufferedReader un file aperto in lettura
		BufferedReader filebuf = new BufferedReader(new FileReader(nome));
		/*
		 * equivale alla coppia di istruzioni:
		 *
		 * FileReader filein = new FileReader("copyread.txt"); BufferedReader filebuf =
		 * new BufferedReader(filein);
		 */

		String nextStr;
		nextStr = filebuf.readLine(); // legge una riga del file
		while (nextStr != null)
		{
			System.out.println(nextStr); // visualizza la riga
			nextStr = filebuf.readLine(); // legge la prossima riga
		}
		filebuf.close(); // chiude il file
		System.out.println("\nBye bye!");
	}
}
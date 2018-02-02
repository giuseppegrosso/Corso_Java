package biz.aeffegroup.lezione4.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterTest
{
	public static void main(String[] args) throws IOException
	{

		System.out.print("Nome file output (con suffisso): ");
		Scanner input = new Scanner(System.in);
		String nomeOut = input.nextLine();


		// creo un oggetto FileWriter...
		
		File file = new File(nomeOut);

		PrintWriter printout = new PrintWriter(file);
		PrintWriter p2 = new PrintWriter(new FileWriter(nomeOut));
		

		printout.println("Scrivo nel file " + nomeOut);

		printout.println("sono al corso e sto scrivendo un file a caso.");
		printout.print("Un numero: ");
		printout.println(Math.PI);

		printout.print("Un oggetto: ");
		printout.println(new java.awt.Rectangle(10, 15, 20, 30));

		printout.println("Ho finito.");
		printout.close();
		System.out.println("\nBye bye!");
	}
}

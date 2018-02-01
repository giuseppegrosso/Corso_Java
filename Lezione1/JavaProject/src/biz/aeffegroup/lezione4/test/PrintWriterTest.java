package biz.aeffegroup.lezione4.test;

import java.io.BufferedWriter;
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
		FileWriter fileout = new FileWriter(nomeOut);
		// ... che incapsulo in un BufferedWriter...
		BufferedWriter filebuf = new BufferedWriter(fileout);
		// ... che incapsulo in un PrintWriter
		PrintWriter printout = new PrintWriter(filebuf);

		printout.println("Scrivo nel file copyprintwrite.txt:");

		printout.print("Un numero: ");
		printout.println(Math.PI);

		printout.print("Un oggetto: ");
		printout.println(new java.awt.Rectangle(10, 15, 20, 30));

		printout.println("Ho finito.");
		printout.close();
		System.out.println("\nBye bye!");
	}
}

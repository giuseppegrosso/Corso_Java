package biz.aeffegroup.Esercizio1;

import java.util.Scanner;



/**
 * 
 * 
 * 
 * 
//Si realizzi una applicazione java per la gestione di un garage secondo le specifiche:
//il garage ha al max 15 posti ognuno dei quali è identificato da un num a partire da 0
//e per motivi di capienza può ospitare solo auto moto e furgoni partendo dalla classe base veicolo a motore V; la si estenda, realizzando anche le classi che modellano le entità furgone (F) auto (A) e moto (M).
//Ridefinire il metodo toString in modo che ogni entità possa esternalizzare in forma di stringa tutte le informazioni che la riguardano.
//Si implementi una classe che modelli il garage sopradescritto offrendo le seguenti operazioni di gestione
//1] immissione di un nuovo veicolo
//2] estrazione dal garage del veicolo che occupa un determinato posto (ritornare l'istanza del veicolo stesso)
//3] stampa della situazione corrente dei posti nel garage veicolo:
//marca,anno,cilindrata;
//auto:porte, alimentazione (diesel/benzina)
//moto:tempi
//furgone:capacità 

 * 
 * 
 * @author g.grosso
 *
 */
public class Garage
{
	final static int max = 15;

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String mar;// marca
		char db;// diesel o benzina
		int cil, year, par4;
		char ch, scelta;
		int i, j = 0;
		Vettura vettura[] = new Vettura[max]; // istanziazione del vettore
		do
		{
			System.out.print("Moto(m) ,Auto (a) , Furgone (f) ?:");
			ch = in.next().charAt(0);
			System.out.print("marca:");
			mar = in.next();
			System.out.print("anno:");
			year = in.nextInt();
			System.out.print("cilindrata:");
			cil = in.nextInt();
			switch (ch)
			{
			case 'a':
			{
				System.out.print("porte:");
				par4 = in.nextInt();
				System.out.print("diesel o benzina?(d/b):");
				db = in.next().charAt(0);
				Auto a = new Auto(j, mar, year, cil, par4, db);
				vettura[j] = a;
			}
				break;
			case 'f':
			{
				System.out.print("carico:");
				par4 = in.nextInt();
				Furgone f = new Furgone(j, mar, year, cil, par4);
				vettura[j] = f;
			}
				break;
			case 'm':
			{
				System.out.print("tempi:");
				par4 = in.nextInt();
				Furgone f = new Furgone(j, mar, year, cil, par4);
				vettura[j] = f;
			}
				break;
			default:
				System.out.println("scelta non valida");
			}// fine switch
			j++;
			for (i = 0; i < j; i++)
				System.out.println(vettura[i]);
			System.out.print("continui ? (s/n):");
			scelta = in.next().charAt(0);
		} while (scelta != 'n' && j < max);// fine do-while
		System.out.print("indice mezzo da cercare:");
		i = in.nextInt();
		if (i < j && i >= 0)
			System.out.println(vettura[i]);
		else
			System.out.println("elemento non presente");
	}
}
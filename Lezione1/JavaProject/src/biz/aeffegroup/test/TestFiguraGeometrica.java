package biz.aeffegroup.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import biz.aeffegroup.model.Cerchio;
import biz.aeffegroup.model.Quadrato;
import biz.aeffegroup.model.Rettangolo;

public class TestFiguraGeometrica
{

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args)
	{

		int scelta = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci scelta figura\n 1=Rettangolo; 2=Quadrato, 3=Cerchio");

		try
		{
			scelta = input.nextInt();
		} catch (InputMismatchException ime1)
		{
			throw new InputMismatchException(ime1.getMessage());
		} finally
		{
			switch (scelta)
			{
			case 1:
				System.out.println("Hai scelto = Rettangolo");

				try
				{
					System.out.println("Inserisci base ");
					double bas = input.nextDouble();

					System.out.println("Inserisci altezza ");
					double alt = input.nextDouble();

					Rettangolo ret = new Rettangolo(bas, alt);

					double area1 = ret.calcolaArea();
					double perimetro1 = ret.calcolaPerimetro();

					System.out.println(ret.toString());
					System.out.println("Area Rettangolo " + area1);
					System.out.println("Perimetro Rettangolo " + perimetro1);
					break;

				} catch (InputMismatchException ime2)
				{
					throw new InputMismatchException(ime2.getMessage());
				}

			case 2:
				System.out.println("Hai scelto = Quadrato");
				try
				{
					System.out.println("Inserisci lato ");
					double lato = input.nextDouble();

					Quadrato qua = new Quadrato(lato);

					double area2 = qua.calcolaArea();
					double perimetro2 = qua.calcolaPerimetro();

					System.out.println(qua.toString());
					System.out.println("Area Quadrato " + area2);
					System.out.println("Perimetro Quadrato " + perimetro2);
					break;
				} catch (InputMismatchException ime4)
				{
					throw new InputMismatchException(ime4.getMessage());
				}

			case 3:
				System.out.println("Hai scelto = Cerchio");

				try
				{
					System.out.println("Inserisci raggio ");

					double raggio = input.nextDouble();

					Cerchio cer = new Cerchio(raggio);

					double area3 = cer.calcolaArea();
					double perimetro3 = cer.calcolaPerimetro();

					System.out.println(cer.toString());
					System.out.println("Area Cerchio " + area3);
					System.out.println("Circonferenza Cerchio " + perimetro3);
					break;
				} catch (InputMismatchException ime5)
				{
					throw new InputMismatchException(ime5.getMessage());
				}
			}

		}

	}
}
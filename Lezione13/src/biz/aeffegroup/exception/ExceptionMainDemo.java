package biz.aeffegroup.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionMainDemo
{
	public static void main(String args[])
	{
		ExceptionMainDemo main = new ExceptionMainDemo();

		// questa eccezione gestita prosegue l'esecuzione del programma
		try
		{
			main.exception_gestita();

			// tante altre istruzioni.
		} catch (FileNotFoundException e)
		{
			System.out.println(e);
		} catch (IOException e)
		{
			System.out.println(e);
		} catch (Exception e)
		{
			System.out.println("generata eccezione " + e);
			e.printStackTrace(System.out);
		}

		// questa eccezione provoca la fine del programma
		main.exception_nongestita();

		//
		System.out.println("qui non ci arrivo neanche.");
	}

	public void exception_gestita() throws IOException, FileNotFoundException, Exception
	{
		if (true)
			throw new FileNotFoundException();
		
		int num[] =
		{ 1, 2, 3, 4 };
		System.out.println(num[5]);

	}

	public void exception_nongestita()
	{
		int num[] =
		{ 1, 2, 3, 4 };

		if (num.length > 5)
			System.out.println(num[5]);
	}

}

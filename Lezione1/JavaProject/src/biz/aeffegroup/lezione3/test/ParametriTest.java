package biz.aeffegroup.lezione3.test;

public class ParametriTest
{
	
	public static void main(String[] args)
	{
		// TEST 1
		// definisco la variabile x con valore 10
		int x = 10;
		
		// stampo il valore
		printMessage(x);
		
		// passo il valore ad un metodo
		printMessage(tripleValue(x));
		
		// ristampo il valore di x ??? quanto vale 10 o 30???
		printMessage(x);
		
		
		// TEST 2
		
		Employee a = new Employee("Giuseppe", "ciao");
		Employee b = new Employee("Dario", "ciao");
		
		System.out.println("before: " + a);
		System.out.println("before: " +b);
		
		swap(a, b);
		
		System.out.println("after: " +a);
		System.out.println("after: " +b);
		
		
	}
	
	public static void swap (Employee a, Employee b)
	{
		Employee temp = a;
		a = b;
		b = temp;
		
		
	}
	
	public static int tripleValue(int x)
	{
		return x = 3*x;
	}
	
	public static void printMessage(String message)
	{
		System.out.println(message);
	}
	public static void printMessage(int value)
	{
		System.out.println(value);
	}

}

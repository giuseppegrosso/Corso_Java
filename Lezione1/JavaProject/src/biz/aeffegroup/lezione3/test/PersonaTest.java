package biz.aeffegroup.lezione3.test;

public class PersonaTest
{

	public static final Double PIGRECO = 3.14;
	public String pippo;
	
	public static void main(String[] args, String...args2)
	{
		Lavoratore a = new Lavoratore("Dario", "Lipucci", 26, "Tech");
		Lavoratore b = new Lavoratore("Giuseppe", "Grosso", 10, "AF");
		Persona p = new Persona("Paperino", "Paolino", 70);
		a.printMe();
		b.printMe();
		p.printMe();
		
		PersonaTest pp = new PersonaTest();
		
		System.out.println(2*PIGRECO);
		System.out.println(pp.pippo);
	}
}

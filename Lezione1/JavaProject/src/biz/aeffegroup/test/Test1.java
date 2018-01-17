package biz.aeffegroup.test;

public class Test1
{
	private int somma(int addendo1, int addendo2)
	{
		return addendo1 + addendo2;
	}

	public static void main(String[] args)
	{
		Test1 t = new Test1();
		int a = 5, b = 8;
		System.out.println(a + b);

		System.out.println(t.somma(a, b));
	}
}

package biz.aeffegroup.Esercizio1;

public class Furgone extends Vettura
{
	private int carico;

	Furgone(int j, String s, int a, int c, int ca)
	{
		super(j, s, a, c);
		carico = ca;
	}

	public int getid()
	{
		return id;
	}

	public String getm()
	{
		return marca;
	}

	public int geta()
	{
		return anno;
	}

	public int getc()
	{
		return cyl;
	}

	public int getca()
	{
		return carico;
	}

	public String toString()
	{
		String st = getid() + "] " + getm() + " " + geta() + " " + getc() + " " + getca();
		return st;
	}
}
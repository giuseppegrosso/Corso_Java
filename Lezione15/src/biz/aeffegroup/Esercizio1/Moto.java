package biz.aeffegroup.Esercizio1;

public class Moto extends Vettura
{
	private int tempi;

	Moto(int j, String s, int a, int c, int t)
	{
		super(j, s, a, c);
		tempi = t;
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

	public int gett()
	{
		return tempi;
	}

	public String toString()
	{
		String st = getid() + "] " + getm() + " " + geta() + " " + getc() + " " + gett();
		return st;
	}
}
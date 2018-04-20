package biz.aeffegroup.Esercizio1;

public class Auto extends Vettura
{
	private int porte;
	private char alimentazione;

	Auto(int j, String s, int a, int c, int p, char d)
	{
		super(j, s, a, c);
		porte = p;
		alimentazione = d;
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

	public int getp()
	{
		return porte;
	}

	public char getd()
	{
		return alimentazione;
	}

	public String toString()
	{
		String st = getid() + "] " + getm() + " " + geta() + " " + getc() + " " + getp() + " " + getd();
		return st;
	}
}
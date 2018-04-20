package biz.aeffegroup.Esercizio2;

public class Tel
{
	private String numero;
	private int durata;

	public Tel(String n, int d)
	{
		numero = n;
		durata = d;
	}

	public String getn()
	{
		return numero;
	}

	public int getd()
	{
		return durata;
	}
}
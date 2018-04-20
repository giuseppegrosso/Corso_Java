package biz.aeffegroup.Esercizio2;

public class Sim
{
	private String numero;
	private int eff;
	private float credito;
	private Tel tel[];// dichiarazione del vettore delle chiamate

	Sim(String n, int c, int dim)
	{
		numero = n;
		credito = c;
		eff = 0;// eff:chiamate effettuate
		tel = new Tel[dim];// allocazione del vettore delle chiamate
	}

	public void ins(String num, int tempo)
	{
		if (eff < tel.length)
		{
			Tel t = new Tel(num, tempo);
			tel[eff] = t;
			credito -= (float) tempo / 4;// 25cent/min
			eff++;
		} else
			System.out.println("max chiamate effettuate");
	}// fine ins

	public int cal()
	{
		int tot = 0;
		for (int i = 0; i < eff; i++)
			tot += tel[i].getd();
		return tot;
	}// fine cal

	public int conta(String n)
	{
		int tot = 0;
		for (int i = 0; i < eff; i++)
			if (tel[i].getn().equals(n))
				tot++;
		return tot;
	}// fine conta

	public String getn()
	{
		return numero;
	}

	public float getc()
	{
		return credito;
	}

	public String toString()
	{
		String st = "numero:" + getn() + " credito:" + getc() + "\n";
		for (int i = 0; i < eff; i++)
			st += tel[i].getn() + " " + tel[i].getd() + "\n";
		return st;
	}
}

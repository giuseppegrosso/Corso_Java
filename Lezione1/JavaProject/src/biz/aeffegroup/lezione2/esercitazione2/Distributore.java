package biz.aeffegroup.lezione2.esercitazione2;

public class Distributore implements Comparable
{
	private String citta, proprietario;
	private Pompa p;
	private int costo_litro = 1, costo_vendita = 2, incasso = 0, spesa, ricavo;

	public Distributore(String c, String m, int num)
	{
		citta = c;
		proprietario = m;
		p = new Pompa(num);
	}

	public int compareTo(Distributore h)
	{
		return (this.p.capacita_serb - h.p.capacita_serb);
	}

	public String getCitta()
	{
		return citta;
	}

	public void setCitta(String citta)
	{
		this.citta = citta;
	}

	public String getProprietario()
	{
		return proprietario;
	}

	public void setproprietario(String proprietario)
	{
		this.proprietario = proprietario;
	}

	public int getIncasso()
	{
		return incasso;
	}

	public void setIncasso(int incasso)
	{
		this.incasso = incasso;
	}

	public int rifornisci(int num)
	{
		int tmp;
		if (num < p.getcapacita_serb())
		{
			tmp = p.getcapacita_serb();
			tmp = tmp - num;
			p.setcapacita_serb(tmp);
			return costo_vendita * num;
		} else
		{
			int var = costo_vendita * p.getCarb_cont();
			System.out.printf("richiesta non disponibile,verranno erogati " + p.getCarb_cont() + " litri");
			p.setcapacita_serb(0);
			return var;
		}
	}

	public int litri()
	{ // Litri rimasti nella pompa
		return p.getcapacita_serb();
	}

	public void aggiungi(int num)
	{
		spesa = num * costo_litro;
		p.aggiungic(num);
	}

	public int Incassog()
	{// Incasso giornaliero
		ricavo = incasso - spesa;
		return ricavo;
	}
}// fine classe Distributore
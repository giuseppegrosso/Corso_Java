package biz.aeffegroup.lezione2.esercitazione2;

public class Pompa
{
	private int tipop, carb_cont;
	protected int capacita_serb;

	public Pompa(int num)
	{
		this.capacita_serb = num;
	}

	public int gettipop()
	{
		return tipop;
	}

	public void settipop(int tipop)
	{
		this.tipop = tipop;
	}

	public int getCarb_cont()
	{
		return carb_cont;
	}

	public void setCarb_cont(int carb_cont)
	{
		this.carb_cont = carb_cont;
	}

	public int getcapacita_serb()
	{
		return capacita_serb;
	}

	public void setcapacita_serb(int capacita_serb)
	{
		this.capacita_serb = capacita_serb;
	}

	public void aggiungic(int c)
	{// aggiunge il carburante carb_cont=carb_cont+c;
	}
} // fine classe Pompa

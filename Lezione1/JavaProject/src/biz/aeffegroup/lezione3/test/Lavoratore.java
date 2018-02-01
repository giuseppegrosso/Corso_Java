package biz.aeffegroup.lezione3.test;

public class Lavoratore extends Persona
{
	
	private String azienda;
	
	public Lavoratore(String nome, String cognome, Integer eta, String azienda)
	{
		super(nome, cognome, eta);
		this.azienda = azienda;
	}

	public String getAzienda()
	{
		return azienda;
	}

	public void setAzienda(String azienda)
	{
		this.azienda = azienda;
	}
	
	
	@Override
	public String toString()
	{
		return super.toString() + " " + azienda;
	}
	
	
//	public void printMe()
//	{
//		System.out.println(this);
//	}


}

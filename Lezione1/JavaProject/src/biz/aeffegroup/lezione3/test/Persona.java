package biz.aeffegroup.lezione3.test;

public class Persona
{
	protected String cognome;
	protected String nome;
	protected Integer eta;

	public Persona(String nome, String cognome, Integer eta)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Integer getEta()
	{
		return eta;
	}

	public void setEta(Integer eta)
	{
		this.eta = eta;
	}

	@Override
	public String toString()
	{
		return cognome + " " + nome + " " + eta;
	}

	public void printMe()
	{
		System.out.println(this);
	}
}

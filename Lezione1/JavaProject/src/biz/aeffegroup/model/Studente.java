package biz.aeffegroup.model;

public class Studente
{

	public String nome;
	private String cognome;
	private String eta;
	private String classe;
	
	public Studente()
	{
	}

	public Studente(String nome, String cognome, String eta, String classe)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.classe = classe;
	}


	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public String getEta()
	{
		return eta;
	}

	public void setEta(String eta)
	{
		this.eta = eta;
	}

	public String getClasse()
	{
		return classe;
	}

	public void setClasse(String classe)
	{
		this.classe = classe;
	}

	public String toString()
	{
		return Studente.class.getName() + ": " + this.cognome + " " + this.nome + " " + this.eta + " " + this.classe;
	}
}

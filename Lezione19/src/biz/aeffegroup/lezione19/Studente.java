package biz.aeffegroup.lezione19;

public class Studente implements IStudente {

	private String nome;
	private Boolean fuoriCorso;

	public Studente() {
		this.fuoriCorso = new Boolean(false);
	}

	public Studente(String nome, boolean fuoriCorso) {
		this.nome = nome;
		this.fuoriCorso = fuoriCorso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getFuoriCorso() {
		return fuoriCorso;
	}

	public void setFuoriCorso(Boolean fuoriCorso) {
		this.fuoriCorso = fuoriCorso;
	}

	public String toString() {
		return " nome: " + nome;
	}

	@Override
	public boolean isFC() {
		return this.fuoriCorso;
	}

	@Override
	public boolean isLavoratore() {
		return false;
	}
}

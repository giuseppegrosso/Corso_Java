package biz.aeffegroup.lezione19;

public class StudenteLavoratore extends Studente {

	private String professione;

	public StudenteLavoratore() {
	}

	public StudenteLavoratore(String nome, boolean fuoriCorso, String professione) {
		super(nome, fuoriCorso);
		this.professione = professione;
	}

	public String getProfessione() {
		return professione;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}
	
	@Override
	public boolean isLavoratore() {
		return true;
	}
	
	public String toString()
	{
		return super.toString() + " professione: " + professione;
	}

}

package biz.aeffegroup.lezione20;

public class Paziente {

	private String codice;
	private String priorita;

	public Paziente(String cod, String pr) {
		codice = cod;
		priorita = pr;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getPriorita() {
		return priorita;
	}

	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}

	public String tostring() {
		return "Il codice del paziente è " + codice + ". " + "La priorità del paziente è: " + priorita;
	}
}

package biz.aeffegroup.lezione20;

import java.util.ArrayList;
import java.util.List;

public class Soccorso {

	private List<Paziente> attesa;
	public static final String prima = "rosso";
	public static final String seconda = "giallo";
	public static final String terza = "verde";

	public Soccorso() {
		attesa = new ArrayList<Paziente>();
	}

	// primo metodo ausiliare: per la descrizione vedi Consigli
	private int cercaPostoPrimaPriorita() {
		if (attesa.size() == 0)
			return 0;
		for (int i = 0; i < attesa.size(); i++) {
			if (attesa.get(i).getPriorita().equalsIgnoreCase(seconda)
					|| attesa.get(i).getPriorita().equalsIgnoreCase(terza))
				return i;
		}
		return attesa.size();
	}

	// secondo metodo ausiliare: per la descrizione vedi Consigli
	private int cercaPostoSecondaPriorita() {
		int posto = -1;
		if (attesa.size() == 0)
			return 0;
		for (int i = 0; i < attesa.size(); i++) {
			if (attesa.get(i).getPriorita().equalsIgnoreCase(prima))
				posto = i + 1;
		}
		if (posto == -1) {
			for (int j = 0; j < attesa.size(); j++)
				if (attesa.get(j).getPriorita().equalsIgnoreCase(terza))
					return j;
		}
		return posto;
	}

	// metodo per inserire un nuovo Paziente: utilizzare i metodi ausiliari
	public void ingresso(String unCodice, String unaPriorita) {
		if (unaPriorita.equalsIgnoreCase(prima)) {
			int a = cercaPostoPrimaPriorita();
			attesa.add(a, new Paziente(unCodice, unaPriorita));
		}
		if (unaPriorita.equalsIgnoreCase(seconda)) {
			int a = cercaPostoSecondaPriorita();
			attesa.add(a, new Paziente(unCodice, unaPriorita));
		}
		if (unaPriorita.equalsIgnoreCase(terza)) {
			attesa.add(new Paziente(unCodice, unaPriorita));
		}

	}

	public String getArray() {
		String r = "";
		for (int i = 0; i < attesa.size(); i++) {
			r = r + "codice " + attesa.get(i).getCodice() + "priorita " + attesa.get(i).getPriorita() + "\n";
		}
		return r;
	}

	// metodo per servire un Paziente
	public void dimissione() {
		attesa.remove(0);
	}

	// metodo ausiliare al metodo cambio(String unCodice, String nuovaPriorita)
	private int cercaCodice(String unCod) {
		for (int i = 0; i < attesa.size(); i++) {
			if (attesa.get(i).getCodice().equalsIgnoreCase(unCod))
				return i;
		}
		return -1;
	}

	public void cambio(String unCodice, String nuovaPriorita) {
		if (cercaCodice(unCodice) != -1)
			return;
		attesa.remove(cercaCodice(unCodice));
		ingresso(unCodice, nuovaPriorita);
	}

	// metodo che conta i Pazienti della priorità inserita
	public int statistica(String unaPriorita) {
		int r = 0;
		for (int i = 0; i < attesa.size(); i++) {

			if (attesa.get(i).getPriorita().equalsIgnoreCase(unaPriorita))
				r++;
		}
		return r;
	}

	public static void main(String[] args) {
		Soccorso s = new Soccorso();

		s.ingresso("100", Soccorso.prima);
		s.ingresso("101", Soccorso.prima);
		s.ingresso("102", Soccorso.prima);
		s.ingresso("103", Soccorso.prima);
		s.ingresso("104", Soccorso.prima);

		int posizione = s.cercaCodice("104");

		int posto = s.cercaPostoPrimaPriorita();

		System.out.println(posizione);
		System.out.println(posto);
	}
}
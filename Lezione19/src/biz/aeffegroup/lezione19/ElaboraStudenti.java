package biz.aeffegroup.lezione19;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * using java 8 style.
 * @author g.grosso
 *
 *
		1. Realizzare una classe Java Studente per rappresentare studenti, di cui interessa il nome
		(una stringa) e l’informazione sul fatto che siano o meno fuoricorso. Si assuma che:
		• il nome 
		• fuoricorso valore false.
		2. Realizzare una classe Java StudenteLavoratore, sotto-classe della precedente, per rap-
		presentare studenti lavoratori. Delle sue istanze 
		professione 
		
		3. Realizzare una classe utilizzatrice 
		
		1. Filtri i fuori corso (lavoratori e studenti)
		2. restituisca la percentuale dei fuori corso Studenti
		3. restituisca la percentuale dei fuori corso lavoratori.
		4. stampare i nominativi.

 *
 *
 */
public class ElaboraStudenti {

	private Set<Studente> studenti;
	private Set<StudenteLavoratore> studentiLavoratori;

	public ElaboraStudenti() {
	}

	public void inizializza() {
		// caricamento dei dati truedegli studenti:
		if (studenti == null)
			studenti = new HashSet<>();
		studenti.add(new Studente("Filippo", false));
		studenti.add(new Studente("Andrea", false));
		studenti.add(new Studente("Marco", true));
		studenti.add(new Studente("Gianni", false));
		studenti.add(new Studente("Giuseppe", false));
		studenti.add(new Studente("Alfredo", false));
		studenti.add(new Studente("Manrico", true));
		studenti.add(new Studente("David", false));
		studenti.add(new Studente("Davide", true));
		studenti.add(new Studente("Mario", false));

		// caricamento dei dati degli studenti:
		if (studentiLavoratori == null)
			studentiLavoratori = new HashSet<>();
		studentiLavoratori.add(new StudenteLavoratore("Francesco", false, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("irene", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Riccardo", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Alessio", false, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Manfredi", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Gianfranco", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Giuditta", false, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Raffaele", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Pippo", true, "idraulico"));
		studentiLavoratori.add(new StudenteLavoratore("Domenico", false, "idraulico"));

	}

	/**
	 * ritorna la percentuale degli studenti che sono fuori corso
	 * 
	 * @param studenti
	 * @return
	 */
	public double percentualeFuoriCorso() {
		double nroFC = getFuoriCorso().size() *100 / this.studenti.size(); 
		
		return nroFC;
	}

	/**
	 * ritorna la percentuale degli studenti fuori corso lavoratori.
	 * 
	 * @param studenti
	 * @return
	 */
	public double percentualeFuoriCorsoLavoratori() {
		double nroFC = getFuoriCorsoLavoratore().size() * 100 / this.studentiLavoratori.size(); 
		
		return nroFC;
	}

	public Set<Studente> getFuoriCorso() {
		HashSet<Studente> sf = this.studenti.stream().filter(f -> f.getFuoriCorso() == true)
				.collect(Collectors.toCollection(HashSet<Studente>::new));

		return sf;
	}

	public Set<StudenteLavoratore> getFuoriCorsoLavoratore() {
		HashSet<StudenteLavoratore> sf = this.studentiLavoratori.stream().filter(f -> f.getFuoriCorso() == true)
				.collect(Collectors.toCollection(HashSet<StudenteLavoratore>::new));

		return sf;
	}

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}

	public Set<StudenteLavoratore> getStudentiLavoratori() {
		return studentiLavoratori;
	}

	public void setStudentiLavoratori(Set<StudenteLavoratore> studentiLavoratori) {
		this.studentiLavoratori = studentiLavoratori;
	}

	public static void main(String[] args) {
		ElaboraStudenti elab = new ElaboraStudenti();
		elab.inizializza();

		System.out.println("studenti fuori corso: ");
		elab.getStudenti().stream().filter(s -> s.getFuoriCorso() == true).forEach(System.out::println);
		System.out.println("% FC ==>>> " + elab.percentualeFuoriCorso());

		System.out.println("studenti lavoratori fuori corso: ");
		elab.getStudentiLavoratori().stream().filter(s -> s.getFuoriCorso() == true).forEach(System.out::println);
		System.out.println("% FCL ==>>> " + elab.percentualeFuoriCorsoLavoratori());

	}
}

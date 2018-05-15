package biz.aeffegroup.lezione19;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Segreteria {
	
	private Set<IStudente> studenti;

	public Segreteria() {
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
		studenti.add(new StudenteLavoratore("Mario", false, "operaio"));
		studenti.add(new StudenteLavoratore("Francesco", false, "idraulico"));
		studenti.add(new StudenteLavoratore("irene", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Riccardo", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Alessio", false, "idraulico"));
		studenti.add(new StudenteLavoratore("Manfredi", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Gianfranco", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Giuditta", false, "idraulico"));
		studenti.add(new StudenteLavoratore("Raffaele", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Pippo", true, "idraulico"));
		studenti.add(new StudenteLavoratore("Domenico", false, "idraulico"));

	}
	
	public Set<IStudente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<IStudente> studenti) {
		this.studenti = studenti;
	}

	/**
	 * ritorna la percentuale degli studenti che sono fuori corso
	 * 
	 * @param studenti
	 * @return
	 */
	public double percentualeFuoriCorso(boolean islavoratore) {
		double nroFC = getFuoriCorso(islavoratore).size() * 100 / this.studenti.size(); 
		
		return nroFC;
	}
	
	public Set<Studente> getFuoriCorso(boolean lavoratore) {
		HashSet<Studente> sf = this.studenti.stream().filter(f -> f.isFC() == true && f.isLavoratore() == lavoratore)
				.collect(Collectors.toCollection(HashSet<Studente>::new));

		return sf;
	}
	
	
	public static void main(String[] args) {
		Segreteria s = new Segreteria();
		s.inizializza();

		System.out.println("studenti fuori corso: ");
		s.getFuoriCorso(false).forEach(System.out::println);
		System.out.println("% FC ==>>> " + s.percentualeFuoriCorso(false));

		System.out.println("studenti lavoratori fuori corso: ");
		s.getFuoriCorso(true).forEach(System.out::println);
		System.out.println("% FCL ==>>> " + s.percentualeFuoriCorso(true));

	}



}

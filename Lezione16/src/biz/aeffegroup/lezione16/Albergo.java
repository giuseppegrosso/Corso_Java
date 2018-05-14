package biz.aeffegroup.lezione16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * scrivi un programma per la gestione delle prenotazioni delle camere di un albergo.
 * La camera ha una serie di attributi che ne identificano il piano, numero, 
 * vista mare/montagna, capienza, costo ed il tipo (singola, doppia, tripla, etc.)
 * singola 1 persona, doppia 2 persone, tripla 3 persone, quadrupla 4 persone
 * 
 * L'albergo ha a disposizione un numero di camere singole, doppie etc.
 * 
 * es. singole 10, doppie 5, triple 3, quadruple 2
 * 
 * inizialmente l'albergo è vuoto, simulare il form di prenotazione di un albergo con richiesta di 
 * disponibilità da parte del cliente di una camera (in base alla capienza), ed in base al tipo di vista e dica
 * per ogni camera disponibile il costo.
 * 
 * Successivamente si effettui la prenotazione della camera attribuendo a questa il nome di chi ha prenotato.
 * 
 * elenco delle camere libere, camere prenotate e da chi.
 * 
 * 
 * @author g.grosso
 *
 */
public class Albergo {
	
	List<Camera> disponibili;
	Map<Camera, Persona> occupate;
	
	
	public Albergo()
	{
		// inizializzo le camere disponibili es. da un database o in questo caso
		// staticamente.
		init_camere();
	}

	
	public void init_camere() {
		if (disponibili == null) disponibili = new ArrayList<>();
		if (occupate == null) occupate = new HashMap<>();
		
		
		Camera cm = new Camera();

		disponibili.add(cm.getCameraSingolaMare(1, 101));
		disponibili.add(cm.getCameraSingolaMare(1, 102));
		disponibili.add(cm.getCameraSingolaMare(1, 103));

		disponibili.add(cm.getCameraSingolaMontagna(1, 105));
		disponibili.add(cm.getCameraSingolaMontagna(1, 106));
		disponibili.add(cm.getCameraSingolaMontagna(1, 107));
		
		disponibili.add(cm.getCameraDoppiaMare(2, 201));
		disponibili.add(cm.getCameraDoppiaMare(2, 202));
		disponibili.add(cm.getCameraDoppiaMare(2, 203));

		disponibili.add(cm.getCameraDoppiaMontagna(2, 205));
		disponibili.add(cm.getCameraDoppiaMontagna(2, 206));
		disponibili.add(cm.getCameraDoppiaMontagna(2, 207));
		
		disponibili.add(cm.getCameraTriplaMare(3, 301));
		disponibili.add(cm.getCameraTriplaMare(3, 302));
		disponibili.add(cm.getCameraTriplaMare(3, 303));

		disponibili.add(cm.getCameraTriplaMare(3, 305));
		disponibili.add(cm.getCameraTriplaMare(3, 306));
		disponibili.add(cm.getCameraTriplaMare(3, 307));
		
	}
	
	public void listCamere()
	{
		HashSet<String> s = new HashSet<>();
		int i = 1;
		for (Camera camera : disponibili) {
			System.out.println(i + ". " + camera);
			i++;
		}
	}
	
	public static void main(String[] args) {
		Albergo a = new Albergo();

		// lista camere nell'albergo.
		a.listCamere();
		
		Scanner tastiera = new Scanner(System.in);

		String nominativo;
		int i=0;
		
		System.out.println("Seleziona la camera: ");

		
		i = tastiera.nextInt();
		if (i < 0 || i >= a.disponibili.size())
			i= 0;

		System.out.println();
		while (i != 0)
		{
			System.out.println(
					"Inserisci il nominativo della persona: ");
			nominativo = tastiera.nextLine();

			// abbinamento camera a utente.
			
			
		}

	}
}

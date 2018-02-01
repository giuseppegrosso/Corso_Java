package biz.aeffegroup.lezione4.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test di scrittura di un file su filesystem e input del suo
 * contenuto da standard input (digitato dall'utente).
 * 
 * es. prova.xml
 * 
 * 
 * @author g.grosso
 *
 */
public class FileWriteTest
{
    public static void main(String[] args) {
        System.out.print("Nome file (senza suffisso): ");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("* Lettura file");
        System.out.println("***********************");
        try {
            
            // apre il file in scrittura
            FileWriter fileout = new FileWriter(nome + ".txt");
            String str;
            do {
                System.out.print("Scrivi una stringa (vuota per terminare): ");
                // legge una stringa da tastiera
                str = input.nextLine();
                
                // il ciclo scrive ogni carattere delle stringa nel file
                for (int i = 0; i < str.length(); i++)
                    fileout.write(str.charAt(i));
                fileout.write('\n');
                
            } while (str.length() > 0);
            
            fileout.close(); // chiude il file
            
        } catch (IOException e) {
            System.out.println(e);
        } 
        System.out.println("\nBye bye!");
    }
}

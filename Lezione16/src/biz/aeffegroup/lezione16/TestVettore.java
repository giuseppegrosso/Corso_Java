package biz.aeffegroup.lezione16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dato un vettore di 10 interi, tutti diversi fra loro, e un numero intero
 * inserito da tastiera; scrivi un metodo statico che restituisca al programma
 * principale,'elemento del vettore più vicino al numero inserito , la sua
 * posizione nel vettore e la sua distanza dal numero inserito. (sugg. usare un
 * vettore di 3 elementi) .
 */
public class TestVettore {

	public static void main(String args[]) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader h = new BufferedReader(input);
		int num;
		int V[] = { 12, 29, 44, 16, 1, 20, -5, 90, -20, 62 };
		int X[] = { 0, 0, 0 };
		System.out.print("ins.num.intero:");
		num = Integer.parseInt(h.readLine().trim());
		fun(V, X, num);
		System.out.println("elemento:" + X[0]);
		System.out.println("indice:" + X[1]);
		System.out.println("distanza:" + X[2]);
	}

	static void fun(int T[], int Y[], int n) {
		// inizializzo X basandomi sui valori del 1°elemento di T
		Y[0] = T[0];
		Y[1] = 0;
		Y[2] = Math.abs(T[0] - n);
		for (int i = 1; i < T.length; i++)
			if (Math.abs(T[i] - n) < Y[2]) {
				Y[0] = T[i];
				Y[1] = i;
				Y[2] = Math.abs(T[i] - n);
			} // fine if
	}
}

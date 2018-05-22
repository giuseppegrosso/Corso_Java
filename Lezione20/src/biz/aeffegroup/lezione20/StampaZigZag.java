package biz.aeffegroup.lezione20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * scrivere un programma che prevede un array di 10 elementi (numeri interi),
 * con valore a piacere e ne stampi secondo il seguente ordine:
 * 
 * primo, ultimo, secondo, penultimo, terzo, terz'ultimo etc
 * 
 * @author g.grosso
 *
 */
public class StampaZigZag

{
	public List<Integer> zigzag(List<Integer> list) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i < (list.size() / 2 + 1); i++) {
			if (i >= list.size() - i - 1)
				break;
			lista.add(list.get(i));

			// condizione per non ripetere se i e list.size() - i - 1 sono uguali
			lista.add(list.get(list.size() - i - 1));

		}

		return lista;
	}

	public static void main(String[] args) {
		StampaZigZag z = new StampaZigZag();

		List<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
//		array.add(6);

		List<Integer> lista = z.zigzag(array);

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}

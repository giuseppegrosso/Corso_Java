package biz.aeffegroup.lezione16;

public class Somma implements Operazione {

	private double operando1;
	private double operando2;

	@Override
	public double calcola() {
		return operando1 + operando2;
	}

	@Override
	public void inserisci(double operando1, double operando2) {
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	@Override
	public void visualizza() {
		System.out.println(calcola());
	}

}

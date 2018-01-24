package biz.aeffegroup.model;

public interface IFiguraGeometrica
{

	public final double PGRECO = 3.14;

	/**
	 * questo metodo restituisce il perimetro della figura geometrica.
	 * 
	 * @return
	 */
	public double calcolaPerimetro();

	public double calcolaArea();

	public String toString();
}

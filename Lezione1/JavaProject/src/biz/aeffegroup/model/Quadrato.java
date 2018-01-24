package biz.aeffegroup.model;

public class Quadrato implements IFiguraGeometrica
{
	private double lato;

	public Quadrato(double lato)
	{
		this.lato = lato;
	}

	@Override
	public double calcolaPerimetro()
	{
		return lato * 4;
	}

	@Override
	public double calcolaArea()
	{
		return lato * lato;
	}

	public double getLato()
	{
		return lato;
	}

	public void setLato(double lato)
	{
		this.lato = lato;
	}

	/** Stampa di informazioni riguardo la Figura Quadrato **/
	@Override
	public String toString()
	{
		return "Quadrato{" + "lato=" + lato + '}';
	}
}

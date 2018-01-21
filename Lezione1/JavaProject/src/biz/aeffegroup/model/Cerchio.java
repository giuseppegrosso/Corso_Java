package biz.aeffegroup.model;

public class Cerchio implements IFiguraGeometrica
{
	double raggio;

	public Cerchio(double raggio)
	{
		this.raggio = raggio;
	}

	@Override
	public double calcolaPerimetro()
	{
		return 2 * PGRECO * raggio;
	}

	public double getRaggio()
	{
		return raggio;
	}

	public void setRaggio(double raggio)
	{
		this.raggio = raggio;
	}

	@Override
	public double calcolaArea()
	{
		return raggio * raggio * PGRECO;
	}

	@Override
	public String toString()
	{
		return "Cerchio{" + "raggio=" + raggio + '}';
	}

}

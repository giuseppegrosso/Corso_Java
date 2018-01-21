package biz.aeffegroup.model;

public class Rettangolo implements IFiguraGeometrica
{
	double base;
	double altezza;

	public Rettangolo(double base, double altezza)
	{
		this.base = base;
		this.altezza = altezza;
	}

	@Override
	public double calcolaPerimetro()
	{
		return (this.base + this.altezza) * 2;
	}

	@Override
	public double calcolaArea()
	{
		return this.base * this.altezza;
	}

	public double getBase()
	{
		return base;
	}

	public void setBase(double base)
	{
		this.base = base;
	}

	public double getAltezza()
	{
		return altezza;
	}

	public void setAltezza(double altezza)
	{
		this.altezza = altezza;
	}

	/** Stampa di informazioni riguardo la Figura Rettangolo **/
	@Override
	public String toString()
	{
		return "Rettangolo{" + "base=" + base + ", altezza=" + altezza + '}';
	}
}

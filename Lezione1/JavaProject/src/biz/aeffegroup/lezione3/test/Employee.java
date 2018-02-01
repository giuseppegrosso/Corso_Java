package biz.aeffegroup.lezione3.test;

public class Employee
{
	private String name;
	private String valore;
	public Employee()
	{
	}
	public Employee(String name, String valore)
	{
		this.setName(name);
		this.setValore(valore);
	}
	public String getValore()
	{
		return valore;
	}
	public void setValore(String valore)
	{
		this.valore = valore;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return name + " " + valore;
	}
}

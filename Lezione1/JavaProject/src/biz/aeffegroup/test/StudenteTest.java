package biz.aeffegroup.test;

import biz.aeffegroup.model.Studente;

public class StudenteTest
{
	public static void main(String[] args)
	{
		Studente s = new Studente("Paolino", "Paperino", "10", "5A");

		System.out.println(s.toString());
	}

}

package biz.aeffegroup.lezione6;

import java.text.NumberFormat;
import java.util.Locale;

public class AmountTest
{

	public static void main(String[] args)
	{
		double amount = 1200.0;
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		System.out.println(currencyFormatter.format(amount));
	}

}

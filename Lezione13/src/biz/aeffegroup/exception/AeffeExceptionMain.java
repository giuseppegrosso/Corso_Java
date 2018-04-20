package biz.aeffegroup.exception;

public class AeffeExceptionMain
{
	AeffeException newExc = new AeffeException("Messaggio della mia eccezione.");

	public AeffeExceptionMain() throws AeffeException
	{
		String msg= "Questa è un esempio di eccezione";
		System.out.println(msg);
		throw newExc;
	}

	public static void main(String args[])
	{
		try
		{
			AeffeExceptionMain use = new AeffeExceptionMain();
		} catch (AeffeException myEx)
		{
			System.out.println("Questa è la mia eccezione di tipo AEFFE:" + myEx.getMessage());
		}
	}

}

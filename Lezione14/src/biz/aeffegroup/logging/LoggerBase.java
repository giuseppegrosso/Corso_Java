package biz.aeffegroup.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerBase
{
	
	Logger myLogger = Logger.getLogger("biz.aeffegroup.lezione14");
	
	public LoggerBase()
	{
		// loggo il livello più basso di logging.
		myLogger.setLevel(Level.FINEST);
		//myLogger.addHandler(new ConsoleHandler());
		try
		{
			myLogger.addHandler(new FileHandler("c:/temp/logExample.log", 100, 10));
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void debug(String message, Throwable t)
	{
		myLogger.log(Level.FINE, message, t);
	}
	public void error(String message, Throwable t)
	{
		myLogger.log(Level.SEVERE, message, t);
	}
	public void info(String message, Throwable t)
	{
		myLogger.log(Level.INFO, message, t);
	}
	public void waning(String message, Throwable t)
	{
		myLogger.log(Level.WARNING, message, t);
	}
	
	public static void main(String[] args)
	{
		LoggerBase lb = new LoggerBase();
		lb.myLogger.log(Level.FINE, "prova");
		
		try
		{
			throw new RuntimeException("Errore provocata da programma");
		}
		catch(Exception e)
		{
			lb.debug("eccezione gestita", e);
			lb.info("eccezione gestita", e);
			lb.waning("eccezione gestita", e);
			lb.error("eccezione gestita", e);
			lb.debug("eccezione gestita", e);
			lb.debug("eccezione gestita", e);
			lb.debug("eccezione gestita", e);
		}
	}

}

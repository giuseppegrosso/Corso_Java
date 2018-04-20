package biz.aeffegroup.logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTest
{
	LoggerBase mLogger = null;
	public MyClassTest()
	{
		// TODO Auto-generated constructor stub
		mLogger = new LoggerBase();
	}
	
	public long myltiply(int first, int second)
	{
		return first * second;
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown()
	{
		MyClassTest tester = new MyClassTest();
		tester.myltiply(1000, 5);
	}

	@Test
	public void multiply()
	{
		mLogger.debug("ciao", null);
		MyClassTest tester = new MyClassTest();
		assertEquals("10 x 5 must be 50", 50, tester.myltiply(10, 5));
	}
}
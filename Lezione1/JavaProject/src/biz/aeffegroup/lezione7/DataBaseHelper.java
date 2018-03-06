package biz.aeffegroup.lezione7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper
{
	private static String DB_URL = "jdbc:sqlite:";
	// private static String DB_URL = "jdbc:sqlite:C:/temp/Lezione6/";

	private String path;
	private String filename;

	public DataBaseHelper(String path, String filename)
	{
		this.filename = filename;
		this.path = path;
	}

	/**
	 * Connect to the database
	 *
	 * @return the Connection object
	 */
	public Connection connect()
	{
		return this.connect(false);
	}

	/**
	 * Connect to the database
	 *
	 * @return the Connection object
	 */
	public Connection connect(boolean transaction)
	{
		// SQLite connection string
		String url = DB_URL + filename;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(!transaction);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * create database.
	 *
	 * @param fileName
	 *            the database file name
	 */
	protected void createDataBase()
	{

		try (Connection conn = this.connect())
		{
			if (conn != null)
			{
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created at: " + DB_URL + path + filename);
			}

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void executeStatement(String sql) throws SQLException
	{
		try (Connection conn = this.connect(); Statement stmt = conn.createStatement())
		{
			stmt.executeQuery(sql);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
}

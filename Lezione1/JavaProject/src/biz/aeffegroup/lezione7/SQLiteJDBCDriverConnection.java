package biz.aeffegroup.lezione7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBCDriverConnection
{

	Connection conn = null;

	/**
	 * connessione ad un semplice database.
	 */

	/**
	 * Connect to the test.db database
	 * 
	 * @return the Connection object
	 */
	private Connection connect()
	{
		// SQLite connection string
		String url = "jdbc:sqlite:C:/temp/chinook/chinook.db";
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void disconnect()
	{
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * select all rows in the warehouses table
	 */
	public void selectAll()
	{
		String sql = "SELECT * FROM albums";
		// try with resource ... java 7.
		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql))
		{

			// loop through the result set
			while (rs.next())
			{
				System.out.println(rs.getInt("albumid") + "\t" + rs.getString("title") + "\t" + rs.getDouble("ArtistId"));
			}
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		// superfluo...
		disconnect();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		new SQLiteJDBCDriverConnection().selectAll();
	}
}
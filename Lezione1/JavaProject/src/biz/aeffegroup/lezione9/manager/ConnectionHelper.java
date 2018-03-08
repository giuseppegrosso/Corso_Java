package biz.aeffegroup.lezione9.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ConnectionHelper
{
	private boolean isTransaction;
	private String dbname;
	private static String DB_URL = "jdbc:sqlite:";

	public ConnectionHelper()
	{
		this("c:\\temp\\lezione9.db");
	}

	public ConnectionHelper(String dbname)
	{
		this.dbname = dbname;
	}

	public boolean isTransaction()
	{
		return isTransaction;
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
		String url = DB_URL + dbname;
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
	 * metodi di comodo per eseguire una query ed ottenere una lista di oggetti.
	 * 
	 * Attenzione la connessione NON viene chiusa, la chiusura è a carico del
	 * chiamante.
	 * 
	 * @param <T>
	 */
	@SuppressWarnings(
	{ "rawtypes" })
	public <T> List<T> getListDataFromDb(String query, Class clazz)
	{
		List<T> datas = null;

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query))
		{

			ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
			datas = resultSetMapper.mapResultSetToListObject(rs, clazz);

		} catch (SQLException e)
		{
			System.out.println("Errore esecuzione Query " + query + " " + e);
		}

		return datas;
	}

	/**
	 * metodi di comodo per eseguire una query ed ottenere un oggetto riempito.
	 * 
	 * Attenzione la connessione NON viene chiusa, la chiusura è a carico del
	 * chiamante.
	 * 
	 * @param <T>
	 */
	@SuppressWarnings(
	{ "rawtypes" })
	public <T> T getDataFromDb(String query, Class clazz)
	{

		T data = null;
		List<T> datas = getListDataFromDb(query, clazz);

		if (datas != null && datas.size() > 1)
		{
			System.out.println("trovati piu' risultati ritorno il primo: " + datas.size());
			data = datas.get(0);
		}
		if (datas != null && datas.size() == 1)
			data = datas.get(0);

		return data;
	}
}

package biz.aeffegroup.lezione7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import biz.aeffegroup.lezione7.pojo.MyTable;

/**
 * esempio di scrittura di database sqlite.
 * 
 * @author g.grosso
 *
 */
public class CreateDataBase
{

	private static String DB_URL = "jdbc:sqlite:C:/temp/Lezione6/";
	private String filename;
	private String tablename;

	public CreateDataBase(String filename)
	{
		this.filename = filename;
	}

	/**
	 * Connect to the database
	 *
	 * @return the Connection object
	 */
	private Connection connect()
	{
		// SQLite connection string
		String url = DB_URL + filename;
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

	/**
	 * create database.
	 *
	 * @param fileName
	 *            the database file name
	 */
	public void create()
	{

		try (Connection conn = this.connect())
		{
			if (conn != null)
			{
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Create a new table in the test database
	 *
	 */
	public void createNewTable(String mytable)
	{
		// SQLite connection string
		this.tablename = mytable;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + mytable + " (\n" + "	id integer PRIMARY KEY,\n"
				+ "	name text NOT NULL,\n" + "	age integer\n" + ");";

		try (Connection conn = this.connect(); Statement stmt = conn.createStatement())
		{
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Created table " + mytable);
	}

	/**
	 * insert list of value
	 *
	 */
	public void insert(List<MyTable> lt)
	{
		for (MyTable myTable : lt)
		{
			insert(myTable);
		}
	}

	/**
	 * insert single value
	 *
	 */
	public void insert(MyTable myTable)
	{
		// SQLite connection string
		String sql = "INSERT INTO " + tablename + "(id,name,age) VALUES(?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setInt(1, myTable.getId());
			pstmt.setString(2, myTable.getName());
			pstmt.setInt(3, myTable.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("insert values into table " + tablename + " " + myTable.getName());
	}

	/**
	 * insert single value
	 *
	 */
	public void delete(MyTable myTable)
	{
		delete(myTable.getId());
	}

	/**
	 * Delete a warehouse specified by the id
	 *
	 * @param id
	 */
	public void delete(int id)
	{
		String sql = "DELETE FROM " + tablename + " WHERE id = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
		{

			// set the corresponding param
			pstmt.setInt(1, id);
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("deleted value " + id);
	}

	/**
	 * Update data of a warehouse specified by the id
	 *
	 * @param id
	 * @param name
	 *            name of the warehouse
	 * @param age
	 *            capacity of the warehouse
	 */
	public void update(Integer id, String name, Integer age)
	{
		String sql = "UPDATE " + tablename + " SET name = ? , " + "age = ? " + "WHERE id = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
		{

			// set the corresponding param
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, id);
			// update
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		CreateDataBase c = new CreateDataBase("test.db");
		c.create();
		c.createNewTable("myTable");
		List<MyTable> lt = new ArrayList<>();
		MyTable m = new MyTable(1, "Giuseppe Grosso", 20);

		lt.add(m);
		m = new MyTable(2, "Dario Lipucci", 20);
		lt.add(m);
		c.insert(lt);

		c.delete(m);
		c.update(1, "Grosso Giuseppe 2", 25);

		c.insert(m);
	}
}

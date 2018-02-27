package biz.aeffegroup.lezione7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	protected Connection connect()
	{
		// SQLite connection string
		String url = DB_URL + path + filename;
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
	protected void create()
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

	
//	/**
//	 * insert list of value
//	 *
//	 */
//	public void insert(List<MyTable> lt)
//	{
//		for (MyTable myTable : lt)
//		{
//			insert(myTable);
//		}
//	}
//
//	/**
//	 * insert single value
//	 *
//	 */
//	public void insert(MyTable myTable)
//	{
//		// SQLite connection string
//		String sql = "INSERT INTO " + tablename + "(id,name,age) VALUES(?,?,?)";
//		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
//		{
//			pstmt.setInt(1, myTable.getId());
//			pstmt.setString(2, myTable.getName());
//			pstmt.setInt(3, myTable.getAge());
//			pstmt.executeUpdate();
//		} catch (SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		System.out.println("insert values into table " + tablename + " " + myTable.getName());
//	}
//
//	/**
//	 * insert single value
//	 *
//	 */
//	public void delete(MyTable myTable)
//	{
//		delete(myTable.getId());
//	}
//
//	/**
//	 * Delete a warehouse specified by the id
//	 *
//	 * @param id
//	 */
//	public void delete(int id)
//	{
//		String sql = "DELETE FROM " + tablename + " WHERE id = ?";
//
//		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
//		{
//
//			// set the corresponding param
//			pstmt.setInt(1, id);
//			// execute the delete statement
//			pstmt.executeUpdate();
//
//		} catch (SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		System.out.println("deleted value " + id);
//	}
//
//	/**
//	 * Update data of a warehouse specified by the id
//	 *
//	 * @param id
//	 * @param name
//	 *            name of the warehouse
//	 * @param age
//	 *            capacity of the warehouse
//	 */
//	public void update(Integer id, String name, Integer age)
//	{
//		String sql = "UPDATE " + tablename + " SET name = ? , " + "age = ? " + "WHERE id = ?";
//
//		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
//		{
//
//			// set the corresponding param
//			pstmt.setString(1, name);
//			pstmt.setInt(2, age);
//			pstmt.setInt(3, id);
//			// update
//			pstmt.executeUpdate();
//		} catch (SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}
//	}	
}

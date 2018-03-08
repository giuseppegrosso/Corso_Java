package biz.aeffegroup.lezione9.manager;

import java.util.List;

public class AbstractManager
{
	protected ConnectionHelper myConnection = null;

	protected String tableName;
	protected String keyName;
	
	public final String SELECT_QUERY = "SELECT %S FROM %S WHERE 1=1";

	public AbstractManager()
	{
	}

	public AbstractManager(ConnectionHelper conn)
	{
		this.myConnection = conn;
	}

	@SuppressWarnings("rawtypes")
	public <T> T getByPKey(String key, Class clazz)
	{
		return this.getByPKey(new Long(key), clazz);
	}

	@SuppressWarnings("rawtypes")
	public <T> T getByPKey(Long key, Class clazz)
	{
		return this.getSingleObjectByQuery(String.format(SELECT_QUERY, "*", this.tableName + " obj") + " AND obj." + this.keyName + " = " + key, clazz);
	}

	@SuppressWarnings("rawtypes")
	public <T> List<T> getList(Class clazz)
	{
		return this.getListObjectByQuery(String.format(SELECT_QUERY, "*", this.tableName + " obj"), clazz);
	}

	protected ConnectionHelper getConn()
	{
		if (myConnection != null)
			return myConnection;

		return new ConnectionHelper();
	}

	@SuppressWarnings(
	{ "rawtypes" })
	protected <T> T getSingleObjectByQuery(String query, Class clazz)
	{
		T pojo = null;
		try
		{

			pojo = getConn().getDataFromDb(query, clazz);

		} catch (Exception e1)
		{
			System.out.println("Errore: " + e1.getMessage());
		}

		return pojo;

	}

	@SuppressWarnings(
	{ "rawtypes" })
	public <T> List<T> getListObjectByQuery(String query, Class clazz)
	{
		List<T> pojos = null;
		try
		{
			pojos = getConn().getListDataFromDb(query, clazz);

		} catch (Exception e1)
		{
			System.out.println("Errore: " + e1.getMessage());
			throw new RuntimeException(e1.getMessage(), e1);
		}
		return pojos;

	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public String getKeyName()
	{
		return keyName;
	}

	public void setKeyName(String keyName)
	{
		this.keyName = keyName;
	}

}

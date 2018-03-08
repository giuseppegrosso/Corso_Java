package biz.aeffegroup.lezione9.manager;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Classe di mapping del resultSet in oggetto:
 * Nota l'oggetto deve essere definito come Entity e ogni singola proprietà deve avere l'annotation @Column(name="xxx")
 * 
 * @author Giuseppe Grosso Aeffegroup.biz
 *
 * @param <T>
 *
 * 05 mag 2017
 */
public class ResultSetMapper<T>
{
	// This method is already implemented in package
	// but as far as I know it accepts only public class attributes
	private void setProperty(Object clazz, Field fieldInput, Object columnValue)
	{
		try
		{
			// get all fields of the class (including public/protected/private)
			Field field = clazz.getClass().getDeclaredField(fieldInput.getName());
			// this is necessary in case the field visibility is set at private
			field.setAccessible(true);
			if (fieldInput.getType() == Long.class)
				field.set(clazz, columnValue);
			field.set(clazz, columnValue);
		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
	
	private Field getField(Field[] fields, String columnName)
	{
		// iterating over clazz attributes to check
		// if any attribute has 'Column' annotation with
		// matching 'name' value
		Field mfield = null;
		for (Field field : fields)
		{
			if (field.isAnnotationPresent(Column.class))
			{
				Column column = field.getAnnotation(Column.class);
				if (column.name().equalsIgnoreCase(columnName))
				{
					mfield = field;
					break;
				}
			}
		}
		return mfield;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> mapResultSetToListObject(ResultSet rs, Class clazz)
	{
		List<T> outputList = null;
		try
		{
			// make sure resultset is not null
			if (rs != null)
			{
				// check if Class clazz has the 'Entity' annotation
				if (clazz.isAnnotationPresent(Entity.class))
				{
					// get the resultset metadata
					ResultSetMetaData rsmd = rs.getMetaData();

					// get all the attributes of Class clazz
					Field[] fields = clazz.getDeclaredFields();

					while (rs.next())
					{
						T bean = (T) clazz.newInstance();
						for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++)
						{
							// get the SQL column name
							String columnName = rsmd.getColumnName(_iterator + 1);

							Field field = getField(fields, columnName);
							
							// get the value of the SQL column
							Object columnValue = null; 
							if (field != null)
							{
								// case different fieldType.
								if (field.getType() == Long.class)
									columnValue = rs.getLong(_iterator + 1); 
								else if (field.getType() == Integer.class)
									columnValue = rs.getInt(_iterator + 1); 
								else if (field.getType() == Date.class)
									columnValue = rs.getDate(_iterator + 1); 
								else if (field.getType() == String.class)
									columnValue = rs.getString(_iterator + 1); 
								else if (field.getType() == Double.class)
									columnValue = rs.getDouble(_iterator + 1); 
								else if (field.getType() == Boolean.class)
									columnValue = rs.getBoolean(_iterator + 1); 
								else if (field.getType() == Calendar.class)
								{
									Date date = rs.getDate(_iterator + 1);
									
									columnValue = Calendar.getInstance();
									if (date != null)
										((Calendar)columnValue).setTime(date);
									else
										columnValue = null;
								}
								else  
								    columnValue = rs.getObject(_iterator + 1); 
								// only if columnValue is not null set the properties.
								if (columnValue != null)
									this.setProperty(bean, field, columnValue);
					
							
							}
						}
						if (outputList == null) outputList = new ArrayList<T>();
						outputList.add(bean);
					}
				}
				else
				{
					// throw some error that Class clazz
					// does not have @Entity annotation
				}
			}
			else
			{
				// ResultSet is empty
				return null;
			}
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}

		return outputList;
	}
}
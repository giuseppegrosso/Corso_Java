package biz.aeffegroup.jira.pojo;

import java.security.Principal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Principal
{

	private String password;

	private String username;

	public User()
	{
	}

	public User(String username, String pw)
	{
		this.username = username;
		this.password = pw;
	}

	@Override
	public String getName()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

}

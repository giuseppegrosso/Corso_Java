package biz.aeffegroup.jira.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * definisco un servizio di test.
 * 
 * @author g.grosso
 *
 */
@Path("/jira")
public class JiraService
{
	@GET
	@Path("/{name}")
	public Response sayHello(@PathParam("name") String msg)
	{
		String output = "Hello, " + msg + "!";
		return Response.status(200).entity(output).build();
	}
	
	
	@GET
	@Path("/id/{id}")
	public Response getByID(@PathParam("id") String id)
	{
		String output = "Hello, this is your ID " + id + "!";
		return Response.status(200).entity(output).build();
	}
}

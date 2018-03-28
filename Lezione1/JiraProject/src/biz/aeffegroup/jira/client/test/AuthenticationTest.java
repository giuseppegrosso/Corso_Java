package biz.aeffegroup.jira.client.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import biz.aeffegroup.jira.pojo.User;

public class AuthenticationTest
{
	public static final String BASE_URI = "https://api.github.com";
	
	public static final String JIRA_URI = "http://tch-jira01:8080";
	
	public static final String JIRA_AUTH = JIRA_URI.concat("/rest/auth/1/session");
	
	public static final String JIRA_FILTERS = JIRA_URI.concat("/rest/api/2/filter");
	
	public static final String JIRA_PROPERTIES = JIRA_URI.concat("/rest/api/2/application-properties");
	
	

	static final String AUTHENTICATION_URI = BASE_URI.concat("");
	static final String VIAGGIARETRENO_STAZIONI_URI = "http://www.viaggiatreno.it/viaggiatrenonew/resteasy/viaggiatreno/autocompletaStazione/";
	static final String VIAGGIARETRENO_PERCORSO_URI = "http://www.viaggiatreno.it/viaggiatrenonew/resteasy/viaggiatreno/soluzioniViaggioNew/";

	static final int OK_HTTP = 200;

	private Client client = null;
	protected String token = null;

	public static void main(String[] args)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:MM:ss");
		String timestamp = sdf.format(Calendar.getInstance().getTime());
		
		AuthenticationTest st = new AuthenticationTest();
		// st.testPostAuthentication();
		 st.testJiraPostAuthentication();
		 
//		 st.callAPIJira(JIRA_FILTERS);
		 st.callAPIJira(JIRA_PROPERTIES);
		 
		 

//		st.callAPIViaggiareTreno(VIAGGIARETRENO_STAZIONI_URI.concat("PRATO"));
//		st.callAPIViaggiareTreno(VIAGGIARETRENO_STAZIONI_URI.concat("FIRENZE"));
//
//		st.callAPIViaggiareTreno(VIAGGIARETRENO_PERCORSO_URI.concat("6426").concat("/").concat("6421").concat("/").concat(timestamp));

	}

	public void testPostAuthentication()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci la password: ");
		String pwd = "";
		try
		{
			pwd = input.nextLine();
		} catch (InputMismatchException ime1)
		{
			throw new InputMismatchException(ime1.getMessage());
		} finally
		{
			input.close();
		}

		String json = postAuthentication(new User("giuseppe.ing.grosso@gmail.com", pwd), BASE_URI);

		System.out.println(json);

	}
	
	
	public void testJiraPostAuthentication()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci la password: ");
		String pwd = "";
		try
		{
			pwd = input.nextLine();
		} catch (InputMismatchException ime1)
		{
			throw new InputMismatchException(ime1.getMessage());
		} finally
		{
			input.close();
		}

		String json = postAuthentication(new User("048108080", pwd), JIRA_AUTH);

		System.out.println(json);

	}


	private void initClient(String username, String pwd)
	{
		ClientConfig config = new ClientConfig();
		config.register(JacksonJsonProvider.class);
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(username, pwd);
		client = ClientBuilder.newClient(config);
		client.register(feature);

		/**
		 * es. USer: nome, cognome,dataNascita [ { "nome" : "xxxxx", "cognome": "xxxx",
		 * "dataNascita" : "yyDDMM" }, { "nome" : "xxxxx", "cognome": "xxxx",
		 * "dataNascita" : "yyDDMM" } ]
		 */

	}
	
	public void callAPIJira(String url)
	{
		System.out.println("url: " + url);
//		initClient("048108080", "");
		Response response = client.target(url).request().get();

		String json = "";
		System.out.println(response.getStatus());
		if (response.getStatus() == OK_HTTP)
		{
			json = response.readEntity(String.class);
		}
		

		System.out.println(json);
	}

	public String postAuthentication(User credential, String uri)
	{
		initClient(credential.getUsername(), credential.getPassword());
		Response response = client.target(uri).request(MediaType.APPLICATION_JSON).get();

		String json = "";
		if (response.getStatus() == OK_HTTP)
		{
			json = response.readEntity(String.class);
		}
		return json;
	}

	public void callAPIViaggiareTreno(String url)
	{
		System.out.println("url: " + url);
		initClient(null, null);
		Response response = client.target(url).request().get();

		String json = "";
		if (response.getStatus() == OK_HTTP)
		{
			json = response.readEntity(String.class);
		}

		System.out.println(json);
	}

	public <T> List<T> getListEntity(Class<T> clazz, String uri)
	{
		initClient(null, null);
		WebTarget target = client.target(uri);
		Builder builder = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
				"Bearer " + token);
		Response response = builder.get(Response.class);
		if (response.getStatus() == OK_HTTP)
		{
			return (List<T>) response.readEntity(new GenericType<List<T>>(new ParameterizedType()
			{

				public Type[] getActualTypeArguments()
				{
					return new Type[]
					{ clazz };
				}

				public Type getRawType()
				{
					return List.class;
				}

				public Type getOwnerType()
				{
					return null;
				}
			}));
		}
		return null;
	}

	public <T> T getEntity(Long id, Class<T> clazz, String uri)
	{
		initClient(null, null);
		WebTarget target = client.target(uri).path(String.valueOf(id));
		Builder builder = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
				"Bearer " + token);
		Response response = builder.get(Response.class);
		if (response.getStatus() == OK_HTTP)
		{
			return response.readEntity(clazz);
		}
		return null;
	}

	public <T> T postEntity(T entity, Class<T> clazz, String uri)
	{
		WebTarget target = client.target(uri);
		Builder builder = target.request().accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
				"Bearer " + token);
		Response response = builder.post(Entity.json(entity));

		if (response.getStatus() == OK_HTTP)
		{
			return response.readEntity(clazz);
		}
		return null;
	}

	public <T> T putEntity(T entity, Class<T> clazz, String uri)
	{
		WebTarget target = client.target(uri);
		Builder builder = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
				"Bearer " + token);
		Response response = builder.put(Entity.json(entity));
		if (response.getStatus() == OK_HTTP)
		{
			return response.readEntity(clazz);
		}
		return null;
	}

	public <T> String deleteEntity(Long id, Class<T> clazz, String uri)
	{
		// initClient();
		WebTarget target = client.target(uri).path(String.valueOf(id));
		Builder builder = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION,
				"Bearer " + token);
		Response response = builder.delete();
		return "Server Output: " + response.readEntity(clazz) + " - HTTP code: " + response.getStatus();
	}

	/**
	 * generalizzo i test per le delete. attenzione se non diversamente esplicitato
	 * casto a Long.
	 * 
	 * @param id
	 * @param Url
	 */
	public <T> void testDelete(Long id, String Url)
	{
		System.out.println(deleteEntity(id, Long.class, Url));
	}

	/**
	 * generalizzo i test per le delete.
	 * 
	 * @param id
	 * @param Url
	 */
	public <T> void testDelete(Long id, Class<T> clazz, String Url)
	{
		System.out.println(deleteEntity(id, clazz, Url));
	}

	protected static <T> void printNames(List<T> list, Consumer<T> c)
	{
		list.forEach(x -> c.accept(x));
	}

	// Stampa per i test
	public <T> void printForVerifyTest(T elem, String uriToConcat, String errMsg)
	{
		printForVerifyTest(Arrays.asList(elem), uriToConcat, errMsg);
	}

	public <T> void printForVerifyTest(T elem, String uriToConcat)
	{
		printForVerifyTest(elem, uriToConcat, "Oggetto non trovato");
	}

	public <T> void printForVerifyTest(List<T> listOfElem, String uriToConcat)
	{
		printForVerifyTest(listOfElem, uriToConcat, "Oggetto non trovato");
	}

	public <T> void printForVerifyTest(List<T> listOfElem, String uri, String errMsg)
	{
		System.out.println("response: " + uri);

		if (listOfElem == null)
			System.err.println(errMsg);
		else
			listOfElem.forEach(System.out::println);
	}
}

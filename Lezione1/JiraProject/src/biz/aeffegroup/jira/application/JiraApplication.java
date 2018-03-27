package biz.aeffegroup.jira.application;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Application: definisco quali sono le mie risorse per i servizi REST.
 * 
 * @author g.grosso
 * sito per jira api.
 * https://developer.atlassian.com/cloud/jira/platform/rest/#error-responses
 */
public class JiraApplication extends ResourceConfig
{
	public JiraApplication()
	{
		// Define the package which contains the service classes.
		packages("biz.aeffegroup.jira.service");
	}
}
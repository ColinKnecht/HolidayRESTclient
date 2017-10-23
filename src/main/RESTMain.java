package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Calls the RESTful web service at REST_URL defined below
 * @author colinknecht
 *
 */
public class RESTMain {
	public static final String REST_URL = "www.url.com";
	
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();

	/**
	 * Call the web service and display the response
	 * @param args
	 */
	public static void main(String[] args) {
		// call the service and get the response object
		Response response = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_XML)
				.get();
		//
				
		
		//process the response object

	}

}

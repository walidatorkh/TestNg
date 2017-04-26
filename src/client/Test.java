

	package client;

	import java.net.URI;

		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.UriBuilder;
		
		import com.sun.jersey.api.client.Client;
		import com.sun.jersey.api.client.WebResource;
		import com.sun.jersey.api.client.config.ClientConfig;
		import com.sun.jersey.api.client.config.DefaultClientConfig;

	public class Test {
	  public static void main(String[] args) {
	    ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());

	    String response = service.path("hello").queryParam("myName","A").queryParam("lastName","B").accept(MediaType.TEXT_XML).get(String.class).toString();
	    
	    System.out.println(response);
	   
	  }

	  private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/RestTest/rest").build();
	  }

	} 

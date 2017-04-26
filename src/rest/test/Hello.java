package rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import stam.Stam;

// test on :   http://localhost:8080/RESTful/rest/hello   (/rest/ url pattern defined in web.xml)
@Path("/hello")
public class Hello {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello(@QueryParam("myLastName") String lastName, @QueryParam("myName") String name) {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello " + name + " " + lastName + "</body></h1>" + "</html> ";
  }
  
  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("{lang}")
  public String sayHtmlHelloWithLanguages(@QueryParam("myLastName") String lastName, @QueryParam("myName") String name, @PathParam("lang") String language) {
	  
	  String hello;
	
	Stam stam; 
	stam = new Stam();
	stam.stam();
	
	switch (language.toUpperCase()) {		
		case "ES": hello = "Hola"; break;
		case "HE": hello = "Shalom"; break;
		case "EN": default: hello = "Hello"; break;
	}
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + hello + " " + name + " " + lastName + "</body></h1>" + "</html> ";
  }

  
  @GET
  //@Produces(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/createPerson")
  // For exmple: http://localhost:8080/RestTest/rest/hello/createPerson?name=Tavor
  public Person createPerson(@QueryParam("name") String name) {
	  
	  Person person = new Person();
	  person.setName(name);
	  return person;
	  
  }
  
} 


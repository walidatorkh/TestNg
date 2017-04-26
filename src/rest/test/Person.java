package rest.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement /* This will enable conversion to and from XML and also JSON! */
public class Person {

	String name;
	Integer id;

	public Person() {
		id = (new java.util.Random()).nextInt(999999); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}

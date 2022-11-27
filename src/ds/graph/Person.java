package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

/**Class Person represents one individual within a social graph
 */
public class Person {
	
	/**String name to store the name of the person
	 */
	public String name = " ";
	/**Store age of the person
	 */
	public int age = 0;
	/**Store value for social hygiene
	 */
	float socialHygine = 0;
	/**Store the value for infectiveness in every person
	 */
	private Float  getInfectiveness;
	
	/**Store the business destination of a person
	 */
	Business destinationBusiness;
	
	/**Array list that contains all the contacts(edges) for a person
	 */
	ArrayList<Person> contacts = new ArrayList<Person>();
	
	
	/**Get the value for infectiveness.
	 */
	public Float getInfectiveness() {
		return this.getInfectiveness;
	}

	/**Constructor for Person class which accepts name, age and socialHygine as parameters
	 */
	public Person(String name, int age, float socialHygine) {
		this.name = name;
		this.age=age;
		this.socialHygine = socialHygine;
	}
	
	
	/**Method to calculate the infectiveness of a person given age and social hygine 
	 * and returns a float. 
	 * 
	 * @param age
	 * @param socialHygine
	 * 
	 * @returns this.getInfectiveness (assigned to the instance variable)
	 */
	public float calcInfectiveness(int age, float socialHygine) {
		
		float tempAge = (float)age;
		
		
		this.getInfectiveness=  (tempAge/100)-(socialHygine *(tempAge/100));
		
		return this.getInfectiveness;
	}
	
	
	/**Set the value of destinationBusiness
	 */
	
	public void setBusiness(Business bus) {
		this.destinationBusiness = bus;
	}
	
	/**Returns the value for destinationBusiness 
	 */
	public Business getBusiness() {
		return this.destinationBusiness;
	}
	
	/**toSting method to print out Person: name, age, contact 
	 * If the person is associated in a business include Business destinationBusiness
	 */
	@Override
	public String toString() {
		if(this.destinationBusiness == null) {
			return "Person: "+ name +" , "+ age +" , Contacts: " + contacts + "";
		}else {
			return "Person: "+ name +" , "+ age +" , Contacts: " + contacts + " , Business: " +destinationBusiness+ "" ;
		}
		
	}
	
	/**
	 * hashCode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(contacts);
	}
	
	/**
	 * Implementing equals method. Two objects are equal if their names are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(contacts, other.contacts);
	}
	

	
	

}

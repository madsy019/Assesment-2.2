package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
	

	public String name = " ";
	public int age = 0;
	float socialHygine = 0;
	private Float  getInfectiveness;
	
	Business destinationBusiness;
	
	ArrayList<Person> contacts = new ArrayList<Person>();
	
	
	public Float getInfectiveness() {
		return this.getInfectiveness;
	}

	public Person(String name, int age, float socialHygine) {
		this.name = name;
		this.age=age;
		this.socialHygine = socialHygine;
	}
	
	
	public float calcInfectiveness(int age, float socialHygine) {
		
		float tempAge = (float)age;
		
		
		
		this.getInfectiveness=  (tempAge/100)-(socialHygine *(tempAge/100));
		
		return this.getInfectiveness;
	}
	
	
	public void setBusiness(Business bus) {
		this.destinationBusiness = bus;
	}
	
	public Business getBusiness() {
		return this.destinationBusiness;
	}
	
	@Override
	public String toString() {
		if(this.destinationBusiness == null) {
			return "Person: "+ name +" , "+ age +" , Contacts: " + contacts + "";
		}else {
			return "Person: "+ name +" , "+ age +" , Contacts: " + contacts + " , Business: " +destinationBusiness+ "" ;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(contacts);
	}

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

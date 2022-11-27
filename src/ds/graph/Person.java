package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
	

	public String name = " ";
	public int age = 0;
	float socialHygine = 0;
	Float  getInfectiveness;
	
	ArrayList<Person> contacts = new ArrayList<Person>();
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getSocialHygine() {
		return socialHygine;
	}
	
	public Float getInfectiveness() {
		return getInfectiveness;
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
	@Override
	public String toString() {
		return "Person: "+ name +" , "+ age +" , Contacts: " + contacts + "";
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
	
	public static void main (String args[]) {
		
		Person p1 = new Person("Alice", 20, .2f);
		System.out.println(p1.name);
		
	  
		
	}
	

}

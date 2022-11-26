package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
	
	String name = " ";
	int age = 0;
	float socialHygine = 0;
	Float  getInfectiveness;
	ArrayList<Person> contacts = new ArrayList<Person>();
	
	public Person(String name, int age, float socialHygine) {
		name = this.name;
		age = this.age;
		socialHygine = this.socialHygine;
	}
	
	public float calcInfectiveness(int age, float socialHygine) {
		float infectiveness = 0;
		
		infectiveness =  (age/100)-(socialHygine *(age/100));
		return infectiveness;
	}
	@Override
	public String toString() {
		return "Person: "+ name +" , "+ age +" . Contacts: " + contacts + "";
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

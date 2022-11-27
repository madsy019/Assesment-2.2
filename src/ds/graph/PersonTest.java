package ds.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/**
	 * Test to check if the Person object is correctly created
	 */
	@Test
	void testCreatingPersonObject() {
		Person a1 = new Person("Alice", 20, .2f);
		
		assertEquals(a1.getClass(), Person.class);
	}
	
	/**
	 * Test to check if the calculating infectiveness is correct
	 */
	@Test
	void testcalcInfectiveness() {
		Person p1 = new Person("Alice", 20, .2f);
		
		float result = p1.calcInfectiveness(20, .2f);
		
		assertEquals(0.16f, result);
	}
	
	/**
	 * Twst to check if the equals method is correct in person class
	 */
	@Test 
	void testTwoObjectsAreSame() {
		Person a1 = new Person("Alice", 20, .2f);
		Person a2 = new Person("Alice", 30, .43f);
		
		assertTrue(a1 == a2);
	}

	
	
	
}

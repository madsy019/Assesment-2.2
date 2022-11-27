package ds.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testcalcInfectiveness() {
		Person p1 = new Person("Alice", 20, .2f);
		
		float result = p1.calcInfectiveness(20, .2f);
		
		assertEquals(0.16f, result);
	}
	
	//test for if age is negative as well

	
}

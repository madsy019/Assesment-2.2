package ds.graph;


import java.util.ArrayList;
/**
 * Contains the implementation for the BusinessGraph class
 */
public class BusinessGraph{	
	
	ArrayList<Business> vertices = new ArrayList<Business> ();
	ArrayList<Person> edges = new ArrayList<Person> ();
	
	public void addEdge(Business dest, Person route) {
		
		float value = route.calcInfectiveness(route.age, route.socialHygine);
		if(!vertices.contains(dest)) {
			edges.add(route);
		}else if(vertices.contains(dest)){
			//search if there is bigger one and then substitute it
		}
		
		
		
	}
	
	public void removeEdge(Business dest) {
		
	}
	
	
	public void addVertex(Business bus) {
		
	}
	
	public void  removeVertex(Business bus) {
		
	}
	
	public int totalPersonsInfected(Business start) {
		int num;
		return  num = 0;
	}
	
	public int minStepsToDestFromStart(Business start, Business dest) {
		int min;
		return min = 0;
	}
	
	public boolean  isStronglyConnected(Business start) {
		return false;
	}
}

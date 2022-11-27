package ds.graph;

import java.util.ArrayList;

public class SocialGraph {
	
	ArrayList<Person> vertices = new ArrayList<Person>();
	
	public SocialGraph() {
		
	}
	
	/**
	 * Add the given person to the graph. The person needs to be added to the list of vertices.
	 * 
	 * @param p
	 * @throws PersonAlreadyExists If the person is already present in the graph, 
	 *  		this method should throw a PersonAlreadyPresent exception. 
	 */
	public void addVertex(Person p) throws PersonAlreadyExistsException {
		
		for(int i = 0; i<vertices.size();i++) {
			if(vertices.get(i).equals(p)) {
				throw new PersonAlreadyExistsException("This person already present in the arrray");
			}else {
				vertices.add(p);
				System.out.println(p.age);
			}
		}
		
//		if(vertices.contains(p) == true) {
//			throw new PersonAlreadyExistsException("This person already present in the arrray");
//		}else if(vertices.contains(p) == false){
//			vertices.add(p);
//			
//			System.out.println(p.age);
//		}
		//also call the equal method to 
		
	}
	
	
	/**
	 * Remove the given Person from the graph. Any edges to this person should also be removed. 
	 * 
	 * @throws PersonDoesNotExist If the given person is not found inside the graph. 
	 * @param p
	 * @throws EdgeDoesNotExistException 
	 */
	public void removeVertex(Person p) throws PersonDoesNotExistException, EdgeDoesNotExistException {
		
		
		
		for(int i = 0; i<vertices.size();i++) {
			if(vertices.contains(p)) {
				vertices.remove(p);
				
			}else {
				throw new PersonDoesNotExistException("This person is no found in the array");
			}
			
		
		//loop all the other verticies(stuff in the person contact list) and check if they have a edge connected to this deleted vertex and then delete them too
			removeEdge(p, vertices.get(i) );
		}
		
		
	
	}
	
	/**
	 * Add an edge between the two people (vertices) in the graph. The graph is undirected, so 
	 * both People will need to list the other, in their list of contacts. 
	 * 
	 * If the edge already exists, this method should return true. 
	 *
	 * @param a
	 * @param b
	 * 
	 * @throws PersonDoesNotExist	If the person is not found within the graph. 
	 */
	public void addEdge(Person a, Person b) throws PersonDoesNotExistException {
		
		//loop though the contact list to find out if person a is in person b's list and vice versa
		
		
		for(int i = 0; i<vertices.size();i++) {
			//can improve this by adding or /and conditions
			if((a.contacts.get(i).equals(b)) || (b.contacts.get(i).equals(a)) ) {
				
				throw new PersonDoesNotExistException("This person already present in the arrray");
				
			}else {
				a.contacts.add(b);
				b.contacts.add(b);
			}
			
			
		}
	}
	
	/**
	 * Remove the edge between the given People from the graph. 
	 * If no edge existed between these people, this method should throw an EdgeDoesNotExist exception. 
	 * 
	 * @throws EdgeDoesNotExist
	 * @param a
	 * @param b
	 * @throws EdgeDoesNotExistException 
	 */
	public void removeEdge(Person a, Person b) throws EdgeDoesNotExistException {
		
		for(int i = 0; i<vertices.size();i++) {
			
			if(a.contacts.get(i).equals(b)) {
				
				a.contacts.remove(i);
				
			}else {
				throw new EdgeDoesNotExistException("This edge does not exist");
			}
			
			if(b.contacts.get(i).equals(a)) {
				
				b.contacts.remove(i);
				
			}else {
				throw new EdgeDoesNotExistException("This edge does not exist");
			}
		}
	}
	
	
	/**
	 * Implement a breadth-first search, from Person start to target. 
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the BFS operates. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchBFS(Person start, Person target) {
		
		int verticesCount = vertices.size();
		
		boolean visited[] = new boolean[verticesCount];
		
		ArrayList<Person> BFSList = new ArrayList<Person> ();
		
		visited[start] = true;
		BFSList.add(start);
		
		return null;
	}
	
	/**
	 * Implement a breadth-first search, from Person start to target.
	 * The weights associated with each edge should determine the order that the BFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedBFS(Person start, Person target) {
		return null;
	}
	
		
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the DFS operates. 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchDFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * The weights associated with each edge should determine the order that the DFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedDFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * This method should return an int value showing the total number of contacts-of-contacts of the start person. 
	 * This is the equivalent to doing a BFS around the start person, and 
	 * counting the vertices 2 steps away from the start node.  
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @return
	 */
	public int countContacts(Person start) {
		return 0;
	}
	
	
}

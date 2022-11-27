package ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Contains the implementation for the social graph class
 */
public class SocialGraph {
	
	/**
	 * Contains the list of vertices in the social graph
	 */
	ArrayList<Person> vertices = new ArrayList<Person>();
	
	/**
	 * Empty constructor for social graph
	 */
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
		
		//Loop through the list of vertices and check if there are any objects equal or else add them to the list 
		for(int i = 0; i<vertices.size();i++) {
			
			if(vertices.get(i).equals(p)) {
				//throw PersonAlreadyExistsException if person is already present
				throw new PersonAlreadyExistsException("This person already present in the arrray");
			}else {
				
				vertices.add(p);
			}
		}
		
		
	}
	
	
	/**
	 * Remove the given Person from the graph. Any edges to this person should also be removed. 
	 * 
	 * @throws PersonDoesNotExist If the given person is not found inside the graph. 
	 * @param p
	 * @throws EdgeDoesNotExistException 
	 */
	public void removeVertex(Person p) throws PersonDoesNotExistException, EdgeDoesNotExistException {
		
		
		//Loop until the vertex is being found and then remove it form the list
		for(int i = 0; i<vertices.size();i++) {
			if(vertices.contains(p)) {
				vertices.remove(p);
				
			}else {
				throw new PersonDoesNotExistException("This person is no found in the array");
			}
			
		
		//loop all the other vertices (stuff in the person contact list) and check if they have a edge connected to this deleted vertex and then delete them too
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
			
			if((a.contacts.get(i).equals(b)) || (b.contacts.get(i).equals(a)) ) {
				
				throw new PersonDoesNotExistException("This person already present in the arrray");
				
			}else {
				//Add the person objects in each others lists
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
		
		//loop through the list of vertices
		for(int i = 0; i<vertices.size();i++) {
			//check if the person a is equal to person b and if true remove it
			if(a.contacts.get(i).equals(b)) {
				
				a.contacts.remove(i);
				
			}else {
				throw new EdgeDoesNotExistException("This edge does not exist");
			}
			
			//check if the person b is equal to person a and if true remove it
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
		//list to store the visited vertices
		ArrayList<Person> visited = new ArrayList<Person> ();
		//Queue that the frontier is being stored in
		Queue<Person> BFSList = new LinkedList<Person>();
		
		
		//current start vertex is added to the queue and added to visited list 
		BFSList.add(start);
		
		visited.add(start);
		
		//loop until the queue is empty
		while(BFSList.size() != 0) {
			// take an entry from queue and process it 
			Person temp  = BFSList.poll();
			
			//loop to get all the adjacent vertices of current node  
			for(int i = 0; i< temp.contacts.size();i++) {
				if(!visited.contains(temp.contacts.get(i))) {
					//add the values to the queue and to visited list
					visited.add(temp.contacts.get(i));
					BFSList.add(temp.contacts.get(i));
					
				}
			}
		}
		
		//Storing the values in the queue as a output arrayList to return the traversed list
		ArrayList<Person> output = new ArrayList<Person> (BFSList);
		
		return output;
		
		
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
		//store the value of highest floating point to be compared with the infectiveness
		float highest = 0.0f;
		
		//list to store the visited vertices
		ArrayList<Person> visited = new ArrayList<Person> ();
		//Queue that the frontier is being stored in
		Queue<Person> BFSList = new LinkedList<Person>();
		
		//current start vertex is added to the queue and added to visited list 
		BFSList.add(start);
		
		visited.add(start);
		
		//loop until the queue is empty
		while(BFSList.size() != 0) {
			Person temp  = BFSList.poll();
			
			for(int i = 0; i< temp.contacts.size();i++) {
				if(!visited.contains(temp.contacts.get(i))) {
					//check for infectiveness and find the hishest value from the list of edges
					Person value = (temp.contacts.get(i));
					float count = value.calcInfectiveness(value.age, value.socialHygine);
					
					if(count > highest) {
						
						highest = count;
						
						//to be continued 
					}
				}
			}
				
		}
			
	
		
		
		//Storing the values in the queue as a output arrayList to return the traversed list
		ArrayList<Person> output = new ArrayList<Person> (BFSList);
		
		return output;
		
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
		//a stack to store the list of Persons 
		Stack<Person> DFSList = new Stack<Person>();
		//store the visited vertices
		ArrayList<Person> visited = new ArrayList<Person> ();
		
		
		
//		visited[start] = true;
		DFSList.push(start);
		
		
		//loop until the target node is found
		while(!DFSList.equals(target) ) {
			
			//temp Person class variable to hold the value pop() from stack
			Person temp =  DFSList.pop();
				
				//add temp value if not present in the list of vertices
				if(!visited.contains(temp)) {
					visited.add(temp);
					
					for(int j = 0; j< temp.contacts.size();j++) {
						//getting the values of each contact 
						DFSList.push(temp.contacts.get(j));
					}
				}
		}
	
		
		// return the list of traversed vertices
		return visited;
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
		// variable that holds the value for until how much the steps to make from start node.
		int value = 0;
		
		//variable to store the number of contacts-of-contacts
		int contactCount = 0;
		
		/**
		 * THe below code is similar to breadth first search and the only thing is we have varible value to increase the counter until which the
		 * while loop will run. and in the process when we visit every contact the contactCount variable will be incremented and the final count
		 * for the number of contacts will be returned
		 */
		 
		//list to store the visited vertices
		ArrayList<Person> visited = new ArrayList<Person> ();
		//Queue that the frontier is being stored in
		Queue<Person> BFSList = new LinkedList<Person>();
		
		
		BFSList.add(start);
		
		visited.add(start);
		//loop 2 times 
		while(value < 2) {
			while(BFSList.size() != 0) {
				Person temp  = BFSList.poll();
				
				//loop to get all the adjacent vertices of current node 
				for(int i = 0; i< temp.contacts.size();i++) {
					if(!visited.contains(temp.contacts.get(i))) {
						visited.add(temp.contacts.get(i));
						BFSList.add(temp.contacts.get(i));
						
						contactCount +=1;
						
					}
				value += 1;
				}
			
			}
		}
		return contactCount;
	}
	
	
}

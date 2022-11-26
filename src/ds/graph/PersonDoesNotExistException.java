package ds.graph;

public class PersonDoesNotExistException extends Exception{

	public PersonDoesNotExistException() {
		
	}
	
	public PersonDoesNotExistException(String message) {
		super(message);
	}
}

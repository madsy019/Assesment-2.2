package ds.graph;

public class EdgeDoesNotExistException extends Exception{

	public EdgeDoesNotExistException() {
		
	}
	
	public EdgeDoesNotExistException(String message)  {
		super(message);
	}
}

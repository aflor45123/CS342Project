import java.util.ArrayList;
import java.util.Iterator;
//import GenericList.Node;

public class GenericQueue<T> extends GenericList<T> {
	
	private Node<T> tail; 
	
	// Adds new element to the end of list
	public void enqueue(T data) {
		add(data);
	}
	
	// Deletes element from the end of list
	public T dequeue() {
		return delete();
	}
	
	// Returns last element in queue
	public Node<T> getTail() {
		Node<T> current = getHead();
		
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		tail = current;
		
		return tail;
	}
	
	
	
	
}

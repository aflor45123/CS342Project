import java.util.ArrayList;
import java.util.Iterator;
//import GenericList.Node;

public class GenericQueue<T> extends GenericList<T> {
	
	private Node<T> tail; 
	
	//Overloaded constructor for add. It has to be done per guidelines
	public void add(T data, int code) {
        Node<T> node = new Node<>(data, code, null); // ctor sets next = null

        
        Node<T> current = getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        tail = node;

        setLength(getLength() + 1);
    }

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

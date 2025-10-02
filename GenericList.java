import java.util.ArrayList;
import java.util.Iterator;


public abstract class GenericList<T> implements Iterable<T> {
	
	private Node<T> Head;
	private int length = 0;
	
	
	public static class Node<T> {
		private T data;
		private int code;
		private Node<T> next;
		
		// Gets data member from node
		public T getData() {
			return data;
		}
		
		// Gets next node
		public Node<T> getNext() {
			return next;
		}
		
		// sets current node's next to another node
		public void setNext(Node<T> temp) {
			this.next = temp;
		}
		
		// Parameterized constructor for a node
		public Node(T data, int code, Node<T> next) {
			this.data = data;
			this.code = code;
			this.next = null;
		}
		
	}
		
	
	// Prints out item list, one by one. 
	// If empty, print "Empty List".
	public void print() {
		
		if (this.length == 0) {
			System.out.println("Empty List");
		}
		
		else {
			Node<T> current = Head;
			
			while (current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}
	}

	// Appends new item to the end of the list
	public void add(T data) {
		Node<T> temp = new Node<T>(data, 0, null);
		
		if (Head == null) {
			Head = temp;
		}
		
		else {
			Node<T> current = Head;
			
			while (current.next != null) {
				current = current.next;
			}
			
			current.next = temp;
		}
		
		length++;
	}
	
	// Sets a node as Head node
	protected void setHeadNode(Node<T> node) {
		this.Head = node;   // <-- actually set the head reference
	    this.length = 1;
	   
	}

	
	// Deletes the last node in the list
	// If empty, returns null
	public T delete() {
		if (Head == null) {
			return null;
		}
		
		T temp = Head.data;
		Head = Head.next;
		length--;
		
		return temp;
	}
	
	// After ArrayList is imported from the java library, we can
	// work on dumping the contents of our LL into dumpList()
	// Disregard the warning for unchecked cast, Head is guaranteed to be of type <T>
	public ArrayList<T> dumpList() {
		
		ArrayList<T> dump = new ArrayList<>();
		Node<T> current = Head;
		
		for (int i = 0; i < length; i++) {
			dump.add(current.data);
			current = current.next;
		}
		
		return dump;
		
	}
	
	// Returns the item based on index
	public T get(int index) {
		Node<T> current = Head;
		int counter = 0;
		
		if (index >= length) {
			return null;
		}
		
		while (current != null) {
			if (index == counter) {
				return current.data;
			}
			else {
				current = current.next;
				counter++;
			}
		}
		
		return null;
	}
	
	// Returns the code based on index
	public int getCode(int index) {
		Node<T> current = getHead();
		int counter = 0;
		
		if (index >= getLength()) {
			return 0;
		}
		
		while (current != null) {
			if (index == counter) {
				return current.code;
			}
			else {
				current = current.next;
				counter++;
			}
		}
		return 0;
	}
	
	// Added another condition: If index is LESS than 0 (negative index)
	// return 0
	public T set(int index, T element) {
		Node<T> current = Head;
		int counter = 0;
		
		if (index >= length || index < 0) {
			return null;
		}
		
		while (current != null) {
			if (index == counter) {
				T tempData = current.data;
				current.data = element;
				return tempData;
			}
			
			current = current.next;
			counter++;
		}
		
		return null;
	}
	
	// Returns length of the item list
	public int getLength() {
		return length;
	}
	
	// Sets length
	public void setLength(int length) {
		this.length = length;
	}
	
	// Returns Head
	public Node<T> getHead() {
		return Head;
	}
	
	// Sets data to head
	public void setHead(T data) {
		Head.data = data;
	}
	
	// Assigns elements from another container into
	// an ArrayList. The order of the elements is reversed
	// in a descending order through an iterator
	public Iterator<T> descendingIterator() {
		ArrayList<T> iteration = new ArrayList<>();
		Node<T> current = getHead();
		
		while (current  != null) {
			iteration.add(current.data);
			current = current.next;
		}
		
		return new Iterator<T>() {
			int index = iteration.size() - 1;
			
			public boolean hasNext() {
				return index >= 0;
			}
			
			public T next() {
				return iteration.get(index--);
			}
		};
	}
}

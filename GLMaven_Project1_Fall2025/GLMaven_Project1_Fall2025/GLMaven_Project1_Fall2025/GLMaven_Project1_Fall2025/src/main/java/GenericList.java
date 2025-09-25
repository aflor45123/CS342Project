public abstract class GenericList<T> {
	
	public static class Node<T> {
		private T data;
		private int code;
		private Node<T> next;
		
		public Node(T data, int code, Node<T> next) {
			this.data = data;
			this.code = code;
			this.next = null;
		}
		
	}
	
	private Node<T> Head;
	private int length = 0;
	
	
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
			
			while (current != null) {
				current = current.next;
			}
			
			current = temp;
		}
		
		length++;
	}
	
	// Deletes the last node in the list
	// If empty, returns null
	public T delete() {
		if (Head == null) {
			return null;
		}
		
		if (Head.next == null) {
			T temp = Head.data;
			Head = null;
			return temp;
		}
		
		else {
			Node<T> current = Head;
			
			while (current.next.next != null) {
				current = current.next;
			}
			
			T temp = current.next.data;
			current.next = null;
			
			return temp;
		}
	}
	
	/*public ArrayList<T> dumpList() {
		
		if (Head == null) {
			System.out.print("[]");
		}
		else {
			Node<T> current = Head;
			
			System.out.print("[");
			
			while (current.next != null) {
				System.out.print(current.data + ", ");
				
			}
			
			System.out.print(current.data + "]");
		}

	}*/
	
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
			}
		}
		
		return null;
	}
	
	
	/* public T set(int index, T element) {
		Node<T> current = Head;
		Node<T> temp = null;
		int counter = 0;
		
		if (index >= length) {
			return null;
		}
		
		while (current != null) {
			if (index == counter) {
				temp = current;
				current.data = element;
				return temp.data;
			}
			
			else {
				current = current.next;
			}
		}
		
		return null;
	}*/
	
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
	
	/*
	public Iterator<T> descendingIterator() {
		
	}*/
}

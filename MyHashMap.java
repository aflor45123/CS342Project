
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<T> extends GenericList<T> implements Iterable<T>{
	
	
	// Node holding the key, value and code.
	private static class Node<U>{
		String key;
		U value;
		int code;
		
		Node(String key, U value, int code){
			this.key = key;
			this.value = value;
			this.code = code;
		}
	}
   
	private final ArrayList<GenericQueue<Node<T>>> map;
	private int size;
	
	// This Creates a has table with capacity 10, and inserts the first key and value
	public MyHashMap(String key, T value) {
		this.map = new ArrayList<>(10);
		
		// every map node is initilized as null here
		for (int i = 0; i<  10; i++) {
			map.add(null);
		}
		put(key, value);
		
	}
	
	// Compute the queue index using key
	// Say you have a key that points to a queue stored in the map
	// But given the hashCode it must point to a value between 0 and 9
	// due to the limitation of the Hash map
	private int indexQueue(String key) {
		return (key.hashCode()& 9);
	}
	
	// insert and update an already set mapping
	// had issues with the add method in GenericQueue
	// (fixed)add method add(T data, int code)in GenericQueue wasn't overriden properly
	
	public void put(String key, T value) {
		int code = key.hashCode();
		int index = indexQueue(key);
		
		GenericQueue<Node<T>> queue = map.get(index);
		
		if (queue == null) {
			queue = new GenericQueue<>();
			queue.add(new Node<>(key, value, code), code);
			map.set(index, queue);
			size++;
		}else {
			boolean update = false;
			for (int i =0; i<queue.getLength(); i++) {
				Node<T> temp = queue.get(i);
				if(temp.key.equals(key) && temp.code == code) {
					temp.value = value;
				}
			}
			if (!update) {
				queue.add(new Node<>(key, value, code), code);
				size++;
			}
		}
	}
	// Replaces a value at an already set hashcode.
	// If returns true key exists and returns the old value.
	public T replace(String key, T value) {
		int code = key.hashCode();
		int index = indexQueue(key);
		GenericQueue<Node<T>> queue = map.get(index);
		
		if(queue==null) {
			return null;
		}
		for(int i = 0; i < queue.getLength(); i++) {
			Node<T> temp = queue.get(i);
			if(temp.key.equals(key) && temp.code == code) {
				T old = temp.value;
				temp.value = value;
				return old;
			}
		}
		return null;
	}
	// Returns the size of the map.
	public int size() {
		return size;
	}
	// confirms whether the map is empty or not.
	public boolean isEmpty() {
		return size == 0;
	}
	// Had issues with advancing the queue. Used the decending Iterator in GenericList.
	// Iterate of over the hash map values.
	// Overrode Iterator in the super class.
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			int queueIndex = 0;
			Iterator<Node<T>> queueIter = null;
			
			private void advanceQueue() {
				while((queueIter == null || !queueIter.hasNext() && queueIndex < map.size())) {
					GenericQueue<Node<T>> b = map.get(queueIndex++);
					Iterator<Node<T>> queueIter;
					if(b == null) {
						queueIter = null;
					}else {
						queueIter = b.descendingIterator();
					}
				}
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				advanceQueue();
				return queueIter != null && queueIter.hasNext();
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				advanceQueue();
				return queueIter.next().value;
			}
		};
	}
	
}

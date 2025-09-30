import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;


public class GQTest {
	
	// Test 1: Adding elements to a queue (enqueue method)
	@Test
	void addElementTypeString() {
		ArrayList<String> solution = new ArrayList<>();
		solution.add("cake");
		solution.add("pizza");
		solution.add("lemonade");
		
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("cake");
		testQueue.enqueue("pizza");
		testQueue.enqueue("lemonade");
	
		
		int length = solution.size();
		for (int i = 0; i < length; ++i) {
			assertEquals(testQueue.get(i), solution.get(i), testQueue.get(i) + " does not match " + solution.get(i));
		}
	}
	
	
	// Test 2: Adding elements to a queue (enqueue method)
	@Test
	void addElementTypeInteger() {
		ArrayList<Integer> solution = new ArrayList<>();
		solution.add(33);
		solution.add(2839);
		solution.add(49283);
		solution.add(0);
		
		GenericQueue<Integer> testQueue = new GenericQueue<Integer>();
		testQueue.enqueue(33);
		testQueue.enqueue(2839);
		testQueue.enqueue(49283);
		testQueue.enqueue(0);
		
		
		int length = solution.size();
		for (int i = 0; i < length; ++i) {
			assertEquals(testQueue.get(i), solution.get(i), testQueue.get(i) + " does not match " + solution.get(i));
		}
	}
	
	
	// Test 3: Deleting elements from a queue (delete method)
	@Test
	void deleteElementTypeString() {
		ArrayList<String> solution = new ArrayList<>();
		solution.add("water");
		solution.add("rock");
		
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("water");
		testQueue.enqueue("rock");
		testQueue.enqueue("ice");
		
		
		assertEquals(testQueue.getLength(), 3, testQueue.getLength() + " does not match 3");
		testQueue.dequeue();
		
		assertEquals(testQueue.getLength(), 2, testQueue.getLength() + " does not match 2");
		assertEquals(testQueue.get(1), solution.get(1), testQueue.get(1) + " does not match " + solution.get(1));
	}
	
	
	// Test 4: Deleting elements from a queue (delete method)
		@Test
		void deleteElementTypeInteger() {
			GenericQueue<Integer> testQueue = new GenericQueue<Integer>();
			testQueue.enqueue(28);
			
			
			assertEquals(testQueue.getLength(), 1, testQueue.getLength() + " does not match 1");
			testQueue.dequeue();
			assertEquals(testQueue.getLength(), 0, testQueue.getLength() + " does not match 0");
		}
	
	
	// Test 5: Returning elements from queue based on index (get method)
	@Test
	void ReturnElementUsingIndex() {
		ArrayList<String> solution = new ArrayList<>();
		solution.add("January");
		solution.add("March");
		solution.add("May");
		solution.add("July");
		solution.add("August");
		
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("January");
		testQueue.enqueue("March");
		testQueue.enqueue("May");
		testQueue.enqueue("July");
		testQueue.enqueue("August");
		
		assertEquals(testQueue.get(3), solution.get(3), testQueue.get(3) + " does not match " + solution.get(3));
		assertEquals(testQueue.get(1), solution.get(1), testQueue.get(1) + " does not match " + solution.get(1));
		assertEquals(testQueue.get(4), solution.get(4), testQueue.get(4) + " does not match " + solution.get(4));
	}
	
	// Test 6: Return the tail node (getTail method)
	/*@Test
	void ReturnLastElement() {
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("Apple");
		testQueue.enqueue("Pear");
		testQueue.enqueue("Watermelon");
		
		Node<String> temp = testQueue.getTail();
		assertEquals(temp.getData(), "Watermelon", temp.getData + " does not match Watermelon");
	}*/
	
	// Test 7: getData
	
	
	// Test 8: getNext
	
	// Test 9: setNext
	
	// Test 10: Node
	
	// Test 11: dumpList
	
	// Test 12: get
	
	// Test 13: set
	
	// Test 14: getLength
	
	// Test 15: setLength
	
	// Test 16: getHead
	
	// Test 17: descending iterator
	
}

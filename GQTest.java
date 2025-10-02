import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;


public class GQTest {
	
	// Test 1: Adding elements to a queue (enqueue method) [Tests 1 argument: data]
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
			assertEquals(solution.get(i), testQueue.get(i), testQueue.get(i) + " does not match " + solution.get(i));
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
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("water");
		testQueue.enqueue("rock");
		testQueue.enqueue("ice");
		
		
		assertEquals(testQueue.getLength(), 3, testQueue.getLength() + " does not match 3");
		testQueue.dequeue();
		
		assertEquals(testQueue.getLength(), 2, testQueue.getLength() + " does not match 2");
		assertEquals(testQueue.get(1), "ice", testQueue.get(1) + " does not match ice");
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
	@Test
	void ReturnLastElement() {
		GenericQueue<String> testQueue = new GenericQueue<>();
		testQueue.enqueue("Apple");
		testQueue.enqueue("Pear");
		testQueue.enqueue("Watermelon");
		
		GenericQueue.Node<String> testTail = testQueue.getTail();
		
		assertEquals(testTail.getData(), "Watermelon", testTail.getData() + " does not match Watermelon");
		testQueue.dequeue();
		
		GenericQueue.Node<String> testTailTwo = testQueue.getTail();
		
		assertEquals(testTailTwo.getData(), "Watermelon", testTailTwo.getData() + " does not match Watermelon");
		testQueue.dequeue();
		testQueue.dequeue();		
		
		assertEquals(testQueue.getLength(), 0, "Length should be 0");
		assertNull(testQueue.getTail(), "Node not null");
	}
	
	
	// Test 7: Returning data from node (getData method)
	@Test
	void ReturnDataOfNode() {
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		testQueue.enqueue(1);
		testQueue.enqueue(45);
		testQueue.enqueue(98);
		
		assertEquals(testQueue.getHead().getData(), 1, "Must be 1");
		assertEquals(testQueue.getHead().getNext().getData(), 45, "Must be 45");
		assertEquals(testQueue.getTail().getData(), 98, "Must be 98");
	}
	
	
	// Test 8: Returning next node (getNext method)
	@Test
	void GetNextNode() {
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		testQueue.enqueue(1000);
		testQueue.enqueue(2000);
		testQueue.enqueue(3000);
		
		GenericQueue.Node<Integer> temp = testQueue.getHead();
		temp = temp.getNext();
		
		assertEquals(temp.getData(), 2000, "Must be 2000");
		
		temp = temp.getNext();
		assertEquals(temp.getData(), 3000, "Must be 3000");
	}
	
	
	// Test 9: Setting next node (setNext method)
	@Test
	void SetNextNode() {		
		GenericQueue.Node<String> tempNodeA = new GenericQueue.Node<>("Car", 4, null);
		GenericQueue.Node<String> tempNodeB = new GenericQueue.Node<>("Van", 0, null);
		tempNodeA.setNext(tempNodeB);
		
		
		assertEquals(tempNodeA.getNext().getData(), "Van");
	}
	
	
	// Test 10: Setting contents for code and next (Node method)
	@Test
	void DefaultNode() {		
		GenericQueue.Node<String> tempNode = new GenericQueue.Node<>("Spring", 5, null);
		assertEquals(tempNode.getData(), "Spring", tempNode.getData() + " should be Spring");
	}
	
	
	// Test 11: Putting all contents from genericQueue into ArrayList (dumpList method)
	@Test
	void theDumpList() {
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.add(39);
		solution.add(10);
		solution.add(48);
		solution.add(1234);
		
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		testQueue.enqueue(39);
		testQueue.enqueue(10);
		testQueue.enqueue(48);
		testQueue.enqueue(1234);
		
		ArrayList<Integer> newList = testQueue.dumpList();		
		for (int i = 0; i < 4; ++i) {
			assertEquals(newList.get(i), solution.get(i), newList.get(i) + " should be " + solution.get(i));
		}
	}
	
	
	// Test 12: Returns node data based on index (get method)
	@Test
	void getNodeData() {
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		testQueue.enqueue(2);
		testQueue.enqueue(4);
		testQueue.enqueue(6);
		
		assertEquals(testQueue.get(1), 4, "Must be: 4");
		testQueue.dequeue();
		testQueue.dequeue();
		
		assertEquals(testQueue.get(0), 6, "Must be: 6");
	}
	
	
	// Test 13: setting existing node to new value (set method)
	@Test
	void SetNodeNewData() {
		GenericQueue<String> testQueue = new GenericQueue<>();
		testQueue.enqueue("There");
		testQueue.enqueue("is");
		testQueue.enqueue("snow outside");
		testQueue.set(1, "isn't");
		testQueue.set(2, "anyone outside");
		
		assertEquals(testQueue.get(1), "isn't", "Must be: isn't");
		assertEquals(testQueue.get(2), "anyone outside", "Must be: anyone outside");
	}
	
	
	// Test 14: Return correct length of Queue (getLength method)
	@Test
	void ReturnLengthOfQueue() {
		GenericQueue<String> testQueue = new GenericQueue<>();
		testQueue.enqueue("Blue");
		testQueue.enqueue("Red");
		testQueue.enqueue("White");
		
		assertEquals(testQueue.getLength(), 3, "Length should be 3");
		testQueue.dequeue();
		testQueue.dequeue();
		
		assertEquals(testQueue.getLength(), 1, "Length should be 1");
	}
	
	
	// Test 15: Setting new length for queue (setLength method)
	@Test
	void SetLengthOfQueue() {
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		
		assertEquals(testQueue.getLength(), 0, "Length should be 0");
		testQueue.setLength(20);
		
		assertEquals(testQueue.getLength(), 20, "Length should be 20");
	}
	
	
	// Test 16: Returning Head to access its data (getHead method)
	@Test
	void GetHeadFromQueue() {
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		
		assertNull(testQueue.getHead(), "Must be null");
		testQueue.enqueue(123);
		testQueue.enqueue(456);
		testQueue.enqueue(789);
		testQueue.enqueue(1000);
		
		assertEquals(testQueue.getHead().getData(), 123, "Must be 123");
		testQueue.dequeue();
		testQueue.dequeue();
		
		assertEquals(testQueue.getHead().getData(), 789, "Must be 789");
		testQueue.dequeue();
		testQueue.dequeue();
		
		assertNull(testQueue.getHead(), "Must be null");
	}
	
	
	// Test 17: All contents get dumped into ArrayList in descending order (descending iterator method)
	@Test
	void theDescendingIterator() {
		ArrayList<Integer> solution = new ArrayList<Integer>();
		int counter = 0;
		solution.add(33);
		solution.add(22);
		solution.add(11);
	
		GenericQueue<Integer> testQueue = new GenericQueue<>();
		testQueue.enqueue(11);
		testQueue.enqueue(22);
		testQueue.enqueue(33);
	
		Iterator<Integer> iterator = testQueue.descendingIterator();
	
	
		while(iterator.hasNext()) {
			Integer temp = iterator.next();
			assertEquals(temp, solution.get(counter), temp + " does not match " + solution.get(counter));
			++counter;
		}
	}
	
	
	// Test 18: Adding elements to a queue (enqueue method) [Tests 2 arguments: data, code]
	@Test
	void AddElementStringTwoParams() {
		GenericQueue<String> testQueue = new GenericQueue<String>();
		testQueue.enqueue("Pie", 3);
		testQueue.enqueue("Icecream", 5);
		
		assertEquals(testQueue.get(0), "Pie", testQueue.get(0) + " does not match Pie");
		assertEquals(testQueue.getCode(0), 3, testQueue.getCode(0) + " does not match 3");
		assertEquals(testQueue.get(1), "Icecream", testQueue.get(1) + " does not match Icecream");
		assertEquals(testQueue.getCode(1), 5, testQueue.getCode(1) + " does not match 5");
	}
	
}

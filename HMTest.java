import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class HMTest {
	
	// Test 1: Initial state after constructor insert
	@Test
    void initialInsertAndSize() {
        MyHashMap<Integer> map = new MyHashMap<>("alpha", 10);
        assertEquals(1, map.size(), "Size should be 1 after constructor insert");
        assertFalse(map.isEmpty(), "Map should not be empty after constructor insert");
    }
	
	// Test 2: put with same key updates value size should not grow.
    @Test
    void putUpdatesExistingKey() {
        MyHashMap<Integer> map = new MyHashMap<>("alpha", 10);
        map.put("alpha", 20); // update same key
        assertEquals(1, map.size(), "Size should remain 1 after updating same key");

        // replace should return the most recently stored value (20)
        Integer old = map.replace("alpha", 30);
        assertEquals(20, old, "replace should return the previous value for 'alpha'");
        assertEquals(1, map.size(), "Size should still be 1 after replace");
    }
    // Test 3: replace on missing key returns null and does not change size
    @Test
    void replaceOnMissingKeyReturnsNull() {
        MyHashMap<String> map = new MyHashMap<>("seed", "x");
        int before = map.size();
        String old = map.replace("missing", "value");
        assertNull(old, "replace should return null for a missing key");
        assertEquals(before, map.size(), "Size should not change when replacing a missing key");
    }
 // Test 4: Multiple distinct keys increase size
    @Test
    void multiplePutsIncreaseSize() {
        MyHashMap<String> map = new MyHashMap<>("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        assertEquals(4, map.size(), "Size should reflect number of distinct keys inserted");

        // Verify values indirectly via replace return values
        assertEquals("v2", map.replace("k2", "newV2"), "replace should return previous value for k2");
        assertEquals("v3", map.replace("k3", "newV3"), "replace should return previous value for k3");
    }
    
 // Test 5: Collision handling for keys that land in the same queue
    @Test
    void collisionHandlingWithSameQueue() {
        MyHashMap<String> map = new MyHashMap<>("a", "first"); 
        map.put("i", "second");                               
        assertEquals(2, map.size(), "Size should be 2 after inserting two colliding keys");

        // Ensure each key can be independently replaced (proves they both exist in the queue)
        assertEquals("first", map.replace("a", "first2"), "replace should return previous value for 'a'");
        assertEquals("second", map.replace("i", "second2"), "replace should return previous value for 'i'");
        assertEquals(2, map.size(), "Size should remain 2 after replaces");
    }
    
    @Test
    void isEmptyIsFalseAfterConstruction() {
        MyHashMap<Double> map = new MyHashMap<>("seed", 1.0);
        assertFalse(map.isEmpty(), "Map should not be empty after construction");
    }
}

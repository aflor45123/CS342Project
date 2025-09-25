import static org.junit.jupiter.api.Assertions.*;

//import java.util.ArrayList;

//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;


public class GQTest {
	
	/*@Test
	void fails() {
		fail("this test will always fail");
	}*/
	
	
	@Test
	void message() {
		GenericQueue<String> okay = new GenericQueue<String>();
		
		okay.add("food");
		okay.add("pizza");
		okay.add("lemonade");
		okay.print();
	
		
		//assertEquals("Empty List", okay.print(), "Not working properly");
	}
	
	/*I need to complete tests for both generic list and generic queue*/

}

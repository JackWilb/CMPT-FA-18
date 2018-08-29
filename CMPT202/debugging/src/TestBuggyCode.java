import static org.junit.Assert.*;

import org.junit.Test;


public class TestBuggyCode {

	@Test
	public void testMaxMin() {
		int data[] = new int[] {-5,12,15,2,25};
		
		BuggyCode bc = new BuggyCode(data);
		
		assertEquals(-5, bc.min());
		
		assertEquals(25, bc.max());
	}

}

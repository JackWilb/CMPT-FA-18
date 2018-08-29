import static org.junit.Assert.*;

import org.junit.Test;


public class TestProcess {

	@Test
	public void test() {
		Process p1 = new Process("javac", 100, Process.State.READY);
		Process p2 = new Process("javac", 105, Process.State.RUNNING);
		Process p3 = new Process("javac", 110, Process.State.READY);
		Process p4 = new Process("javac", 100, Process.State.RUNNING);
		
		assertTrue(p1.equals(p3));
		
		assertFalse(p1.equals(p2));
		
		assertFalse(p1.equals(null));
		
		assertFalse(p1.equals("java"));
		
		assertFalse(p1.equals(p4));
	}

}

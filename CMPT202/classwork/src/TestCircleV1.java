import static org.junit.Assert.*;
import org.junit.Test;

public class TestCircleV1 {

	@Test
	public void test() {
		// create two identical circles
		
		CircleV1 circle1 = new CircleV1(2.0,java.awt.Color.RED);
		CircleV1 circle2 = new CircleV1(2.0,java.awt.Color.RED);
		
		assertTrue(circle1.equals(circle2));
	}

}

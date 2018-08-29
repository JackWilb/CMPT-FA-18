/*
 * @author Jack Wilburn
 * @date sep 2018
 * 
 * This is the unit test for the ThreeDimensionalPoint class.
 * 
 */

package lab2;

import static org.junit.Assert.*;
import org.junit.Test;
import static java.lang.Math.*;

public class ThreeDimensionalPointTest {
	
	ThreeDimensionalPoint pt = new ThreeDimensionalPoint(1, 2, 3);
	
	@Test
	public void test() {
		// test get functions (this also tests constructor)
		assertEquals(pt.getX() , 1, 0.0);
		assertEquals(pt.getY() , 2, 0.0);
		assertEquals(pt.getZ() , 3, 0.0);
		
		// test positive shift
		pt.shiftX(1);
		pt.shiftY(1);
		pt.shiftZ(1);
		
		assertEquals(pt.getX() , 2, 0.0);
		assertEquals(pt.getY() , 3, 0.0);
		assertEquals(pt.getZ() , 4, 0.0);
		
		// test negative shift
		pt.shiftX(-1);
		pt.shiftY(-1);
		pt.shiftZ(-1);
		
		assertEquals(pt.getX() , 1, 0.0);
		assertEquals(pt.getY() , 2, 0.0);
		assertEquals(pt.getZ() , 3, 0.0);
		
		// test x rotation
		pt.rotateX(PI);
		assertEquals(pt.getY() , -2, 0.001);
		assertEquals(pt.getZ() , -3, 0.001);
		
		// test y rotation
		pt.rotateY(PI);
		assertEquals(pt.getX() , -1, 0.001);
		assertEquals(pt.getZ() , 3, 0.001);
		
		// test z rotation
		pt.rotateZ(PI);
		assertEquals(pt.getX() , 1, 0.001);
		assertEquals(pt.getY() , 2, 0.001);
		
		
	}
}

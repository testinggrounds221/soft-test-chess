import static org.junit.Assert.*;

import org.junit.Test;


public class RookTest {
	Rook rook = new Rook(0,0,0);
	@Test 
	public void testVertical()  
	{ 
		boolean result = rook.isVertical(0,5);   
		assertEquals(result, true);
	}  
	@Test 
	public void testHorizontal()  
	{ 
		boolean result = rook.isHorizontal(5,0);   
		assertEquals(result, true);
	}    
	@Test 
	public void testisMoveLegal()  
	{ 
		boolean result = rook.isMoveLegal(5,0);   
		assertEquals(result, true);
	}   
}

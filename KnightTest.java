import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {
	Knight knight = new Knight(0, 0, 0);

	@Test
	public void testIsKnightMovement1() {
		boolean result = knight.isKnightMovement(2, 1);
		assertEquals(result, true);
	}

	@Test
	public void testIsKnightMovement2() {
		boolean result = knight.isKnightMovement(1, 2);
		assertEquals(result, true);
	}

	@Test
	public void testIsMoveLegal() {
		boolean result = knight.isMoveLegal(2, 1);
		assertEquals(result, true);
	}

}

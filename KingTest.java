import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {
	King king = new King(0, 0, 0);

	@Test
	public void testDiagonal1() {
		boolean result = king.isDiagonal(1, 1);
		assertEquals(result, true);
	}

	@Test
	public void testDiagonal2() {
		boolean result = king.isDiagonal(0, 0);
		assertEquals(result, false);
	}

	@Test
	public void testVertical() {
		boolean result = king.isVertical(0, 1);
		assertEquals(result, true);
	}

	@Test
	public void testHorizontal() {
		boolean result = king.isHorizontal(1, 0);
		assertEquals(result, true);
	}

	@Test
	public void testInBound() {
		boolean result = king.isInBounds(-3, -3);
		assertEquals(result, false);
	}

	@Test
	public void testIsLegal() {
		boolean result = king.isMoveLegal(1, 0);
		assertEquals(result, true);
		result = king.isMoveLegal(0, 1);
		assertEquals(result, true);
		result = king.isMoveLegal(1, 1);
		assertEquals(result, true);

	}
}

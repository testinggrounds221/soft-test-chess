import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	Queen queen = new Queen(0, 0, 0); // Assuming that its at (0,0)

	@Test
	public void testDiagonal1() {
		boolean result = queen.isDiagonal(5, 5);
		assertEquals(result, true);
	}

	@Test
	public void testDiagonal2() {
		boolean result = queen.isDiagonal(0, 3);
		assertEquals(result, false);
	}

	@Test
	public void testVertical() {
		boolean result = queen.isVertical(0, 4);
		assertEquals(result, true);
	}

	@Test
	public void testHorizontal() {
		boolean result = queen.isHorizontal(5, 0);
		assertEquals(result, true);
	}

	@Test
	public void testInBound() {
		boolean result = queen.isInBounds(90, 90);
		assertEquals(result, false);
	}

	@Test
	public void testIsLegal() {
		boolean result = queen.isMoveLegal(3, 0);
		assertEquals(result, true);
		result = queen.isMoveLegal(0, 5);
		assertEquals(result, true);
		result = queen.isMoveLegal(5, 5);
		assertEquals(result, true);

	}
}

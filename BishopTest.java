import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	Bishop bishop = new Bishop(0, 0, 0); // Assuming that its at (0,0)

	@Test
	public void testDiagonal() {
		boolean result = bishop.isDiagonal(2, 3);
		assertEquals(result, false);
	}

	@Test
	public void isMoveLegal() {
		boolean result = bishop.isMoveLegal(3, 3);
		assertEquals(result, true);
	}

}

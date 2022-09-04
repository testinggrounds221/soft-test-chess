import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {
	Pawn pawn = new Pawn(0, 0, 0);

	@Test
	public void testVertical() {
		boolean result = pawn.isVertical(0, 1);
		assertEquals(result, true);
	}

	@Test
	public void testVerticalDoubleStepPossible() {
		boolean result = pawn.isVerticalDoubleStepPossible(0, 2);
		assertEquals(result, true);
	}

}

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChessTest {
	King king = new King(0, 0, 0);
	Bishop bishop = new Bishop(0, 0, 0);
	Pawn pawn = new Pawn(0, 0, 0);
	Knight knight = new Knight(0, 0, 0);
	Queen queen = new Queen(0, 0, 0);

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("Starting Chess Testing");
	}

	// Run once, e.g close connection, cleanup
	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("Ending Chess Testing");
	}

	@ParameterizedTest
	@ValueSource(strings = { "10", "01", "11" })
	public void testKingLegalMoves(String pair) {

		boolean result = king.isMoveLegal(Character.getNumericValue(pair.charAt(0)),
				Character.getNumericValue(pair.charAt(1)));
		assertEquals(result, true);

	}

	@ParameterizedTest
	@ValueSource(strings = { "30", "05", "55" })
	public void testIsLegal(String pair) {
		boolean result = queen.isMoveLegal(Character.getNumericValue(pair.charAt(0)),
				Character.getNumericValue(pair.charAt(1)));
		assertEquals(result, true);
	}

	@Test
	public void testKingVertical() {
		boolean result = king.isVertical(0, 1);
		assertEquals(result, true);
	}

	@Test
	public void testKnightMovement() {
		boolean result = knight.isKnightMovement(1, 2);
		assertEquals(result, true);
	}

	@Test
	public void testBishopDiagonal() {
		boolean result = bishop.isDiagonal(2, 3);
		assertEquals(result, false);
	}

	@Test
	public void testPawnDoubleStep() {
		boolean result = pawn.isVerticalDoubleStepPossible(0, 2);
		assertEquals(result, true);
	}

	@Test
	public void testQueenVertical() {
		boolean result = queen.isVertical(0, 4);
		assertEquals(result, true);
	}

	@Test
	public void testQueenHorizontal() {
		boolean result = queen.isHorizontal(5, 0);
		assertEquals(result, true);
	}

	@Test
	public void testQueenDiagonal() {
		boolean result = queen.isDiagonal(5, 5);
		assertEquals(result, true);
	}

	@Test
	public void testPieceInBound() {
		boolean result = queen.isInBounds(90, 90);
		assertEquals(result, false);
	}
}

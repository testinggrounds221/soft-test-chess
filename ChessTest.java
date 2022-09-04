import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChessTest {
	static King king;
	static Bishop bishop;
	static Pawn pawn;
	static Knight knight;
	static Queen queen;

	@BeforeClass
	public static void initilizePieces() {
		System.out.println("Starting Chess Testing");
		ChessTest.king = new King(0, 0, 0);
		ChessTest.bishop = new Bishop(0, 0, 0);
		ChessTest.pawn = new Pawn(0, 0, 0);
		ChessTest.knight = new Knight(0, 0, 0);
		ChessTest.queen = new Queen(0, 0, 0);
	}

	@AfterClass
	public static void clearPieces() {
		System.out.println("Ending Chess Testing");
		ChessTest.king = null;
		ChessTest.bishop = null;
		ChessTest.pawn = null;
		ChessTest.knight = null;
		ChessTest.queen = null;
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
	@DisplayName("Test King's Vertical Movement")
	public void testKingVertical() {
		boolean result = king.isVertical(0, 1);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test  Knight's Movement")
	public void testKnightMovement() {
		boolean result = knight.isKnightMovement(1, 2);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test Bishop's Diagonal Movement")
	public void testBishopDiagonal() {
		boolean result = bishop.isDiagonal(2, 3);
		assertEquals(result, false);
	}

	@Test
	@DisplayName("Test Pawn's Doublestep Movement")
	public void testPawnDoubleStep() {
		boolean result = pawn.isVerticalDoubleStepPossible(0, 2);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test Queen's Vertical Movement")
	public void testQueenVertical() {
		boolean result = queen.isVertical(0, 4);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test Queen's Horizontal Movement")
	public void testQueenHorizontal() {
		boolean result = queen.isHorizontal(5, 0);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test Queen's Diagonal Movement")
	public void testQueenDiagonal() {
		boolean result = queen.isDiagonal(5, 5);
		assertEquals(result, true);
	}

	@Test
	@DisplayName("Test Every Piece's InBound Movement")
	public void testPieceInBound() {
		boolean result = queen.isInBounds(90, 90);
		assertEquals(result, false);
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	Board board = new Board();

	@Test
	public void testBoardConstruct() {
		board.board_construct(8);
		boolean result = board.isPieceThere(0, 0); // Checking random spots cause I did not want to test them using the
													// same for-loops I used to create them
		assertEquals(result, true);
		result = board.isPieceThere(0, 3); // Confirms that the peices are just in the first 2 rows
		assertEquals(result, false);
		result = board.isPieceThere(0, 6);
		assertEquals(result, true); // confirms that the black pieces are set in order too.

		int x_initialPosition = board.pieces[0].getCoordinates().get(0);
		int y_initialPosition = board.pieces[0].getCoordinates().get(1);
		Piece pawn = board.pieces[0];
		int intial_value_onBoard1 = 0;
		int intial_value_onBoard2 = 1;
		// result = board.isPieceThere(5,3);
		assertEquals(x_initialPosition, intial_value_onBoard1);
		// int intial_value_onBoard2 =(rook.getCoordinates().get(1));
		assertEquals(y_initialPosition, intial_value_onBoard2); // is 1, hence we see that the pawn's intital value is
																// (0,1).
		intial_value_onBoard1 = 0;
		intial_value_onBoard2 = 1;
		x_initialPosition = board.pieces[0].getCoordinates().get(0);
		y_initialPosition = board.pieces[0].getCoordinates().get(1); // we see that the 17th piece i.e the rook is at
																		// position (0,0)
		assertEquals(y_initialPosition, intial_value_onBoard2);

	}

	@Test
	public void testCheck() {
		board.board_construct(8);
		Piece King = board.pieces[30];
		Piece Pawn_white = board.pieces[6];
		Piece Pawn_black = board.pieces[9];
		Piece Bishop_black = board.pieces[27];
		Piece Pawn_white_2 = board.pieces[4];
		board.Move(3, 2, board.pieces[6]);
		board.Move(4, 6, board.pieces[9]);
		board.Move(1, 3, board.pieces[27]);
		board.Move(2, 2, board.pieces[4]);
		boolean result = board.isCheck(King);
		assertEquals(result, false); // Testing check with queen
	}

}

import java.util.*;

public class Board {
	protected int grid_size; // A variable to store the
	protected Piece pieces[]; // Array List to store all 32 pieces in the
	public int grid_matrix[][]; // The grid of the board

	public void board_construct(int size) {
		createPieces();
		this.grid_size = 8; // by default. On changing to custom, make this.grid_size = size
		this.grid_matrix = new int[8][8];
		for (int i = 0; i < 2; i++) // height parameter
		{
			for (int j = 0; j < 8; j++) // width parameter
			{
				this.grid_matrix[j][i] = 1;
				this.grid_matrix[j][8 - i - 1] = 1;
			}
		}
	}

	public void createPieces() {
		pieces = new Piece[32];
		// pieces.ensureCapacity(32);
		for (int i = 0; i < 8; i++) {
			Pawn pawn_white = new Pawn(0, i, 1);
			pieces[2 * i] = pawn_white;
			Pawn pawn_black = new Pawn(1, i, 6);
			pieces[2 * i + 1] = pawn_black;
		}

		Rook rook_white1 = new Rook(0, 0, 0);
		Rook rook_white2 = new Rook(0, 7, 0);
		pieces[16] = rook_white1;
		pieces[18] = rook_white2;
		Rook rook_black1 = new Rook(1, 0, 7);
		Rook rook_black2 = new Rook(1, 7, 7);
		pieces[17] = rook_black1;
		pieces[19] = rook_black2;
		Knight knight_white1 = new Knight(0, 1, 0);
		Knight knight_white2 = new Knight(0, 6, 0);
		pieces[20] = knight_white1;
		pieces[22] = knight_white2;
		Knight knight_black1 = new Knight(1, 1, 7);
		Knight knight_black2 = new Knight(1, 6, 7);
		pieces[21] = knight_black1;
		pieces[23] = knight_black2;
		Bishop bishop_white1 = new Bishop(0, 2, 0);
		Bishop bishop_white2 = new Bishop(0, 5, 0);
		pieces[24] = bishop_white1;
		pieces[26] = bishop_white2;
		Bishop bishop_black1 = new Bishop(1, 2, 7);
		Bishop bishop_black2 = new Bishop(1, 5, 7);
		pieces[25] = bishop_black1;
		pieces[27] = bishop_black2;
		Queen white_1 = new Queen(0, 3, 0);
		Queen black_1 = new Queen(1, 3, 7);
		pieces[28] = white_1;
		pieces[29] = black_1;
		King white_2 = new King(0, 4, 0);
		King black_2 = new King(1, 4, 7);
		pieces[30] = white_2;
		pieces[31] = black_2;
	}

	public boolean isPieceThere(int x, int y) // edit !
	{
		if (grid_matrix[x][y] == 1) {
			return true;
		}
		return false;
	}

	public void Move(int x, int y, Piece piece) {
		int curr_x = piece.getCoordinates().get(0);
		int curr_y = piece.getCoordinates().get(1);
		if (piece.isMoveLegal(x, y)) {
			if (piece.getType() == 1) // King
			{
				if (grid_matrix[x][y] == 0) // chances of bugs
				{
					grid_matrix[curr_x][curr_y] = 0;
					piece.setCoordinates(x, y);
					grid_matrix[x][y] = 1;
					checkAndUndo(piece);

				}
			}
		}
		if (piece.isMoveLegal(x, y)) {
			if (piece.getType() == 2) {
				if (!((grid_matrix[x][y] == 1) && (piece.isVerticallyObstructed(x, y, grid_matrix)
						|| piece.isHorizontallyObstructed(x, y, grid_matrix)
						|| piece.isDiagonallyObstructed(x, y, grid_matrix)))) // chances of bugs
				{
					grid_matrix[curr_x][curr_y] = 0;
					piece.setCoordinates(x, y);
					grid_matrix[x][y] = 1;
					checkAndUndo(piece);
				}
			}
		}

		if (piece.isMoveLegal(x, y)) {
			if (piece.getType() == 5) {
				if (!(piece.isDiagonallyObstructed(x, y, grid_matrix)) && grid_matrix[x][y] == 0) {
					grid_matrix[curr_x][curr_y] = 0;
					piece.setCoordinates(x, y);
					grid_matrix[x][y] = 1;
					checkAndUndo(piece);
				}
			}
		}
		if (piece.isMoveLegal(x, y) && grid_matrix[x][y] == 0) {
			if (piece.getType() == 4) {

				grid_matrix[curr_x][curr_y] = 0;
				piece.setCoordinates(x, y);
				grid_matrix[x][y] = 1;
				checkAndUndo(piece); // if check, then we undo the move

			}
		}
		if (piece.isMoveLegal(x, y) && grid_matrix[x][y] == 0) {
			if (piece.getType() == 3) {
				if ((piece.isVerticallyObstructed(x, y, grid_matrix)
						|| piece.isHorizontallyObstructed(x, y, grid_matrix))) {
					grid_matrix[curr_x][curr_y] = 0;
					piece.setCoordinates(x, y);
					grid_matrix[x][y] = 1;
					checkAndUndo(piece);
				}
			}
		}
		if (piece.isMoveLegal(x, y) && grid_matrix[x][y] == 0) {
			if (piece.getType() == 6) // Pawn
			{
				if (!(piece.isVerticallyObstructed(x, y, grid_matrix))) {
					grid_matrix[curr_x][curr_y] = 0;
					piece.setCoordinates(x, y);
					grid_matrix[x][y] = 1;
					checkAndUndo(piece);
					piece.setHasMovedOnce();
				}
			}
		}

	}

	public void checkAndUndo(Piece piece) {
		int curr_x = piece.getCoordinates().get(0);
		int curr_y = piece.getCoordinates().get(1);
		if (piece.color == 1) {
			if (isCheck(pieces[31])) // check if the black king is in check, if so undo the step.
			{
				piece.setCoordinates(curr_x, curr_y);

			}

		} else {
			if (isCheck(pieces[30])) // check if the white king is in check, if so undo the step.
			{
				piece.setCoordinates(curr_x, curr_y);
			}
		}
	}

	public void killPiece(int x, int y, Piece killerpiece, Piece victimpiece) {
		if (killerpiece.isMoveLegal(x, y) && grid_matrix[x][y] == 1) {
			ArrayList<Integer> curr_coordinates = killerpiece.getCoordinates();
			int curr_x = curr_coordinates.get(0);
			int curr_y = curr_coordinates.get(1);
			killerpiece.setCoordinates(x, y);
			grid_matrix[curr_x][curr_y] = 0; // set to unoccupied
			victimpiece.setCoordinates(-1, -1); // Throw the dead piece off the board
		}

	}

	public boolean isCheck(Piece king) {
		int coordinates_king_x = king.getCoordinates().get(0); // get coordinates of king
		int coordinates_king_y = king.getCoordinates().get(1);
		for (int i = 0; i < 32; i++) {
			if (pieces[i].getColor() != king.getColor()) {
				if (pieces[i].isMoveLegal(coordinates_king_x, coordinates_king_y)) {
					if (pieces[i].getType() == 2) {
						if (!((pieces[i].isVerticallyObstructed(coordinates_king_x, coordinates_king_y, grid_matrix)
								|| pieces[i].isHorizontallyObstructed(coordinates_king_x, coordinates_king_y,
										grid_matrix)
								|| pieces[i].isDiagonallyObstructed(coordinates_king_x, coordinates_king_y,
										grid_matrix)))) {
							return true; // check by queen
						}
						return false;
					}
					if (pieces[i].getType() == 3) {
						if (!pieces[i].isVerticallyObstructed(coordinates_king_x, coordinates_king_y, grid_matrix)) {
							return true;
						}
						return false;
					}
					if (pieces[i].getType() == 4) {
						return true;
					}
					if (pieces[i].getType() == 5) {
						if (!pieces[i].isDiagonallyObstructed(coordinates_king_x, coordinates_king_y, grid_matrix)) {
							return true;
						}
						return false;

					}
					if (pieces[i].getType() == 6) // Pawn
					{
						if (!(pieces[i].isVerticallyObstructed(coordinates_king_x, coordinates_king_y, grid_matrix))) {
							return true;
						}
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean checkMate() {
		ArrayList<Integer> curr = pieces[30].getCoordinates();
		int curr_x = curr.get(0);
		int curr_y = curr.get(1);
		if (isCheck(pieces[30])) {
			Move(curr_x + 1, curr_y, pieces[30]);
			Move(curr_x + 1, curr_y + 1, pieces[30]);
			Move(curr_x, curr_y + 1, pieces[30]);
			Move(curr_x - 1, curr_y + 1, pieces[30]);
			Move(curr_x - 1, curr_y, pieces[30]);
			Move(curr_x - 1, curr_y - 1, pieces[30]);
			Move(curr_x, curr_y - 1, pieces[30]);
			Move(curr_x + 1, curr_y - 1, pieces[30]);
			ArrayList<Integer> temp = pieces[30].getCoordinates();
			int temp_x = temp.get(0);
			int temp_y = temp.get(1);
			if ((curr_x == temp_x) && (curr_y == temp_y)) {
				pieces[30].setCoordinates(curr_x, curr_y);// Get the king to its original position
				return true;
			} else {
				pieces[30].setCoordinates(curr_x, curr_y);
				return false;
			}
		} else {
			pieces[30].setCoordinates(curr_x, curr_y);
			return false;
		}
	}
}

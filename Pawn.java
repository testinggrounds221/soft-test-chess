
public class Pawn extends Piece {

	public Pawn() {
		super();
		this.color = 0;
		this.type = 6;
	}

	public Pawn(int color) {
		super();
		this.color = color;
		this.type = 6;
	}

	public Pawn(int color, int x, int y) {
		super();
		this.color = color;
		this.type = 6;
		this.setCoordinates(x, y);
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public boolean isMoveLegal(int x, int y) {
		// TODO Auto-generated method stub
		if ((isVerticalDoubleStepPossible(x, y)) && isInBounds(x, y) && (this.getHasMovedOnce() == false)) // A pawn can
																											// double-step
																											// if it has
																											// never
																											// moved
		{
			return true;
		} else if ((isVertical(x, y)) && isInBounds(x, y)) // Single-step
		{
			return true;
		}
		return false;
		// A pawn can move diagonally too when killing another piece, but we will handle
		// that in the board logic
		// We will also set the HasMovedOnce to true in the board logic, since that
		// handles the physical movements of the pieces
	}

	@Override
	public boolean isVertical(int x, int y) {
		if (curr_x == x && Math.abs(curr_y - y) == 1) {
			// TODO Auto-generated method stub
			return true;
		}
		return false;
	}

	public boolean isVerticalDoubleStepPossible(int x, int y) {
		if (curr_x == x && Math.abs(curr_y - y) <= 2) {
			// TODO Auto-generated method stub
			return true;
		}
		return false;
	}

	@Override
	public boolean isHorizontal(int x, int y) {
		return false;
	}

	@Override
	public boolean isDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKnightMovement(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInBounds(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}

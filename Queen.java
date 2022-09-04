
public class Queen extends Piece {

	public Queen() {
		super();
		this.color = 0;
		this.type = 2;
	}

	public Queen(int color) {
		super();
		this.color = color;
		this.type = 2;
	}

	public Queen(int color, int x, int y) {
		super();
		this.color = color;
		this.type = 2;
		this.setCoordinates(x, y);
	}

	public int getType() {
		return 2;
	}

	@Override
	public boolean isMoveLegal(int x, int y) {
		// TODO Auto-generated method stub
		if ((isVertical(x, y) || isHorizontal(x, y) || isDiagonal(x, y)) && isInBounds(x, y)) // Check if 7 is the right
																								// number
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isDiagonal(int x, int y) {
		if (Math.abs(curr_x - x) == Math.abs(curr_y - y)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isKnightMovement(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHorizontal(int x, int y) {
		if (y == curr_y) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVertical(int x, int y) {
		if (x == curr_x) {
			return true;
		}
		return false;
	}
}

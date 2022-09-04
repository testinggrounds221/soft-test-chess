
public class King extends Piece {
	public boolean HasMovedOnce = false;

	public King() {
		super();
		this.color = 0;
		this.type = 1;
	}

	public King(int color) {
		super();
		this.color = color;
		this.type = 1;
	}

	public King(int color, int x, int y) {
		super();
		this.color = color;
		this.type = 1;
		this.setCoordinates(x, y);
	}

	public int getType() {
		return 1;
	}

	public boolean isMoveLegal(int x, int y) {
		// Check for obstruction in board code ->

		if (((isVertical(x, y) || isHorizontal(x, y) || isDiagonal(x, y))) && isInBounds(x, y)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isDiagonal(int x, int y) {
		if (Math.abs(curr_x - x) == Math.abs(curr_y - y)) {
			if (Math.abs(curr_x - x) == 1 && Math.abs(curr_y - y) == 1) // If step size is 1
				return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKnightMovement(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVertical(int x, int y) {
		if (curr_x == x && Math.abs(curr_y - y) == 1) {
			// TODO Auto-generated method stub
			return true;
		}
		return false;
	}

	@Override
	public boolean isHorizontal(int x, int y) {
		if (curr_y == y && Math.abs(curr_x - x) == 1) {
			return true;
		}
		return false;
		// TODO Auto-generated method stub
	}

}

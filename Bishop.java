
public class Bishop extends Piece {

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 5;
	}

	public Bishop() {
		super();
		this.color = 0;
		this.type = 5;
	}

	public Bishop(int color) {
		super();
		this.color = color;
		this.type = 5;
	}

	public Bishop(int color, int x, int y) {
		super();
		this.color = color;
		this.type = 5;
		this.setCoordinates(x, y);
	}

	@Override
	public boolean isMoveLegal(int x, int y) {
		if ((isDiagonal(x, y) && isInBounds(x, y))) // Check if 7 is the right number
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHorizontal(int x, int y) {
		return false;
	}

	@Override
	public boolean isDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		if (Math.abs(curr_x - x) == Math.abs(curr_y - y)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isKnightMovement(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVertical(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}

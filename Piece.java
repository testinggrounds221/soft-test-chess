import java.util.*;

public abstract class Piece {
	protected int color; // 0 for white, 1 for black
	protected int type;
	protected boolean hasMovedOnce;
	public int xcoordinate, ycoordinate;
	boolean HasMovedOnce = false;
	public int Grid_Matrix[][];

	public ArrayList<Integer> getCoordinates() {
		ArrayList<Integer> coordinatepair = new ArrayList<Integer>();
		coordinatepair.add(xcoordinate);
		coordinatepair.add(ycoordinate);
		return coordinatepair;
	} // assuming list.front()=x & list.back()=y

	public void setCoordinates(int x, int y) {
		xcoordinate = x;
		ycoordinate = y;

	}

	public int getColor() {
		return this.color;
	}

	public void setHasMovedOnce() {
		for (int i = 0; i < 8; i++) {
			if (this.getColor() == 0) {
				if (this.getCoordinates().get(1) == 1) {
					this.hasMovedOnce = false;
				} else {
					this.hasMovedOnce = true;
				}
			} else {
				if (this.getCoordinates().get(1) == 7) {
					this.hasMovedOnce = false;
				} else {
					this.hasMovedOnce = true;
				}
			}
		}
	}

	public boolean getHasMovedOnce() {

		return HasMovedOnce;
	}

	ArrayList<Integer> coordinate_pair = this.getCoordinates(); // As this is used by all the below methods
	int curr_x = coordinate_pair.get(0);
	int curr_y = coordinate_pair.get(1);

	abstract public boolean isVertical(int x, int y);

	abstract public boolean isHorizontal(int x, int y);

	public boolean isInBounds(int x, int y) {

		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		return true;
	}

	abstract public boolean isDiagonal(int x, int y);

	abstract public boolean isKnightMovement(int x, int y);

	abstract public int getType();

	abstract public boolean isMoveLegal(int x, int y);

	public boolean isVerticallyObstructed(int x, int y, int grid_matrix[][]) {
		if (x == curr_x) {
			int step_size = Math.abs(curr_y - y);
			int dir = (curr_y - y) / Math.abs(curr_y - y);
			for (int i = 0; i < step_size; i++) {
				if (dir == 1) {
					if (grid_matrix[x][curr_y + i] == 1) {
						return true;
					}
				} else {
					if (grid_matrix[x][curr_y - i] == 1) {
						return true;
					}
				}
			}

		}
		return false;
	}

	public boolean isHorizontallyObstructed(int x, int y, int grid_matrix[][]) {
		if (y == curr_y) {
			int step_size = Math.abs(curr_x - x);
			int dir = (curr_x - x) / Math.abs(curr_x - x);
			for (int i = 0; i < step_size; i++) {
				if (dir == 1) {
					if (grid_matrix[curr_x + i][y] == 1) {
						return true;
					}
				} else {
					if (grid_matrix[curr_x - i][y] == 1) {
						return true;
					}
				}
			}

		}
		return false;
	}

	public boolean isDiagonallyObstructed(int x, int y, int grid_matrix[][]) {
		if (Math.abs(y - curr_y) == Math.abs(x - curr_x)) {
			int step_size = Math.abs(curr_y - y);
			for (int i = 0; i < step_size; i++) {
				if ((grid_matrix[x + i][y + i] == 1) || (grid_matrix[x - i][y - i] == 1)) // Check this condition again
				{
					return true;
				}
			}

		}
		return false;
	}

	// abstract public void move_to_pos(int x, int y);
}

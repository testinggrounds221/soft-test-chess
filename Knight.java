
public class Knight extends Piece {

	public Knight()
	{
		super();
		this.color = 0;
		this.type = 4;
	}
	
	public Knight(int color)
	{
		super();
		this.color = color;
		
		
		this.type = 4;
	}
	
	public Knight(int color, int x, int y)
	{
		super();
		this.color = color;
		this.type = 4;
		this.setCoordinates(x, y);
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean isMoveLegal(int x, int y) { 
		if(isKnightMovement(x,y) && isInBounds(x,y)) 
		{ 
			return true;
		}  
			return false;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isVertical(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHorizontal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKnightMovement(int x, int y) {
		if(((Math.abs(x-curr_x)==2) && (Math.abs(y-curr_y)==1)||(Math.abs(y-curr_y)==2 && Math.abs(x-curr_x)==1))) 
		{ 
			return true;
		}
		return false;
	}
}


public class Rook extends Piece {
	public Rook ()
	 {
		 super();
		 this.color = 0;
		 this.type = 3;
	 }
		
	 public Rook(int color)
	 {
		 super();
		 this.color = color;
		 this.type = 1;
	 }
	 
	 public Rook(int color, int x, int y)
	 {
		 super();
		 this.color = color;
		 this.type = 3;
		 this.setCoordinates(x, y);
	 }
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override 
	public boolean isMoveLegal(int x, int y)
	{ 
		if(((isVertical(x,y)||isHorizontal(x,y)) && isInBounds(x,y))) //Check if 7 is the right number
		{ 
			return true;
		}  
			return false;
		// TODO Auto-generated method stub
	
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
	public boolean isVertical(int x, int y) { 
		if(x==curr_x ) 
		{
		// TODO Auto-generated method stub
		return true; 
		} 
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHorizontal(int x, int y) {
		if(y==curr_y ) 
		{
		// TODO Auto-generated method stub
		return true; 
		} 
		return false;
	}

	
	

	
	
}

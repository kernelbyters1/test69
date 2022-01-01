
public class Line {
	Coordinate start;
	Coordinate end;
	public Line(Coordinate coor1, Coordinate coor2) {
		start=coor1;
		end=coor2;
	}
	public boolean collision(Line otherLine) {
		double slope;
		if(otherLine.getStart().getX()==otherLine.getEnd().getX()) {
			System.out.println("asdfasdf");
			return false;
		}else {
			slope=(otherLine.getStart().getY()-otherLine.getEnd().getY())/(otherLine.getStart().getX()-otherLine.getEnd().getX());
		}
		int x=start.getX();
		int y=start.getY();
		if(y-otherLine.getStart().getY()==slope*(x-otherLine.getStart().getX())) {
			return true;
		}else if(y-otherLine.getStart().getY()<slope*(x-otherLine.getStart().getX())) {
			x=end.getX();
			y=end.getY();
			if(y-otherLine.getStart().getY()>=slope*(x-otherLine.getStart().getX())) {
				return true;
			}else {
				return false;
			}
		}else {
			x=end.getX();
			y=end.getY();
			if(y-otherLine.getStart().getY()<=slope*(x-otherLine.getStart().getX())) {
				return true;
			}else {
				return false;
			}
		}
	}
	public Coordinate randomPoint() {
		double slope=(start.getY()-end.getY())/(start.getX()-end.getX());
		int x=(int)(Math.random()*870)-20;
		int y=(int)(slope*(x-start.getX())+start.getY());
		return new Coordinate(x,y);
		
	}
	public Coordinate getStart() {
		return start;
	}
	public Coordinate getEnd() {
		return end;
	}
}

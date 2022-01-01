import java.lang.Math;
public class Coordinate {
	private int x;
	private int y;
	public Coordinate(int setX, int setY) {
		x=setX;
		y=setY;
	}
	public Coordinate(double setX, double setY) {
		x=(int)(setX);
		y=(int)(setY);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
	public double distance(Coordinate other) {
		return Math.sqrt(Math.pow(x-other.getX(),2)+Math.pow(y-other.getY(), 2));
	}
	public double angle(Coordinate other) {
		if(x>other.getX()) {
			return Math.atan((y-other.getY())/(x-other.getX()))+Math.PI;
		}
		if(x==other.getX()) {
			if(y>other.getY()) {
				return Math.PI/2;
			}else {
				return 3*Math.PI/2;
			}
		}
		return Math.atan((y-other.getY())/(x-other.getX()));
	}
}

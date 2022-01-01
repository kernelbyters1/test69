import java.lang.Math;
import java.awt.Color;
public class Body {
	Coordinate[] points=new Coordinate[4];
	Coordinate joint;
	private double position;
	private double length;
	private double width;
	private Color color;
	private boolean fixed;
	private boolean spazTheHeckOut=false;
	private int randR=(int)(Math.random()*255);
	private int randG=(int)(Math.random()*255);
	private int randB=(int)(Math.random()*255);
	public Body(int x, int y, double angle, double length1, double length2,int r, int g, int b,boolean notMoving) {
		x+=100;
		angle+=Math.PI/2;
		position=angle;
		length=length2;
		width=length1;
		color=new Color(r,g,b);
		fixed=notMoving;
		updatePosition(x,y,angle);
	}
	public void updatePosition(int x, int y, double angle) {
		joint=new Coordinate(x,y);
		x-=.5*width*Math.cos(angle);
		y-=.5*width*Math.sin(angle);
		
		points[0]=new Coordinate(x,y);
		points[1]=new Coordinate(x+width*Math.cos(angle),y+width*Math.sin(angle));
		points[2]=new Coordinate(x+width*Math.cos(angle)+length*Math.cos(angle+Math.PI/2),y+width*Math.sin(angle)+length*Math.sin(angle+Math.PI/2));
		points[3]=new Coordinate(x+length*Math.cos(angle+Math.PI/2),y+length*Math.sin(angle+Math.PI/2));
		position=angle;
		Line[] lines= {new Line(points[0],points[1]),new Line(points[1],points[2]),new Line(points[2],points[3]),new Line(points[3],points[0])};
		spazTheHeckOut=false;
		for(int i=0;i<4;i++) {
			if(lines[i].collision(new Line(new Coordinate(100,100),new Coordinate(1000,1000)))) {
				spazTheHeckOut=true;
			}
		}
	}
	public Coordinate getPoint(int index) {
		return points[index];
	}
	public Coordinate getJoint(int joint) {
		if(joint==0) {
			return getJoint();
		}else if(joint==1){
			return sideJoint1();
		}else if(joint==2) {
			return getOtherJoint();
		}else {
			return sideJoint2();
		}
	}
	public Coordinate getJoint() {
		return joint;
	}
	public Coordinate getOtherJoint() {
		double newAngle=position+Math.PI/2;
		double x=joint.getX()+length*Math.cos(newAngle);
		double y=joint.getY()+length*Math.sin(newAngle);
		return new Coordinate(x,y);
	}
	
	public Coordinate sideJoint1() {
		double newAngle=position+Math.PI/2;
		double x=points[0].getX()+length*.5*Math.cos(newAngle);
		double y=points[0].getY()+length*.5*Math.sin(newAngle);
		return new Coordinate(x,y);
	}
	public Coordinate sideJoint2() {
		double newAngle=position+Math.PI/2;
		double x=points[1].getX()+length*.5*Math.cos(newAngle);
		double y=points[1].getY()+length*.5*Math.sin(newAngle);
		return new Coordinate(x,y);
	}
	public double getAngle() {
		return position;
	}
	public Color getColor() {
		if(color.getRed()==69) {
			return new Color(randR,randG,randB);
		}else {
			return color;
		}
	}
	public boolean getSpazOut() {
		return spazTheHeckOut;
	}
	public boolean getStatic() {
		return fixed;
	}
	public Body clone() {
		return new Body(joint.getX(),joint.getY(),position-Math.PI/2,width,length,color.getRed(),color.getGreen(),color.getBlue(),fixed);
	}
}

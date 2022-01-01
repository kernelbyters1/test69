import javax.swing.*;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
public class Draw extends JPanel {
	BodyNetwork[] figure;
	public Draw(BodyNetwork[] bodies) {
		figure=bodies;
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, 1500, 1000, false);
		
		g.setColor(Color.RED);
		Font font = new Font("Comic Sans MS",Font.BOLD,200);
		g.setFont(font);
		g.drawString("ART", 275, 200);
		g.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		g.drawString("Press space to spawn a creature", 275, 250);
		g.drawString("Press backspace to delete a creature", 350, 300);
		for(int i=0;i<figure.length;i++) {
			boolean spazOut=false;
			for(int j=0;j<figure[i].length();j++) {
				if(figure[i].getBody(j).getSpazOut()) {
					spazOut=true;
				}
			}
			for(int j=0;j<figure[i].length();j++) {
				drawBody(figure[i].getBody(j),g,spazOut);
			}
		}
		g.setColor(Color.YELLOW);
		for(int i=0;i<10;i++) {
			g.drawLine(0, -5+i, 1000, 995+i);
		}
		g.setColor(new Color(255,75,25));
		Line lazzer=new Line(new Coordinate(100,100),new Coordinate(1000,1000));
		for(int i=0;i<500;i++) {
			g.setColor(new Color(255,75+(int)(Math.random()*100),25));
			Coordinate random=lazzer.randomPoint();
			int x=random.getX()+(int)(Math.random()*10)+((int)(Math.random()*2)*10)+10;
			int y=random.getY()+(int)(Math.random()*10)+((int)(Math.random()*2)*10)+10;
			g.fillRect(x, y, 5, 5);
		}
	}
	public void drawBody(Body body, Graphics g,boolean spazOut) {
		g.setColor(Color.BLACK);
		int[] x= {body.getPoint(0).getX(),body.getPoint(1).getX(),body.getPoint(2).getX(),body.getPoint(3).getX()};
		int[] y= {body.getPoint(0).getY(),body.getPoint(1).getY(),body.getPoint(2).getY(),body.getPoint(3).getY()};
		for(int i=0;i<3;i++) {
			g.drawLine(x[i], y[i], x[i+1], y[i+1]);
		}
		
		g.drawLine(x[3], y[3], x[0], y[0]);
		g.setColor(body.getColor());
		if(spazOut&&Math.random()>.5) {
			g.setColor(new Color(255,255,20));
			for(int i=0;i<20;i++) {
				g.fillRect(body.getJoint((int)(Math.random()*4)).getX()+(int)(Math.random()*10),body.getJoint((int)(Math.random()*4)).getY()+(int)(Math.random()*10), (int)(5*Math.random()),(int)(5*Math.random()));
			}
		}
		g.fillPolygon(x, y, 4);
		if(body.getSpazOut()&&Math.random()>.8) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans MS",Font.ITALIC,10));
			g.drawString("OwCh", body.getJoint((int)(Math.random()*4)).getX()+10, body.getJoint((int)(Math.random()*4)).getY()+10);
		}
	}
}

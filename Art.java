import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.event.*;
public class Art {
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new FrameShow();
		
		timer.schedule(task, 0,10);
	}

}
class FrameShow extends TimerTask{
	private boolean hold=false;
	private boolean onScreen;
	private int whoGetsHeld=0;
	private int prevX=696969;
	private int prevY=696969;

	private BodyNetwork[] bodies = new BodyNetwork[0];
	
	private JFrame frame;
	
	public FrameShow() {
		Draw draw = new Draw(bodies);
		draw.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
		
		frame=new JFrame("Art");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(draw);
		frame.addMouseListener(new Click());
		frame.addKeyListener(new Space());
		frame.pack();
		frame.setVisible(true);
	}
	public void run() {
		update();
	}
	private void update() {
		for(int i=0;i<bodies.length;i++) {
			bodies[i].updateBody();
		}
		if(hold&&onScreen&&bodies.length>whoGetsHeld) {
			int x=(int)(frame.getMousePosition().getX());
			int y=(int)(frame.getMousePosition().getY());
			bodies[whoGetsHeld].bodyClicked(x, y,prevX,prevY);
			prevX=x;
			prevY=y;
		}
		Draw draw = new Draw(bodies);
		draw.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
		frame.setContentPane(draw);
		frame.pack();
		frame.setVisible(true);
	}
	class Click implements MouseListener{
		public void mouseEntered(MouseEvent e) {
			onScreen=true;
		}
		public void mouseExited(MouseEvent e) {
			onScreen=false;
		}
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			hold=true;
			int x=(int)(frame.getMousePosition().getX());
			int y=(int)(frame.getMousePosition().getY());
			double closestDistance=99999;
			for(int i=0;i<bodies.length;i++) {
				for(int j=0;j<bodies[i].length();j++) {
					for(int h=0;h<8;h++) {
						double distance;
						Coordinate pointOnBody;
						if(h>3) {
							int index=h-4;
							pointOnBody=bodies[i].getBody(j).getPoint(index);
						}else {
							pointOnBody=bodies[i].getBody(j).getJoint(h);
						}
						distance=pointOnBody.distance(new Coordinate(x,y));
						if(distance<closestDistance) {
							closestDistance=distance;
							whoGetsHeld=i;
						}
					}
				}
			}
		}
		public void mouseReleased(MouseEvent e) {
			hold=false;
		}
	}
	class Space implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int keyPressed=e.getKeyChar();
			if(keyPressed==32) {
				int rand = (int)(Math.random()*3);
				BodyNetwork[] temp=new BodyNetwork[bodies.length+1];
				for(int i=0;i<bodies.length;i++) {
					temp[i]=bodies[i];
				}
				if(rand==0) {
					temp[temp.length-1]=new Human();
				}else if(rand==1) {
					temp[temp.length-1]=new Frog();
				}else {
					temp[temp.length-1]=new Spider();
				}
				bodies=temp;
			}else if(keyPressed==8&&bodies.length>0) {
				BodyNetwork[] temp=new BodyNetwork[bodies.length-1];
				for(int i=0;i<temp.length;i++) {
					temp[i]=bodies[i];
				}
				bodies=temp;
			}
		}
		public void keyReleased(KeyEvent e) {
			
		}
		public void keyTyped(KeyEvent e) {
			
		}
	}
}

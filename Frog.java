
public class Frog extends BodyNetwork{
	private static final Body torso =  new Body(500,500,Math.PI/2,30,30,0,255,0,false);
	private static final Body foreLeg1 = new Body(torso.getJoint().getX(),torso.getJoint().getY(),-Math.PI/4,13,30,0,200,0,false);
	private static final Body foreLeg2 = new Body(torso.getJoint().getX(),torso.getJoint().getY(),5*Math.PI/4,13,30,0,200,0,false);
	private static final Body hindLeg1 = new Body(foreLeg1.getOtherJoint().getX(),foreLeg1.getOtherJoint().getY(),3*Math.PI/2,8,25,0,150,0,false);
	private static final Body hindLeg2 = new Body(foreLeg2.getOtherJoint().getX(),foreLeg2.getOtherJoint().getY(),3*Math.PI/2,8,25,0,150,0,false);
	private static final Body arm1 = new Body(torso.sideJoint1().getX(),torso.sideJoint1().getY(),0,5,15,0,200,0,false);
	private static final Body arm2 = new Body(torso.sideJoint2().getX(),torso.sideJoint2().getY(),Math.PI,5,15,0,200,0,false);
	private static final Body head = new Body(torso.getOtherJoint().getX(),torso.getOtherJoint().getY(),Math.PI/2,20,10,0,255,0,true);
	private static final Body foot1 = new Body(hindLeg1.getOtherJoint().getX(),hindLeg1.getOtherJoint().getY(),3*Math.PI/2,15,10,0,150,0,false);
	private static final Body foot2 = new Body(hindLeg2.getOtherJoint().getX(),hindLeg2.getOtherJoint().getY(),3*Math.PI/2,15,10,0,150,0,false);
	private static final Body eye1 = new Body(head.getPoint(2).getX(),head.getPoint(2).getY(),5*Math.PI/4,5,5,255,0,0,true);
	private static final Body eye2 = new Body(head.getPoint(3).getX(),head.getPoint(3).getY(),7*Math.PI/4,5,5,255,0,0,true);
	
	private static final Body[] body= {torso,foreLeg1,foreLeg2,hindLeg1,hindLeg2,arm1,arm2,head,foot1,foot2,eye1,eye2};
	
	private static final int[] jointStuff1= {-1,0,0,1,2,0,0,0,3,4,7,7};
	private static final int[] jointStuff2= {-1,0,0,2,2,1,3,2,2,2,6,7};
	public Frog() {
		super(body.clone(),jointStuff1,jointStuff2);
	}

}

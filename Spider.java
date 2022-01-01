
public class Spider extends BodyNetwork{
	private static final Body thorax = new Body(500,500,Math.PI/2,50,50,255,255,255,false);
	private static final Body abdomen = new Body(thorax.getJoint().getX(),thorax.getJoint().getY(),Math.PI/2,50,50,0,0,0,false);
	private static final Body rightForeleg1=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),Math.PI/3,5,50,255,255,255,false);
	private static final Body rightForeleg2=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),0,5,50,255,255,255,false);
	private static final Body rightForeleg3=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),-Math.PI/3,5,50,255,255,255,false);
	private static final Body rightForeleg4=new Body(thorax.getJoint().getX(),thorax.getJoint().getY(),-Math.PI/3,5,50,255,255,255,false);
	private static final Body leftForeleg1=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),2*Math.PI/3,5,50,255,255,255,false);
	private static final Body leftForeleg2=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),Math.PI,5,50,255,255,255,false);
	private static final Body leftForeleg3=new Body(thorax.sideJoint1().getX(),thorax.sideJoint2().getY(),4*Math.PI/3,5,50,255,255,255,false);
	private static final Body leftForeleg4=new Body(thorax.getJoint().getX(),thorax.getJoint().getY(),4*Math.PI/3,5,50,255,255,255,false);
	private static final Body rightLeg1=new Body(rightForeleg1.getOtherJoint().getX(),rightForeleg1.getOtherJoint().getY(),Math.PI/3,5,50,0,0,0,false);
	private static final Body rightLeg2=new Body(rightForeleg2.getOtherJoint().getX(),rightForeleg2.getOtherJoint().getY(),0,5,50,0,0,0,false);
	private static final Body rightLeg3=new Body(rightForeleg3.getOtherJoint().getX(),rightForeleg3.getOtherJoint().getY(),-Math.PI/3,5,50,0,0,0,false);
	private static final Body rightLeg4=new Body(rightForeleg4.getOtherJoint().getX(),rightForeleg4.getOtherJoint().getY(),-Math.PI/3,5,50,0,0,0,false);
	private static final Body leftLeg1=new Body(leftForeleg1.getOtherJoint().getX(),leftForeleg1.getOtherJoint().getY(),2*Math.PI/3,5,50,0,0,0,false);
	private static final Body leftLeg2=new Body(leftForeleg2.getOtherJoint().getX(),leftForeleg2.getOtherJoint().getY(),Math.PI,5,50,0,0,0,false);
	private static final Body leftLeg3=new Body(leftForeleg3.getOtherJoint().getX(),leftForeleg3.getOtherJoint().getY(),4*Math.PI/3,5,50,0,0,0,false);
	private static final Body leftLeg4=new Body(leftForeleg4.getOtherJoint().getX(),leftForeleg4.getOtherJoint().getY(),4*Math.PI/3,5,50,0,0,0,false);
	private static final Body head=new Body(thorax.getOtherJoint().getX(),thorax.getOtherJoint().getY(),Math.PI/2,20,20,0,0,0,true);
	private static final Body eyeBridge=new Body(head.getOtherJoint().getX(),head.getOtherJoint().getY(),3*Math.PI/2,20,2,0,0,0,true);
	private static final Body eye1 = new Body(eyeBridge.getPoint(0).getX(),eyeBridge.getPoint(0).getY(),Math.PI,3,3,255,0,0,true);
	private static final Body eye2 = new Body(eyeBridge.getPoint(1).getX(),eyeBridge.getPoint(1).getY(),0,3,3,255,0,0,true);
	private static final Body eye3 = new Body(eyeBridge.getOtherJoint().getX(),eyeBridge.getOtherJoint().getY(),Math.PI/4,3,3,255,0,0,true);
	private static final Body eye4 = new Body(eyeBridge.getOtherJoint().getX(),eyeBridge.getOtherJoint().getY(),3*Math.PI/4,3,3,255,0,0,true);
	
	
	private static final Body[] body= {thorax,abdomen,rightForeleg1,rightForeleg2,rightForeleg3,rightForeleg4,leftForeleg1,leftForeleg2,leftForeleg3,leftForeleg4,rightLeg1,rightLeg2,rightLeg3,rightLeg4,leftLeg1,leftLeg2,leftLeg3,leftLeg4,head,eyeBridge,eye1,eye2,eye3,eye4};
	
	private static final int[] jointStuff1= {-1,0,0,0,0,0,0,0,0,0,2,3,4,5,6,7,8,9,0,18,19,19,19,19};
	private static final int[] jointStuff2= {-1,0,1,1,1,0,3,3,3,0,2,2,2,2,2,2,2,2,2,2,4,5,2,2};
	
	public Spider() {
		super(body.clone(),jointStuff1,jointStuff2);
	}

}

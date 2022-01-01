
public class Human extends BodyNetwork {
	private static final Body torso = new Body(500,500,Math.PI/2,50,75,255,255,255,false);
	private static final Body leftQuad=new Body(torso.getJoint().getX(),torso.getJoint().getY(),4*Math.PI/3,25,50,0,255,0,false);
	private static final Body rightQuad=new Body(torso.getJoint().getX(),torso.getJoint().getY(),5*Math.PI/3,25,50,0,255,0,false);
	private static final Body leftCalf=new Body(leftQuad.getOtherJoint().getX(),leftQuad.getOtherJoint().getY(),3*Math.PI/2,15,40,220,220,0,false);
	private static final Body rightCalf=new Body(rightQuad.getOtherJoint().getX(),rightQuad.getOtherJoint().getY(),3*Math.PI/2,15,40,220,220,0,false);
	private static final Body leftFoot=new Body(leftCalf.getOtherJoint().getX(),leftCalf.getOtherJoint().getY(),Math.PI,10,20,255,0,0,false);
	private static final Body rightFoot=new Body(rightCalf.getOtherJoint().getX(),rightCalf.getOtherJoint().getY(),0,10,20,255,0,0,false);
	private static final Body rightBicep=new Body(torso.sideJoint1().getX(),torso.sideJoint1().getY(),4*Math.PI/3,20,40,0,0,255,false);
	private static final Body leftBicep=new Body(torso.sideJoint2().getX(),torso.sideJoint2().getY(),5*Math.PI/3,20,40,0,0,255,false);
	private static final Body rightForearm=new Body(rightBicep.getOtherJoint().getX(),rightBicep.getOtherJoint().getY(),3*Math.PI/2,15,30,0,255,255,false);
	private static final Body leftForearm=new Body(leftBicep.getOtherJoint().getX(),leftBicep.getOtherJoint().getY(),3*Math.PI/2,15,30,0,255,255,false);
	private static final Body head = new Body(torso.getOtherJoint().getX(),torso.getOtherJoint().getY(),Math.PI/2,20,20,0,0,0,false);
	private static final Body eyeBridge = new Body(head.getOtherJoint().getX(),head.getOtherJoint().getY(),3*Math.PI/2,10,3,0,0,0,true);
	private static final Body eye1 = new Body(eyeBridge.getPoint(2).getX(),eyeBridge.getPoint(2).getY(),3*Math.PI/2,5,5,255,255,255,true);
	private static final Body eye2 = new Body(eyeBridge.getPoint(3).getX(),eyeBridge.getPoint(3).getY(),3*Math.PI/2,5,5,255,255,255,true);
	private static final Body hatRim = new Body(head.getOtherJoint().getX(),head.getOtherJoint().getY(),Math.PI/2,28,5,69,69,69,true);
	private static final Body hat = new Body(hatRim.getOtherJoint().getX(),hatRim.getOtherJoint().getY(),Math.PI/2,17,12,69,69,69,true);
	
	private static final Body[] body= {torso,leftQuad,rightQuad,leftCalf,rightCalf,leftFoot,rightFoot,rightBicep,leftBicep,rightForearm,leftForearm,head,eyeBridge,eye1,eye2,hatRim,hat};
	
	private static final int[] jointStuff1= {-1,0,0,1,2,3,4,0,0,7,8,0,11,12,12,11,15};
	private static final int[] jointStuff2= {-1,0,0,2,2,2,2,1,3,2,2,2,2,6,7,2,2};
	
	public Human() {
		super(body.clone(), jointStuff1, jointStuff2);
	}

}

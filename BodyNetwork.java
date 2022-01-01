
public class BodyNetwork {
	private static final double movementFactor=1.0/24.0;
	private Body[] bodyNetwork;
	private int[] bodyJoints;
	private int[] jointNumbers;
	private double[] angleVelocity;
	private double angleOfMotion;
	private double velocity;
	public BodyNetwork(Body[] bodies, int[] connections, int[] joints) {
		bodyNetwork=new Body[bodies.length];
		for(int i=0;i<bodies.length;i++) {
			bodyNetwork[i]=bodies[i].clone();
		}
		angleVelocity=new double[bodies.length];
		for(int i=0;i<bodies.length;i++) {
			angleVelocity[i]=.5*(Math.random()*Math.PI*movementFactor-Math.PI*movementFactor/2);
		}
		angleOfMotion=2*Math.PI*Math.random();
		velocity=4*Math.random()+1;
		bodyJoints=connections;
		jointNumbers=joints;
	}
	public void updateBody() {
		boolean spazOut=false;
		for(int i=0;i<bodyNetwork.length;i++) {
			if(bodyNetwork[i].getSpazOut()) {
				spazOut=true;
			}
		}
		for(int i=0;i<bodyNetwork.length;i++) {
			 angleVelocity[i]+=.1*(Math.random()*Math.PI*movementFactor-Math.PI*movementFactor/2);
			 if(angleVelocity[i]>.05) {
				 angleVelocity[i]=0;
			 }else if(angleVelocity[i]<-.05) {
				 angleVelocity[i]=0;
			 }
			 if(spazOut) {
				 angleVelocity[i]*=10;
			 }
			 if(bodyNetwork[i].getStatic()) {
				 angleVelocity[i]=angleVelocity[bodyJoints[i]];
			 }
		}
			angleOfMotion+=(Math.random()*Math.PI*movementFactor-Math.PI*movementFactor/2);
		double velocityChange=.5*Math.random()-.25;
		velocity+=velocityChange;
		if(Math.abs(velocity)>7) {
			velocity-=velocityChange;
		}
		for(int i=0;i<bodyNetwork.length;i++) {
			if(bodyJoints[i]<0) {
				double useVelocity=velocity;
				if(spazOut) {
					useVelocity*=.5;
				}
				int x=bodyNetwork[i].getJoint().getX()+(int)(useVelocity*Math.cos(angleOfMotion));
				int y=bodyNetwork[i].getJoint().getY()+(int)(useVelocity*Math.sin(angleOfMotion));
				if(x>975) {
					x=0;
				}
				if(x<0) {
					x=975;
				}
				if(y>900) {
					y=0;
				}
				if(y<0) {
					y=900;
				}
				bodyNetwork[i].updatePosition(x, y, bodyNetwork[i].getAngle()+angleVelocity[i]);
			}else {
				if(jointNumbers[i]<=3) {
					bodyNetwork[i].updatePosition(bodyNetwork[bodyJoints[i]].getJoint(jointNumbers[i]).getX(), bodyNetwork[bodyJoints[i]].getJoint(jointNumbers[i]).getY(), bodyNetwork[i].getAngle()+angleVelocity[i]);
				}else {
					bodyNetwork[i].updatePosition(bodyNetwork[bodyJoints[i]].getPoint(jointNumbers[i]-4).getX(),bodyNetwork[bodyJoints[i]].getPoint(jointNumbers[i]-4).getY(), bodyNetwork[i].getAngle()+angleVelocity[i]);
				}
			}
		}
	}
	public void bodyClicked(int x, int y,int prevX,int prevY) {
		if(prevX==696969&&prevY==696969) {
			velocity=0;
			angleOfMotion=0;
		}else {
			Coordinate previousCoordinate=new Coordinate(prevX, prevY);
			Coordinate currentCoordinate=new Coordinate(x,y);
			velocity=previousCoordinate.distance(currentCoordinate);
			if(Math.abs(velocity)>10) {
				velocity=10;
			}
			if(x!=prevX)
				angleOfMotion=previousCoordinate.angle(currentCoordinate);
		}
		for(int i=0;i<bodyNetwork.length;i++) {
			if(bodyJoints[i]<0) {
				
				if(x>975) {
					x=975;
				}
				if(x<0) {
					x=0;
				}
				if(y>900) {
					y=900;
				}
				if(y<0) {
					y=0;
				}
				
				bodyNetwork[i].updatePosition(x,y,bodyNetwork[i].getAngle());
			}else {
				int movingBody;
				int index=i;
				while(bodyNetwork[index].getStatic()) {
					index=bodyJoints[index];
				}
				movingBody=jointNumbers[index];
				if(bodyNetwork[i].getStatic()&&movingBody==-1) {
					 angleVelocity[i]=0;
				}
				if(jointNumbers[i]<=3) {
					bodyNetwork[i].updatePosition(bodyNetwork[bodyJoints[i]].getJoint(jointNumbers[i]).getX(), bodyNetwork[bodyJoints[i]].getJoint(jointNumbers[i]).getY(), bodyNetwork[i].getAngle()+angleVelocity[i]);
				}else {
					bodyNetwork[i].updatePosition(bodyNetwork[bodyJoints[i]].getPoint(jointNumbers[i]-4).getX(),bodyNetwork[bodyJoints[i]].getPoint(jointNumbers[i]-4).getY(), bodyNetwork[i].getAngle()+angleVelocity[i]);
				}
			}
		}
	}
	public Body getBody(int index) {
		return bodyNetwork[index];
	}
	public int length() {
		return bodyNetwork.length;
	}
}

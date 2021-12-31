package ICS4U;

import java.lang.Math; 
import java.util.*; 


public class ObjectOne{
	private static double mass;
	private static double positionX;
	private static double positionY;
	private static double velocityX;
	private static double velocityY;
	
	
	
	
	private static double forceX;
	private static double forceY;
	private static double time;
	private static double anglePosition;
	
	private static double angleVelocity;
	

	public ObjectOne(double mass, double positionX, double positionY, double velocityX, double velocityY) {
	this.mass = mass;
	this.positionX = positionX;
	this.positionY = positionY;
	this.velocityX = velocityX;
	this.velocityY = velocityY;
		
	}
	
	public ObjectOne(double forceX, double forceY, double time) {
		
		this.forceX = forceX;
		this.forceY = forceY;
		this.time = time;
		movementCalculations();
		
		
	
	}
	
	public ObjectOne() {
		
	}
	
	public void movementCalculations() {
		double newPositionX, newPositionY, newVelocityX, newVelocityY;
		
		newPositionX = positionX + velocityX * time + ((forceX/mass)/2) * (time*time);
		newPositionY = positionY + velocityY * time + ((forceY/mass)/2) * (time*time);
		//calculates the new X and Y for position
		newVelocityX = velocityX + (forceX/mass) * time;
		newVelocityY = velocityY + (forceY/mass) * time;
		//calculates the new X and Y for velocity
		positionX = newPositionX;
		positionY = newPositionY;
		
		velocityX = newVelocityX;
		velocityY = newVelocityY;
		//sets the new values to the original variables so this method can be reused 

	}
	
	public String display() {
		
		return mass + "," + getSize(positionX, positionY) + getAngle(positionX, positionY) + "," + getSize(velocityX, velocityY)
		+ getAngle(velocityX, velocityY);
		//returns in format as was given in the text file
	}
	
	public double getSize(double x, double y) {
		return Math.sqrt((x*x) + (y*y));
		//returns size when given cartesian vector coordinates
	}
	
	public String getAngle(double x, double y) {
		
		double d = Math.toDegrees(Math.atan(((x/y))));
		//returns sin inverse of x coordinate / y coordinate
		//if x is negative, the character is W or S
		//if not, it is E or N
		//c1 is corresponding to the Y coordinate
		char c1;
		char c2;
		if(x < 1) {
			c2 = 'W';
		}
		else {
			c2 = 'E';
		}
		if(y < 1) {
			c1 = 'S';
		}
		else {
			c1 = 'N';
		}
		
		return "[" + c1 + d + c2 + "]";
	}
	
	public double getPositionX() {
		//returns X coordinate of position
		return positionX;
	}
	public double getPositionY() {
		//returns Y coordinate of position
		return positionY;
	}
	
	
}

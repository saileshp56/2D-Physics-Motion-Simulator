package twodmotion; //At the time of writing, I do not have a website, this is just what I named the package

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoDimensionalMotion {

	public static void main(String[] args) throws IOException {
		Scanner fileInput = new Scanner(new File("fileInput2DMotion.txt"));
		Scanner input = new Scanner(System.in);
		double mass = 0;
		DecimalFormat toTwo = new DecimalFormat("0.00");



		double sizePosition = 0;
		String anglePosition = null;
		double sizeVelocity = 0;
		String angleVelocity = null;
		
		double positionX = 0, positionY = 0, velocityX = 0, velocityY = 0, angle = 0, angleV;
		
		System.out.println("Objects");
		
		String strArray[] = new String[12];
		
		
			strArray[0] = fileInput.nextLine();
			StringTokenizer t = new StringTokenizer(strArray[0], " ,[]");
			System.out.println(strArray[0]);
			mass = Double.parseDouble(t.nextToken());
			//mass is first double in the text file
			sizePosition = Double.parseDouble(t.nextToken());
			//takes in the magnitude of position
			anglePosition = t.nextToken();
			//the angle in the vector coordinate form of position, taken in as a String
			sizeVelocity = Double.parseDouble(t.nextToken());
			//the magnitude of the velocity
			angleVelocity = t.nextToken();
			//the angle in the vector coordinate form of velocity, taken in as a String
			angle = Double.parseDouble(anglePosition.substring(1,anglePosition.length() - 1));
			//the double inside of the String for position
			
			angleV = Double.parseDouble(angleVelocity.substring(1,anglePosition.length() - 1));
			//the double inside of the String for velocity
			int negativeOrPositivePositionX = getNegativeOrPositive(anglePosition.charAt(0));
			//sends over the first char in the String, which is either N or S. Depending on this, it will return -1 or 1 to multiply
			//x and y values by
			int negativeOrPositivePositionY = getNegativeOrPositive(anglePosition.charAt(anglePosition.length() -1));
			//sends over the first char in the String, which is either E or W. Depending on this, it will return -1 or 1 to multiply
			//x and y values by
			int negativeOrPositiveVelocityX = getNegativeOrPositive(angleVelocity.charAt(0));
			int negativeOrPositiveVelocityY = getNegativeOrPositive(angleVelocity.charAt(angleVelocity.length() -1));
			
			positionX = getVectorToCartesianX(sizePosition, angle, negativeOrPositivePositionX);	
			positionY = getVectorToCartesianY(sizePosition, angle, negativeOrPositivePositionY);	
			//finds the cartesian coordinates from gathered data
			velocityX = getVectorToCartesianX(sizeVelocity, angleV, negativeOrPositiveVelocityX);
			velocityY = getVectorToCartesianY(sizeVelocity, angleV, negativeOrPositiveVelocityY);
			
			
			
			
			

			
			
			ObjectOne o1 = new ObjectOne(mass, positionX, positionY, velocityX, velocityY);
			//creates object with mass, x and y coordinates for position, and x and y coordinates for velocity
			
			
			//-------------------------------------------------------------------------------
			//Does the same as before for the second object
			
			strArray[1] = fileInput.nextLine();
			
			StringTokenizer tsecond = new StringTokenizer(strArray[1], " ,[]");
			
			System.out.println(strArray[1]);
			mass = Double.parseDouble(tsecond.nextToken());
			sizePosition = Double.parseDouble(tsecond.nextToken());
			anglePosition = tsecond.nextToken();
			
			sizeVelocity = Double.parseDouble(tsecond.nextToken());
			angleVelocity = tsecond.nextToken();
		
			angle = Double.parseDouble(anglePosition.substring(1,anglePosition.length() - 1));
			
			
			angleV = Double.parseDouble(angleVelocity.substring(1,anglePosition.length() - 1));
			
			 negativeOrPositivePositionX = getNegativeOrPositive(anglePosition.charAt(anglePosition.length() -1));
			 negativeOrPositivePositionY = getNegativeOrPositive(anglePosition.charAt(0));
			 negativeOrPositiveVelocityX = getNegativeOrPositive(angleVelocity.charAt(angleVelocity.length() -1));
			 negativeOrPositiveVelocityY = getNegativeOrPositive(angleVelocity.charAt(0));
			
			positionX = getVectorToCartesianX(sizePosition, angle, negativeOrPositivePositionX);	
			positionY = getVectorToCartesianY(sizePosition, angle, negativeOrPositivePositionY);	
			
			velocityX = getVectorToCartesianX(sizeVelocity, angleV, negativeOrPositiveVelocityX);
			velocityY = getVectorToCartesianY(sizeVelocity, angleV, negativeOrPositiveVelocityY);
			
			
			ObjectTwo o2 = new ObjectTwo(mass, positionX, positionY, velocityX, velocityY);
			
			
			System.out.println("______________");
			System.out.println("Movements");
			
			//both objects are finished now
			
			
			
			
			for(int i = 2; i < 12; i++) {
				//runs a maximum of ten times
				try {
				//since there is no integer given for how many movements will occur, a try and catch
				//will allow a simple for loop by catching when there are no more lines for the fileInput to read
				strArray[i] = fileInput.nextLine();
				StringTokenizer t2 = new StringTokenizer(strArray[i], " ,[]");
				
				System.out.println(strArray[i]);
				
				double force1 =  Double.parseDouble(t2.nextToken());
				//takes force for the first object
				String angleForce1 = t2.nextToken();
				//takes angle as a string
				double angleForceMagnitude1 = Double.parseDouble(angleForce1.substring(1,angleForce1.length() - 1));
				negativeOrPositivePositionX = getNegativeOrPositive(angleForce1.charAt(angleForce1.length() -1));
				negativeOrPositivePositionY = getNegativeOrPositive(angleForce1.charAt(0));
				//finds if the x is positive or negative, and if the y is positive or negative
				
				
				double forceX1 = getVectorToCartesianX(force1, angleForceMagnitude1, negativeOrPositivePositionX);
				double forceY1 = getVectorToCartesianY(force1, angleForceMagnitude1, negativeOrPositivePositionY);	
				//finds the cartesian coordinates for the force
				
				//------------
				//does the same thing for the force and angle for the second object
				double force2 =  Double.parseDouble(t2.nextToken());
				
				String angleForce2 = t2.nextToken();
				double angleForceMagnitude2 = Double.parseDouble(angleForce2.substring(1,angleForce2.length() - 1));
				negativeOrPositivePositionX = getNegativeOrPositive(angleForce2.charAt(angleForce2.length() -1));
				negativeOrPositivePositionY = getNegativeOrPositive(angleForce2.charAt(0));
				//rename to negorposforceX2 and negorforceX1, and etc
				
				
				double forceX2 = getVectorToCartesianX(force2, angleForceMagnitude2, negativeOrPositivePositionX);
				double forceY2 = getVectorToCartesianY(force2, angleForceMagnitude2, negativeOrPositivePositionY);	
				
				
				double time = Double.parseDouble(t2.nextToken());
				//gets time variable, only has to be done once since it is the same for both movements
				
				
				
				
				
				
				
				ObjectOne movementOne = new ObjectOne(forceX1, forceY1, time);
				//passes the object the force cartesian coordinates, and time
				
				ObjectTwo movementTwo = new ObjectTwo(forceX2, forceY2, time);
				
				//passes the object the force cartesian coordinates, and time
				}
				
				catch (Exception e) {
					
				}
				
				
				
				
				
				
				
			
			} 
			
			System.out.println("______________");
			
			
			
			
			
			ObjectOne d = new ObjectOne();
			ObjectTwo d2 = new ObjectTwo();
		
			System.out.println(d.display());
			System.out.println(d2.display());
			
			double distance = Math.sqrt((d2.getPositionX()-d.getPositionX()) * (d2.getPositionX()-d.getPositionX()) + 
					(d2.getPositionY()-d.getPositionY()) * (d2.getPositionY()-d.getPositionY()));
			System.out.println("Distance is " + toTwo.format(distance) + " units");
		
		fileInput.close();
	}

	public static double getVectorToCartesianX(double sizePosition, double angle, int negativeOrPositivePositionX) {
		
		//returns cartesian x coordinate (magnitude * sin(angle)) which is negative or positive depending on where it is on
		//the grid (decided by the NESW)
		return (negativeOrPositivePositionX * (sizePosition * (Math.sin(angle*Math.PI/180))));
	}
	
	public static double getVectorToCartesianY(double sizePosition, double angle, int negativeOrPositivePositionY) {
		
		
		//returns cartesian y coordinate (magnitude * cos(angle)) which is negative or positive depending on where it is on
				//the grid (decided by the NESW)
		
		return (negativeOrPositivePositionY * (sizePosition * (Math.cos(angle*Math.PI/180))));
	}
	public
	static int getNegativeOrPositive(char c) {
		//returns negative if S or W, and positive if N or E
		//this is because that is how it is on the cartesian grid
		if(c == 'N') {
			return 1;
		}
		else if(c == 'S') {
			return -1;
		}
		else if(c == 'E') {
			return 1;
		}
		else if(c == 'W') {
			return -1;
		}
		else {
		return 1;
	
		}
	}	
	
}


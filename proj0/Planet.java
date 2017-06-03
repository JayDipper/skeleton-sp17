/** write the Planet.java file
* contains all the functions in "understanding the pyhsics part"
* including calculation of the force between two planets 
* and calculation of the net force of a bunch a planets
* and the distance between two planets
* and the updated velocity and position.
*/

public class Planet {
	
	double xxPos; // current x position ;
	double yyPos; // current y position ;
	double xxVel; // current velocity in the x direction;
	double yyVel; // current velocity in the y direction;
	double mass;  // its mass;
	String imgFileName; // name of an image that depict the planet;

	public Planet (double xP, double yP, double xV, 
				   double yV, double m, String img) 
		{
        xxPos = xP; yyPos = yP; xxVel = xV;
        yyVel = yV; mass = m; imgFileName = img ;
       	} 

	public Planet (Planet p) {
        xxPos = p.xxPos; yyPos = p.yyPos; xxVel = p.xxVel;
        yyVel = p.yyVel; mass = p.mass; imgFileName = p.imgFileName;
       	}

	public double calcForceExertedByX (Planet another) {	
		double g = 6.67e-11;
		double dx = another.xxPos - this.xxPos;
		double r = this.calcDistance(another);
		double fX = 0.0;
		if (r == 0) { 
			return fX = 0;
		} else {
		double f = (g*mass*another.mass)/(r*r);
		fX = f * dx/r;
		return fX;
		}
	}

	public double calcForceExertedByY (Planet another) {
		double g = 6.67e-11;
		double dy = another.yyPos - this.yyPos;
		double r = this.calcDistance(another);
		double fY = 0.0;
		if (r == 0) { 
			return fY = 0; 
		} else {
		double f = (g*mass*another.mass)/(r*r);
		fY = f * dy/r;
		return fY;
		} 
	}

	public double calcDistance (Planet another) {
		double dx = another.xxPos - this.xxPos;
		double dy = another.yyPos - this.yyPos;
		double r =Math.sqrt(dx*dx + dy*dy);
		return r;
		}

	public double calcNetForceExertedByX (Planet[] array) { //a bunch of planets work together
		double xNetForce = 0.0;
		for (Planet element : array) {
			double fX = this.calcForceExertedByX(element);
			xNetForce += fX;
		}
		return xNetForce;
		}

	public double calcNetForceExertedByY (Planet[] array) { // a bunch of planets work together
		double yNetForce = 0.0;
		for (Planet element : array) {
			double fY = this.calcForceExertedByY(element);
			yNetForce += fY;
		}
		return yNetForce;
		}

	public void update (double dt, double fX, double fY) {
		double aX = fX/this.mass; //updated x acceleration
		double aY = fY/this.mass; //updated y acceleration
		xxVel += dt*aX; //updated x speed
		yyVel += dt*aY; //updated y speed
		xxPos += dt*xxVel; //updated x position
		yyPos += dt*yyVel; //updated y position
		}

 	// this method was referenced from github user "HanChenXT"
	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
		}

	public static void drawBackground() {//draw starfield as background
	// DRAW code was referenced from github user "HanChenXT"
		String starfield = "./images/starfield.jpg"; 
		double R = NBody.readRadius("./data/planets.txt");
		StdDraw.setScale(-R, R);
		StdDraw.clear();
		StdDraw.picture(0, 0, starfield);
		} 

}

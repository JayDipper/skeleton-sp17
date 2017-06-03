
/** write the NBody.java file 
 */

public class NBody{

    public static double readRadius(String fileloc) { //return the radius of the solar system
    	if (fileloc.length() == 0) {
    		System.out.println("Please input a file location as a commend line argument. ");
    	}
 		
 		In in = new In(fileloc);

 		int number = in.readInt(); //read the first line -- the number of planets 
 		double radius = in.readDouble(); //read second line -- the radius of the solar system

		return radius;
 	}

 	public static Planet[] readPlanets(String fileloc) { //return value is object array Planet[]
 		if (fileloc.length() == 0) {
 				System.out.println("Please input a file location as a commend line argument. ");
		}

		In in = new In(fileloc);
		/** line from here till line 33 and line 40 is referenced from github user "HanchenXT" */

		int numOfPlanets = in.readInt(); //read the first line--total number of planets
		in.readDouble(); //read the second line and skip it
		Planet[] p = new Planet[numOfPlanets]; //create an object array and put all planets in
		for (int i=0; i < numOfPlanets; i++) { //read the info of each planet, 5 times total
			double xpos = in.readDouble();
 			double ypos = in.readDouble();
 			double xvel = in.readDouble();
 			double yvel = in.readDouble();
 			double mass = in.readDouble();
 			String image = in.readString();
 			p[i] = new Planet(xpos, ypos, xvel, yvel, mass, image);
		}
		return p;
    }

    public static void main (String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]); // store the commend line argument
    	String filename = args[2];// as T , dt, and filename

    	Planet[] p = NBody.readPlanets(filename); //read the planets from the planets.txt
    	double r = NBody.readRadius(filename); //read the radius of the solar system from the planets.txt

    	Planet.drawBackground(); //draw background first, set it unchanged, static mathod, needs "Planet.""

   		double time = 0.0;
   		while (time < T) { // generate the track of planets till time T
   			Planet.drawBackground();
   			double[] xForces = new double[p.length];
   			double[] yForces = new double[p.length];
      		for (int i = 0; i < p.length ; i++) { //calculate the netforce of each planet
   				xForces[i] = p[i].calcNetForceExertedByX(p);
   				yForces[i] = p[i].calcNetForceExertedByY(p);
   			    p[i].update(dt, xForces[i], yForces[i]); //update the velocity and the force of planets
				}

			for (int i = 0; i < p.length ; i++) { 
				p[i].draw();  // update the position of each planet
			}
			StdDraw.show(10);//show the new position after 10 ms
			time += dt;
			//String soundtrack = "./audio/2001.mid";
   			//StdAudio.play(soundtrack);
   		}

   		StdOut.printf("%d\n", p.length); // print out the final state
   		StdOut.printf("%.2e\n", r);
   		for (int i = 0; i < p.length; i++) {
   			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %20s\n",
   				p[i].xxPos, p[i].yyPos, p[i].xxVel, 
   				p[i].yyVel, p[i].mass, p[i].imgFileName); 
   		} 

    }

}
 


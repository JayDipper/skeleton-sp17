public class TestPlanet {
	
	public static void main (String[] args) {
		Planet sun = new Planet(1.0, 1.0, 2.0, 2.0, 5.0, "sun.pic");
		Planet earth = new Planet(4.0, 5.0, 4.0, 4.0, 10.0, "earth.gif");

		double f1x = sun.calcForceExertedByX(earth);
		double f2x = earth.calcForceExertedByX(sun);
		double f1y = sun.calcForceExertedByY(earth);
		double f2y = earth.calcForceExertedByY(sun);

		System.out.println("Checking pair force...");
		System.out.println("sun's force by earth in x direction : " + f1x + " N ");
		System.out.println("sun's force by earth in y direction : " + f1y + " N ");
		System.out.println("earth's force by sun in x direction : " + f2x + " N ");
		System.out.println("earth's force by sun in y direction : " + f2y + " N ");
		if (f1x == -f2x) {
			System.out.println("x direction checking... Yes!");
		}
		if (f1y == -f2y) {
			System.out.println("y direction chceking... Yes!");
		}
	}
}
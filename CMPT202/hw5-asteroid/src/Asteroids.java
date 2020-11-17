
/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
 */
import java.awt.*;
import java.util.*;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	private static final int COLLISION_PERIOD = 100;

	static int counter = 0;
	
	// how we track asteroid collisions
	private boolean collision = false;
	private static int collisionTime = COLLISION_PERIOD;
	
	public Star[] stars;
	
	public int lives = 5;

	private java.util.List<Asteroid> randomAsteroids = new ArrayList<Asteroid>();
	
	private Ship ship;

	public Asteroids() {
		super("Asteroids!",SCREEN_WIDTH,SCREEN_HEIGHT);
		this.setFocusable(true);
		this.requestFocus();

		// create a number of random asteroid objects
		randomAsteroids = createRandomAsteroids(10,60,30);
		
		// create the ship
		ship = createShip();
		
		// register the ship as a KeyListener
		this.addKeyListener(ship);

		stars = createStars(200,3);
	}
	
	// private helper method to create the Ship
	private Ship createShip() {
        // Look of ship
        Point[] shipShape = {
                new Point(0, 0),
                new Point(Ship.SHIP_WIDTH/3.5, Ship.SHIP_HEIGHT/2),
                new Point(0, Ship.SHIP_HEIGHT),
                new Point(Ship.SHIP_WIDTH, Ship.SHIP_HEIGHT/2)
        };
        // Set ship at the middle of the screen
        Point startingPosition = new Point((width -Ship.SHIP_WIDTH)/2, (height - Ship.SHIP_HEIGHT)/2);
        int startingRotation = 0; // Start facing to the right
        return new Ship(shipShape, startingPosition, startingRotation);
    }

	//  Create an array of random asteroids
	private java.util.List<Asteroid> createRandomAsteroids(int numberOfAsteroids, int maxAsteroidWidth,
			int minAsteroidWidth) {
		java.util.List<Asteroid> asteroids = new ArrayList<>(numberOfAsteroids);

		for(int i = 0; i < numberOfAsteroids; ++i) {
			// Create random asteroids by sampling points on a circle
			// Find the radius first.
			int radius = (int) (Math.random() * maxAsteroidWidth);
			if(radius < minAsteroidWidth) {
				radius += minAsteroidWidth;
			}
			// Find the circles angle
			double angle = (Math.random() * Math.PI * 1.0/2.0);
			if(angle < Math.PI * 1.0/5.0) {
				angle += Math.PI * 1.0/5.0;
			}
			// Sample and store points around that circle
			ArrayList<Point> asteroidSides = new ArrayList<Point>();
			double originalAngle = angle;
			while(angle < 2*Math.PI) {
				double x = Math.cos(angle) * radius;
				double y = Math.sin(angle) * radius;
				asteroidSides.add(new Point(x, y));
				angle += originalAngle;
			}
			// Set everything up to create the asteroid
			Point[] inSides = asteroidSides.toArray(new Point[asteroidSides.size()]);
			Point inPosition = new Point(Math.random() * SCREEN_WIDTH, Math.random() * SCREEN_HEIGHT);
			double inRotation = Math.random() * 360;
			asteroids.add(new Asteroid(inSides, inPosition, inRotation));
		}
		return asteroids;
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter,10,10);

		// display the random asteroids
		for (Asteroid asteroid : randomAsteroids) {
			asteroid.paint(brush,Color.white);
			asteroid.move();
			
			// get collision status
			if(!collision) {
                collision = asteroid.collision(ship);
            }
		}
		
		
       if(collision) {
           ship.paint(brush, Color.red);
           collisionTime -= 1;
           if(collisionTime <= 0) {
               collision = false;
               collisionTime = COLLISION_PERIOD;
               lives--;
           }
       } else {
           ship.paint(brush, Color.magenta);
       }
       
		ship.move();

		// Display stars
		for(Star star : stars) {
			if(Math.random() > 0.5) {
				star.paint(brush, Color.white);
			} else {
				star.paint(brush, Color.gray);
			}
			
		}	

		ArrayList<Integer> bulletremovals = new ArrayList<>();
		ArrayList<Asteroid> asteroidremovals = new ArrayList<>();
		
		for (int i = 0; i < ship.getBullets().size(); i++) {
			ship.getBullets().get(i).paint(brush, Color.cyan);
			ship.getBullets().get(i).move();
			if (ship.getBullets().get(i).outOfBounds()) {
				bulletremovals.add(new Integer(i));
			} else {
				for (Asteroid asteroid : randomAsteroids) {
					if (asteroid.contains(ship.getBullets().get(i).getCenter())){
						asteroidremovals.add(asteroid);
						bulletremovals.add(new Integer(i));
					}
				}
			}
			
		}
		
		for (Integer i : bulletremovals) {
			ship.removeBullet(i);
		}
		
		for (Asteroid a : asteroidremovals) {
			randomAsteroids.remove(a);
		}
		
		if (randomAsteroids.size() == 0) {
			brush.setColor(Color.black);
			brush.fillRect(0,0,width,height);
			brush.setColor(Color.white);
			brush.drawString("You Win!",380,290);
			on = false;
		}
		
		if (lives == 0) {
			brush.setColor(Color.black);
			brush.fillRect(0,0,width,height);
			brush.setColor(Color.white);
			brush.drawString("You Lose!",380,290);
			on = false;
		}
		
	}

	// Create a certain number of stars with a given max radius
	public Star[] createStars(int numberOfStars, int maxRadius) {
		Star[] stars = new Star[numberOfStars];
		for(int i = 0; i < numberOfStars; ++i) {
			Point center = new Point(Math.random() * SCREEN_WIDTH, Math.random() * SCREEN_HEIGHT);
			int radius = (int) (Math.random() * maxRadius);
			if(radius < 1) {
				radius = 1;
			}
			stars[i] = new Star(center, radius);
		}
		return stars;
	}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
	}
}
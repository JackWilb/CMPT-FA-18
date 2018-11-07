
/*
CLASS: AsteroidsGame
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
 */
import java.awt.*;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	static int counter = 0;
	
	private Asteroid ast1;
	private Asteroid ast2;
	private Asteroid ast3;

	public Asteroids() {
		super("Asteroids!", SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setFocusable(true);
		this.requestFocus();
		ast1 = new Asteroid(new Point[] {new Point(0, 0), new Point(100, 100), new Point(200,100)}, new Point(400,400),  0.0);
		ast2 = new Asteroid(new Point[] {new Point(0, 0), new Point(100, 0), new Point(100,100), new Point(0,100)}, new Point(100,100),  60.0);
		ast3 = new Asteroid(new Point[] {new Point(0, 0), new Point(100, 0), new Point(50,100)}, new Point(500,200),  0.0);
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
		
		
		ast1.paint(brush, Color.white);
		ast2.paint(brush, Color.white);
		ast3.paint(brush, Color.white);
		
		ast1.move();
		ast2.move();
		
	}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
	}
}
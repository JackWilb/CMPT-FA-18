import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Circle {
	private static final int RADIUS = 5;
	private double rotation;
	
	public Bullet(Point center, double rotation) {
		super(center, RADIUS);
		this.rotation = rotation;
	}
	
	public void paint(Graphics brush, Color color) {
		brush.setColor(color);
		brush.fillOval((int) center.x, (int) center.y, RADIUS, RADIUS);
	}

	public void move() {
		center.x += 5 * Math.cos(Math.toRadians(rotation));
		center.y += 5 * Math.sin(Math.toRadians(rotation));
	}
	
	public boolean outOfBounds() {
		return center.x > 800 || center.y > 600 || center.x < 0 || center.y < 0;
	}

	public Point getCenter() {
		 return center;
	}
}

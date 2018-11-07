import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Polygon{
	private Point[] shape;   // An array of points.
	public Point position;   // The offset mentioned above.
	public double rotation; // Zero degrees is due east.
	
	public Asteroid(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.shape = shape;
		this.position = position;
		this.rotation = rotation;
	}

	@Override
	public void paint(Graphics brush, Color color) {
		int[] xPoints = new int[shape.length];
		int[] yPoints = new int[shape.length];
		
		Point[] points = this.getPoints();
		Point p = null;
		for (int i = 0; i < shape.length; i++) {
			p = points[i];
			xPoints[i] = (int) (p.x);
			yPoints[i] = (int) (p.y);
		}

		
		brush.setColor(color);
		brush.drawPolygon(xPoints, yPoints, shape.length);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.position.x = this.position.x + 1;
		this.position.y = this.position.y + 2;
	}


}

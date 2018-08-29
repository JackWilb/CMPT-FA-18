/*
 * @author Jack Wilburn
 * @date sep 2018
 * 
 * This class allows users to define 3d 
 * points and manipulate them.
 * 
 */

package lab2;

import static java.lang.Math.*;

public class ThreeDimensionalPoint {

	private double[] origin = new double[] {0.0, 0.0, 0.0};
	private double x;
	private double y;
	private double z;
	
	public ThreeDimensionalPoint(double x, double y, double z) {
		this.origin = origin;
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double shiftX(double amount) {
		this.x = this.x + amount;
		return this.x;
	}
	
	public double shiftY(double amount) {
		this.y = this.y + amount;
		return this.y;
	}
	
	public double shiftZ(double amount) {
		this.z = this.z + amount;
		return this.z;
	}
	
	public void rotateX(double theta) {
		double newx = this.x;
		double newy = (this.y * cos(theta) - this.z * sin(theta));
		double newz = (this.y * sin(theta) + this.z * cos(theta));
		
		this.x = newx;
		this.y = newy;
		this.z = newz;
	}
	
	public void rotateY(double theta) {
		double newx = (this.x * cos(theta) + this.z * sin(theta));
		double newy = this.y;
		double newz = (-this.x * sin(theta) + this.z * cos(theta));
		
		this.x = newx;
		this.y = newy;
		this.z = newz;
	}
	
	public void rotateZ(double theta) {
		double newx = (this.x * cos(theta) - this.y * sin(theta));
		double newy = (this.x * sin(theta) + this.y * cos(theta));
		double newz = this.z;
		
		this.x = newx;
		this.y = newy;
		this.z = newz;
	}
	
}

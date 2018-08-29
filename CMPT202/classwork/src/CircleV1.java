/**
 * A simple (and not all that useful) class that represents a circle object.
 *
 * @author Greg Gagne - August 2016
 */

public class CircleV1 
{
    private double radius;
    private java.awt.Color color;

    public CircleV1(double radius, java.awt.Color color) {
        this.radius = radius;
        this.color = color;
    }

    /**
     * Expands the radius by a certain factor
     */
    public void expand(double factor) {
        radius *= factor;
    }

    public String toString() {
        return "A Circle with radius " + radius + " of color " + color;
    }
    
    public boolean equals(Object other) {
        
        if (other == null)
            return false;
        
        if ( !(other instanceof CircleV1))
            return false;
        
        CircleV1 o = (CircleV1)other;
        
        return ((this.radius == o.radius) && (this.color.equals(o.color)));
  
    }
}

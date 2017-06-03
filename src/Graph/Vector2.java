package Graph;

import java.io.Serializable;

/**
 * A 2D vector class for various mathematical operations.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.1
 */
public class Vector2 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5186572965866150772L;
	public double x;
	public double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculates the euclidean distance between two 2D points.
	 * The formula is:
	 * d(p, q) = √ ( (q1 - p1)^2 + (q2 - p2)^2 )
	 * @param v2 The second point
	 * @return The distance between the points
	 */
	public double distance(Vector2 v2) {
		double result = -1.0;
		double xy = x - v2.y;
		double yx = y - v2.x;
		double x2 = xy * xy;
		double y2 = yx * yx;
		
		return Math.sqrt(x2 + y2);
	}
	
	@Override
	public String toString() {
		return "Vector{" +
				"x = " + x +
				", y = " + y +
				'}';
	}
}

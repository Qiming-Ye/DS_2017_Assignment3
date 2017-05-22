package Graph;

import java.io.Serializable;

/**
 * A 2D vector class for various mathematical operations.
 * Created for Data Structures, SP2 2017
 * @author James Baumeister
 * @version 1.1
 */
public class Vector2 implements Serializable {
	
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
		// TODO
		return -1.0;
	}
	
	@Override
	public String toString() {
		return "Vector{" +
				"x = " + x +
				", y = " + y +
				'}';
	}
}

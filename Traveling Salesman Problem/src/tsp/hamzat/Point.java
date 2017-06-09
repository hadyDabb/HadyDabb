package tsp.hamzat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Point implements Comparable<Point> 
{
	public final Comparator<Point> SLOPE_ORDER;// compare points by slope to this point
	
	private final int x, y;

	public int X() { return x; }
	public int Y() { return y; }

	public Point(int x, int y)
	{ // construct the point (x, y)
		this.x = x;
		this.y = y;
		SLOPE_ORDER = new SLOPE_ORDER();
	}

	public void draw()
	{ // draw this point
//		StdDraw.point(x, y);
	}

	public void drawTo(Point that)
	{ // draw the line segment from this point to that point
//		StdDraw.line(this.x, this.y, that.X(), that.Y());
	}

	@Override public String toString()
	{ // string representation
		return "(" + x + ", " + y + ")";
	}

	@Override public int compareTo(Point that)
	{ // is this point lexicographically smaller than that point?
		if(that == null)
		{ throw new java.lang.NullPointerException(); }

		int result;

		result = this.y - that.Y();
		if(result == 0)
		{
			result = this.x - that.X();
		}

		return result;
	}

	public double slopeTo(Point that)
	{ // the slope between this point and that point
		double result;

		if(this.x == that.X() && this.y == that.Y())
		{
			result = Double.NEGATIVE_INFINITY;
		}
		else if(this.y == that.Y())
		{
			result = 0;
		}
		else if(this.x == that.X())
		{
			result = Double.POSITIVE_INFINITY;;
		}
		else
		{
			result = (((double)that.y - (double)this.Y())/((double)that.x - (double)this.X()));
		}

		return result;
	}

	
	
	public class SLOPE_ORDER implements Comparator<Point>
	{
		public int compare(Point point1, Point point2)
		{
			double m1 = slopeTo(point1), m2 = slopeTo(point2);
			int result;

			if(m1 == m2)
			{
				result =  0;
			}
			else if(m1 < m2)
			{
				result =  -1;
			}
			else
			{
				result = 1;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		
		List<Point> points = new ArrayList<>();
		
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,2);
		Point p3 = new Point(1,3);
		Point p4 = new Point(2,2);
		Point p5 = new Point(3,1);
		Point p6 = new Point(3,4);
		Point p7 = new Point(3,2);
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		
		
		System.out.println(points);
	
		
		
		
	}
}

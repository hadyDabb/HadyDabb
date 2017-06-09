package tsp.hamzat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tour implements TourInterFace{
	
	private Node tour;
	private int size;//I could use the Node class to calculate distance... but that would take time
	
	
	Tour()					//empty tour
	{
		size = 0;
	}
	
	Tour(City a, City b, City c, City d)// create a 4 point tour a->b->c->d->a
	{
		size = 4;
		tour = new Node( a );
		tour.insert( b, 1 );
		tour.insert( c, 2 );
		tour.insert( d, 3 );
	}
	
	
	
	@Override
	public void show() {
		for( int i = 0; i < size; i++ )
		{
			System.err.println(tour.get( i ).getCity());
//			StdOut.print( tour.get( i ).getPoint() );
		}
		
	}

	@Override
	public void draw(City c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distance() {
double distance = 0;
		
		for( int i = 1; i < size; i++ )
		{
			distance += tour.get( i ).getCity().distanceTo( tour.get( i - 1 ).getCity() );
		}
		
		distance += tour.get( 0 ).getCity().distanceTo( tour.get( size - 1 ).getCity() );
		return distance;
	}

	@Override
	public void insertInOrder(City c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertNearest(City c) {
		if( size == 0 )
		{
			size = 1;
			tour = new Node(c);
			return;
		}
		
		double dist = Double.POSITIVE_INFINITY;
		int nearest = 0;
		
		for( int i = 0; i < size; i++ )
		{
			if( tour.get( i ).getCity().distanceTo( c ) < dist )
			{
				dist = tour.get( i ).getCity().distanceTo( c );//pretty simple, keep track of smallest distance
				nearest = i;// and the point that gave that distance
			}
		}
		
		tour.insert( c, nearest );//then add that point
		
		size++;
		
	}

	@Override
	public void insertSmallest(City c) {
		if( size == 0 )
		{
			size = 1;
			tour = new Node(c);
			return;
		}
		
		double smallestIncrease = Double.POSITIVE_INFINITY;
		
		int index = 0;//handle the second point
		
		double originalD, newD;//HAHAHAHAHAHA... "newd" XD
		
		for( int i = 1; i < size; i++)
		{
			originalD = tour.get( i ).getCity().distanceTo( tour.get( i - 1 ).getCity() );//distance from A to B
			newD = c.distanceTo(tour.get( i ).getCity()) + c.distanceTo(tour.get( i - 1 ).getCity());//distance from A to P to B
			if( newD - originalD <= smallestIncrease )
			{
				smallestIncrease = newD - originalD;
				index = i - 1;
			}
		}
		originalD = tour.get( 0 ).getCity().distanceTo( tour.get( size - 1 ).getCity() );//distance from first to last
		newD = c.distanceTo(tour.get( 0 ).getCity()) + c.distanceTo(tour.get( size - 1 ).getCity());//distance from first to P to last
		if( newD - originalD <= smallestIncrease )
		{
			smallestIncrease = newD - originalD;
			index = size - 1;
		}
		
		tour.insert( c, index );
		size++;
		
	}
	
	
	
	
	
	


}

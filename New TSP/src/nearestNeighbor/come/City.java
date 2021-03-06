package nearestNeighbor.come;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class City{
	
	private int x;  // x coordinate of a City
	private int y; // y coordinate of a City 
	private String name; // name of City
	private static int nr; // number of City 
	
	/**  
	 *   Constructor for the Class City 
	 * @param x
	 * @param y
	 */
	public City(int x, int y) {
		this.x = x;
		this.y = y;
		this.name = "City" + nr++;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the nr
	 */
	public static int getNr() {
		return nr;
	}
	
	
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Calculate the Distance between two City with the help of 
	 * Pythagoras Theorem 
	 * @param p1
	 * @return  distance 
	 */
	public double distanceTo(City p1){
		double deltaX = (p1.getX() - this.x);
		double deltaY = (p1.getY() - this.y);
		double distance = Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
		return distance;
	}
	
	/**
	 *   Calculate the Distance between two City 
	 * @param p1
	 * @param p2
	 * @return distance
	 */
	public static double distanceBetween(City p1, City p2){
		double deltaX = (p2.getX() - p1.getX());
		double deltaY = (p2.getY() - p1.getY());
		double distance = Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
		return distance;	
	}
	
	/**
	 *   calculates Distance of a City to all other Cities and store the resort in an ArrayList
	 * @param cities
	 * @return distances
	 */
	public  List<Double> totalDistanceToAll(List<City> cities){
		List<Double> distnaces = new ArrayList<>();
		double origin = this.distanceTo(this);
		for( City city: cities){
			distnaces.add(this.distanceTo(city));	
			distnaces.remove(origin);
		}
		

		return distnaces;
	}
	
	/**
	 *   Calculate TotalDistance of a Given Tour
	 * @param tour
	 * @return
	 */
	public static double totalTourDistance(List<City> tour){
		double totalTourDistance = 0.0;
		
		for(int i =0,j=1; i< tour.size()&& j< tour.size(); i++,j++){
			totalTourDistance += tour.get(i).distanceTo(tour.get(j));
		}
		System.out.println(totalTourDistance);
		return totalTourDistance;
	}
	
	
	public String  toString(){
		return this.name +""+ "(" + this.x + ", " + this.y + ")"; 
	}
	
	
	public static void sortItems(List<City> sort){
		
		Collections.shuffle(sort);
	}

	
	public static <T extends Comparable<Double>> int findMinIndex(final List<Double> xs) {
	    int minIndex;
	    if (xs.isEmpty()) {
	        minIndex = -1;
	    } else {
	        final ListIterator<Double> itr = xs.listIterator();
	        Double min = itr.next(); // first element as the current minimum
	        minIndex = itr.previousIndex();
	        while (itr.hasNext()) {
	            final Double curr = itr.next();
	            if (((Comparable<Double>) curr).compareTo(min) < 0) {
	                min = curr;
	                minIndex = itr.previousIndex();
	            }
	        }
	    }
	    return minIndex;
	}
	
	
	
	public static List<City> testShortestPath(List<City> cities){
		List<City> pathTaken = new ArrayList<>();
		int number = 0;
//		while(number >= 0){
//			int nest = City.findMinIndex(cities.get(number).totalDistanceToAll(cities));
//			if(nest == 0) 
//			pathTaken.add(cities.get(nest));
//			number = nest;
//		}
			
		for(int i=0; i < cities.size(); i++){
			int nestCity = City.findMinIndex(cities.get(i).totalDistanceToAll(cities));
			pathTaken.add(cities.get(nestCity));
			cities.remove(i);	
		}
		
		double totaldistance = City.totalTourDistance(pathTaken) + pathTaken.get(pathTaken.size()-1).distanceTo(pathTaken.get(0));
		System.out.println(totaldistance);
		return pathTaken;
		
	}
	
	
	
	

	
	public static void main(String[] args) {
		
		 List<City> listt = new ArrayList<>();
		
		City c1 = new City(1,1);
		City c2 = new City(1,2);
		City c3 = new City(1,3);
		City c4 = new City(2,2);
		City c5 = new City(3,1);
		City c6 = new City(3,4);
		City c7 = new City(3,2);
		
		listt.add(c1);
		listt.add(c2);
		listt.add(c3);
		listt.add(c4);
		listt.add(c5);
		listt.add(c6);
		listt.add(c7);
		
//		System.out.println(c6.totalDistanceToAll(listt));
////		
//		System.out.println(findMinIndex(c6.totalDistanceToAll(listt)));
		
		System.out.println(City.testShortestPath(listt));
//		
////		System.out.println(listt);
////		City.totalTourDistance(listt);
////		System.out.println(listt);
////		
////		//		Collections.sort(listt, new SortCity());
////		
////		
////		System.out.println(listt);
//		
//		
//		
//
//		
//		
//		
//		
////		System.out.println(c1.totalDistanceToAll(listt));
////		System.out.println(c2.totalDistanceToAll(listt));
////		System.out.println(c3.totalDistanceToAll(listt));
////		System.out.println(c4.totalDistanceToAll(listt));
////		System.out.println(c5.totalDistanceToAll(listt));
////		System.out.println(c6.totalDistanceToAll(listt));
////		System.out.println(c7.totalDistanceToAll(listt));
//		
//	
//		
////		System.out.println(c1.distanceTo(c2));
////		System.out.println(c1.distanceTo(c3));
//
//			
//	
//		
//		
//
//		
//		
//		
//	}
//	
//	
//	
//	
	
	
	}
}

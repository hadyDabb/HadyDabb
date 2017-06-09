package tsp.nearestneighbor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route {
	
	private List<City> cities = new ArrayList<>();
	
	public Route(List<City> cities){
		this.cities.addAll(cities);
	}

	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}
	
	
	public double calculateTotalDistance(){
		int size = this.cities.size();
		double distance= 0.0;
		for(int i =0,j=1; i< size && j < size; i++,j++){
			distance += this.cities.get(i).distanceTo(this.cities.get(j));
		}
		return distance;
	}
	
	public String toString(){
		return Arrays.toString(cities.toArray());
	}

}

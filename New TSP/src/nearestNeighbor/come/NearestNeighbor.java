package nearestNeighbor.come;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class NearestNeighbor {
	
	public Route findShortestRoute(List<City> cities){
		List<City> shortestPath = new ArrayList<City>(cities.size());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Initial Route   ==>"+  Arrays.toString(cities.toArray()));
		System.out.println("w/  With Total Distance of "+ new Route(cities).calculateTotalDistance());
		City city = cities.get((int)(cities.size() * Math.random()));
		updateRoute(shortestPath, cities, city);
		while(cities.size() >= 1){
			city = getNextCity(cities,city);
			updateRoute(shortestPath, cities, city);
			
		}
		return new Route(shortestPath);
	}
	
	
	private void updateRoute (List<City> shortestPath, List<City> cities, City city){
		shortestPath.add(city);
		cities.remove(city);
		System.out.println("Cities in the Shortespath"+  Arrays.toString(shortestPath.toArray()));
		System.out.println(" Remaining Cities "+ Arrays.toString(cities.toArray()) +"\n");
		
		
	}
	
	private City getNextCity(List<City> cities, City city){
		return cities.stream().min((city1,city2)-> {
			int flag =0;
			if(city1.distanceTo(city) < city2.distanceTo(city)) flag = -1;
			else if(city1.distanceTo(city) > city2.distanceTo(city)) flag = 1;
					return flag;
		}).get();
		
	}
	
	
	public Route testShortestPath(List<City> cities){
		List<City> pathTaken = new ArrayList<>();
		
		for(int i=0; i < cities.size(); i++){
			int nestCity = City.findMinIndex(cities.get(i).totalDistanceToAll(cities));
			pathTaken.add(cities.get(nestCity));
			cities.remove(i);	
		}
		
		double totaldistance = City.totalTourDistance(pathTaken) + pathTaken.get(pathTaken.size()-1).distanceTo(pathTaken.get(0));
		System.out.println(totaldistance);
		return new Route(pathTaken);
		
	}

}

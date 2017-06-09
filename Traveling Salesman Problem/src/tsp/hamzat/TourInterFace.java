package tsp.hamzat;

public interface TourInterFace {
	
	void show(); 
	void draw(City c); 
	int size(); 
	double distance(); 
	void insertInOrder(City c);
	void insertNearest(City c); 
	void insertSmallest(City c);

}

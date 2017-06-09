package tsp.hamzat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCity implements Comparator<City>{


	
	
	
	
	
	
	@Override
	public int compare(City a, City b) {
	     if (a.getX() < b.getX()) {
             return -1;
         }
         else if (a.getX()> b.getX()) {
             return 1;
         }
         else {
             return 0;
         }
     }
	

	
	
	
	
	
	public void sortCity(List<City> sorted, int left, int right){
		if(!(sorted == null)){
			quickSOrted(sorted, left, right);
		}
	}
	
	
	
	


	
	
	
	private int quickSOrted(List<City> sorted, int left, int right){
		int first = left;
		int last = right;
		City pivot = sorted.get(left + right/2);
		
		while(first <= last){
			while(sorted.get(first).getX()< pivot.getX() && sorted.get(first).getY()< pivot.getY() ){
				first++;
			}
			while(sorted.get(last).getX() > pivot.getX() && sorted.get(last).getY() > pivot.getY()){
				last--;
			}
			
			if(first > last){
				
				City tempHigh = sorted.get(last);
				City tempLow = sorted.get(first);
				sorted.set(right, tempLow);
				sorted.set(left, tempHigh);
				first++;
				last--;
				
			}		
		}
		
		if (left < last)
			quickSOrted(sorted, left, last);
 
		if (right > first)
			quickSOrted(sorted, first, right);
			
		return first;
	}
	
	

}

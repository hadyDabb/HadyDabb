package tsp.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tsp.hamzat.City;

public class CityTest {

	City c1;
	City c2;
	City c3;
	City c4;
	City c5;
	City c6;
	City c7;
	
	
	

	@Test
	public void test_the_distance_to() {
		c1 = new City(3,6);
		c2 = new City(2,8);
		
		int  distance = (int) c1.distanceTo(c2);
		assertEquals(2, distance);
	}
	
	@Test
	public void test_the_distanceBetween(){
		c1 = new City(2,8);
		c2 = new City(3,6);
		int  distance = (int) City.distanceBetween(c1, c2);
		assertEquals(2, distance);
		
	}
	@Test
	public void test_TotalDistance_of_a_Tour(){
		
	}

}

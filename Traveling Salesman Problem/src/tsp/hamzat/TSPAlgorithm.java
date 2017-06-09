package tsp.hamzat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TSPAlgorithm {
	
	static List<City> cities = new ArrayList<>();
	
	public static void main(String[] args) {
		String file = "C:/Users/Hady/Desktop/TSP Example/verteilung-1.csv";
		readFile(file);

		
		
		
	}
	
	public static void readFile(String platz) {
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream(platz);
			reader = new BufferedReader(new InputStreamReader(fis));

			String line = reader.readLine();
			
			while (line != null) {

				StringTokenizer stringTokenizer = new StringTokenizer(line, ";");

				int x = Integer.parseInt(stringTokenizer.nextElement().toString());
				int y = Integer.parseInt(stringTokenizer.nextElement().toString());
				
				cities.add(new City(x,y));

				line = reader.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File not found, please check file location!");
		} catch (IOException ex) {
			System.out.println("IO Error while working with file.");
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				System.out.println("IO Error while working with closing file.");
			}
		}
	}


}

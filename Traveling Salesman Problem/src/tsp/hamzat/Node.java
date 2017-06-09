package tsp.hamzat;

public class Node
{
	private City city;
	private Node next;//this would all be so much easier if I could use C++
	
	public Node(City city)
	{
		this.city = city;
		next = null;
	}
	
	public Node(City city, Node n)
	{
		this.city = city;
		next = n;
	}
	
	public void insert(City city, int i)
	{
		i--;
		if(i >= 0)
		{
			next.insert(city, i); //Yo dawg, I heard you like insert methods...
		}
		else
		{
			Node n = next;
			next = new Node( city, n );
		}
	}
	
	public City getCity(){ return this.city; }
	
	public Node get(int index)
	{
		index--;
		if(index >= 0){ return next.get(index); }//recursive recursion
		
		return this;
	}
}


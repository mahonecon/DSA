package airline;

public class Airport 
{
	String name; boolean visited = false; // return true if this airport equals obj
	boolean hub = false;
	
	public Airport (String name) 
	{
		this.name =name;
	}
	
	public Airport(String name, boolean hub)
	{
		this.name = name;
		this.hub = hub;
	}
	
	public boolean equals(Object obj) 
	{
		if (!(obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		return name.equals(other.name);
	}
	
	public boolean changeToHub()
	{
		hub = true;
		return hub;
	}
	
	public String toString() {
		return name;
	}
}
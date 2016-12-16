package airline;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import list.Iterator;
import list.LinkedList;
import list.List;
import map.HashMap;
import map.Map;


public class Airline 
{
	Map<String,Airport> map;
	Map<String, List<Airport>> destMap;
	public static void main(String[] args)
	{
		Airline airline = new Airline();
		airline.getFlights();
		System.out.println("Map is "+ airline.map);
		System.out.println("Destination map "+ airline.destMap + "\n");
		System.out.println("Path from PHL to SFO : ");
		System.out.println(airline.path("PHL","SFO"));
    
	}
	
	private void getFlights()
	{
		File infile = new File("flights.txt");
		String flight,origin,dest;
		map = new HashMap<String,Airport>();
		destMap = new HashMap<String,List<Airport>>();  
		Airport o,d;
		List<Airport> dests;
		try
		{
			Scanner scanner = new Scanner(infile);
			while(scanner.hasNextLine())
			{
				flight = scanner.nextLine();
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
				if (! map.containsKey(origin))
				{	map.put(origin, new Airport(origin));	}
				if (! map.containsKey(dest))
				{	map.put(dest, new Airport(dest));	}    
				o = map.get(origin);
				d = map.get(dest);
				dests = destMap.get(origin);
				if (dests == null)
				{	dests = new LinkedList<Airport>();	}
				dests.add(d);
				destMap.put(origin,dests);
			}
			scanner.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found "+ fnfe);
		}
	}
	private List<Airport> path (String origin,String dest)
	{
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		List<Airport> result = path(o,d);
		getFlights();
		return result;
	}
	private List<Airport> path (Airport origin, Airport dest)
	{
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		if (origin.equals(dest))
		{
			result.add(origin);
			return result;
		}
		Airport port;
		if (! destMap.containsKey(origin.name))
        {	return result;	}
		Iterator<Airport> itty = destMap.get(origin.name).iterator();
		while(itty.hasNext())
		{
			port = itty.next();
			if (! port.visited)
			{
				result = path(port,dest);
				if (result.size()>0)
				{
					result.add(0,origin);
					return result;
				}
			}
		}
    return result;
	}
}
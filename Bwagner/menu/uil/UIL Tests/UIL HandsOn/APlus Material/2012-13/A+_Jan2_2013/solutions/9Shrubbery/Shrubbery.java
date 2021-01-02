import java.io.*;
import java.util.*;
import java.math.*;

class Shrubbery
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("shrubbery.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			int Q = f.nextInt();f.nextLine();
			Shrub [] shrubs = new Shrub[Q];
			for(int x = 0; x<Q; x++)
			{
					shrubs[x] = new Shrub(f.next(),f.nextInt(), f.nextDouble(), f.nextDouble());
			}
			String sort = f.next();
			for(int x = 0; x<Q; x++)
			{
					shrubs[x].sort = sort;
			}
			Arrays.sort(shrubs);
			for(int x = 0; x<Q; x++)
			{
					System.out.println(shrubs[x].name);
			}
			System.out.println();
		}
	}
}
class Shrub implements Comparable
{
	public String sort;
	public String name;
	public int nice;
	public double price;
	public double size;
	public Shrub(String n, int ni, double p, double s)
	{
		name = n;
		nice = ni;
		price = p;
		size = s; 
	}
	public int compareTo(Object o)
	{
		Shrub s = (Shrub)o;
		if(sort.equals("NICE"))
			return s.nice - this.nice;
		if(sort.equals("SIZE"))
			return (int) (s.size*100000 - this.size*100000);
		if(sort.equals("PRICE"))
			return (int) (this.price* 100000 - s.price* 100000);
		return 0;
	}
}
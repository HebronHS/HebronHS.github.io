import java.util.*;
import java.io.*;
public class Gender_Race
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("gender_race.dat"));
		int N = file.nextInt();file.nextLine();
		Racer[] racers = new Racer[N];
		while(N-->0)
		{
			racers[N] = new Racer(file.next(), file.nextInt(), file.next().charAt(0));
		}
		//overridden compareTo sorts upon shortest time
		Arrays.sort(racers);
		System.out.println(racers[0]);
		System.out.println(racers[1]);
		int out_count = 0;
		N = racers.length;
		//searches through entire array for first two male times
		for(int i=0;i<N;i++)
		{
			if(out_count>=2)
				break;
			if(racers[i].gender=='M')
			{
				System.out.println(racers[i]);
				out_count++;
			}
				
		}
		//searches through entire array for first two female times
		out_count = 0;
		for(int i=0;i<N;i++)
		{
			if(out_count>=2)
				break;
			if(racers[i].gender=='F'&&out_count<2)
			{
				System.out.println(racers[i]);
				out_count++;
			}
		}
		
	}
}
class Racer implements Comparable
{
	public String name;
	public int time;
	public char gender;
	public Racer(String name, int time, char gender)
	{
		this.name = name;
		this.time = time;
		this.gender = gender;
	}
	public int compareTo(Object o)
	{
		Racer r = (Racer) o;
		return (this.time-r.time);
	}
	public String toString()
	{
		return name+" "+time+" "+gender;
	}
}
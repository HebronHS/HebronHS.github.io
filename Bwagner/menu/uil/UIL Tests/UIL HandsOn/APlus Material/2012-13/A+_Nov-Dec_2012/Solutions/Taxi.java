//Sample solution for Taxi
import java.util.*;
import java.io.*;
public class Taxi
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("taxi.dat"));
		while(file.hasNext())
		{
			double ride = file.nextDouble();
			double wait = file.nextDouble();
			double ride_cost = 0;
			double wait_cost = 0;
			
			//if there is a ride, the first 1/5 mile will be 50 cents
			if(ride > 0)
				ride_cost = .5;
				
			int ride_int = (int)((ride-.2)*5);
			double ride_double = (ride-.2)*5;
			
			//any fraction less than 1/5 of a mile, needs add an additional 22 cents
			if((double)ride_int != ride_double)
				ride_cost +=.22;
			ride_cost += ride_int * .22;
			
			int wait_int = (int)wait/60;
			double wait_double = (wait/60.0);
			
			//any fraction less than one minute, needs add an additional 20 cents
			if((double)wait_int != wait_double)
				wait_cost+=.2;
			wait_cost += wait_int*.2;

			System.out.printf("$%.2f\n",(ride_cost+wait_cost));
		}
	}
}

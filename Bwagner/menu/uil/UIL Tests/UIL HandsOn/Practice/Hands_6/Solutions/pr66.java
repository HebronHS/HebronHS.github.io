import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr66
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr66.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
    	for(int z = 0; z < times; z++)  { 
    	    double cost = Double.parseDouble(kb.nextLine().trim());	
    	    // adding .01 will take care of round off errors going from double to int	
    	    int change = 100 - (int) (cost * 100 + .01) % 100;   // subtract pennies from $1
    	    int quarters = change / 25;
    	    change %= 25;
    	    int dimes = change / 10;
    	    change %= 10;
    	    int nickels = change / 5;
    	    change %= 5;				// pennies left
    	    out.printf("Q: %d  D: %d  N: %d  P: %d\n", quarters, dimes, nickels, change);
		}
		
   	}
}


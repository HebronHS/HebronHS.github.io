import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr63
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr63.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
    	int totalMinutes=0;
    	for(int z = 0; z < times; z++)  { 
    		String[] s =  kb.nextLine().trim().split("[ :]");
    	    int hours1 = Integer.parseInt(s[0]);		// get hours and minutes of each call
    	    int minutes1 = Integer.parseInt(s[1]);
    	    int hours2 = Integer.parseInt(s[2]);
    	    int minutes2 = Integer.parseInt(s[3]);
    	    // convert hours and minutes to minutes and add to total
    	    totalMinutes += (hours2 - hours1)*60 + (minutes2-minutes1);
		}
		out.println("TOTAL MINUTES: " + totalMinutes);
   	}
}


import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr68
{
	public static void main (String[] args) throws IOException
  	{
    	Scanner kb = new Scanner(new File("pr68.dat"));
    	int times = Integer.parseInt(kb.nextLine().trim());
    	int totalMinutes=0;
    	for(int z = 0; z < times; z++)  { 
    		String[] s =  kb.nextLine().trim().split("[ :]");
    	    int hours1 = Integer.parseInt(s[0]);		// get hours and minutes of each call
    	    int minutes1 = Integer.parseInt(s[1]);
    	    String ampm1 = s[2];
    	    int hours2 = Integer.parseInt(s[3]);
    	    int minutes2 = Integer.parseInt(s[4]);
    	    String ampm2 = s[5];
    	    if(ampm1.equals(ampm2)) {
    	    // convert hours and minutes to minutes and add to total
    	    	totalMinutes += (hours2 - hours1)*60 + (minutes2-minutes1);
    	 	}
    	 	else {
    	 	// get minutes before noon and minutes after noon and add to total
    	 		totalMinutes += (12 - hours1)*60 - minutes1;
    	 		totalMinutes += hours2%12 * 60 + minutes2;
    	 	}
		}
		out.println("TOTAL MINUTES: " + totalMinutes);
   	}
}


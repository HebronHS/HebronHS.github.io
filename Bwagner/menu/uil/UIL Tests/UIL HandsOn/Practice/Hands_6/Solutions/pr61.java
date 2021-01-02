import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr61
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr61.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      	
      for(int z = 0; z < times; z++)  {  
          String[] s = kb.nextLine().trim().split(" ");
          int tempTemp = Integer.parseInt(s[1]);
          String maxTime=s[0]; int maxTemp = tempTemp;
		  String minTime=s[0]; int minTemp = tempTemp;
      	  
      	  for(int i = 2; i < s.length; i+=2) {
	          tempTemp = Integer.parseInt(s[i+1]);
		  	  if( tempTemp > maxTemp) {
			  	  maxTime = s[i];
			  	  maxTemp = tempTemp;
			  }	  	   		
		  	  else if (tempTemp == maxTemp)  
		  	  	  if(s[i].compareTo(maxTime) > 0)	{	// new entry is earlier
			  	  		maxTime = s[i];
			  	   		maxTemp = tempTemp;
			  	  }	
			  if(tempTemp < minTemp) {
			  	  minTime = s[i];
			  	  minTemp = tempTemp;
			  }	  	   		
		  	  else if (tempTemp == minTemp)  
		  	  	  if(s[i].compareTo(minTime) < 0)	{	// new entry is earlier
			  	  		minTime = s[i];
			  	   		minTemp = tempTemp;
			  	  }	
		  }
		  out.println("LOW:  " + minTemp + " OCCURRED AT " + minTime);
		  out.println("HIGH: " + maxTemp + " OCCURRED AT " + maxTime);
      	  out.println();  
      }	
   }
}

